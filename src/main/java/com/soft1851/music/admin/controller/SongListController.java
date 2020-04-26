package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
import com.soft1851.music.admin.service.SongListService;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2020-04-21
 */
@Slf4j
@RestController
@RequestMapping("/songList")
public class SongListController {
    @Resource
    private SongListService songListService;

    /**
     * 查询所有歌单
     *
     * @return
     */
    @GetMapping("/all")
    public List<Map<String, Object>> getSongListAll() {
        return songListService.getByType();
    }

    /**
     * 查询歌单
     *
     * @param pageDto
     * @return
     */
    @PostMapping("/blur/page")
    public ResponseResult getAllSongList(@RequestBody PageDto pageDto) {
        return songListService.searchSongList(pageDto);
    }

    /**
     * 分页查询歌单数据
     *
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    public Map<String, Object> getSongListByPage(@RequestBody PageDto pageDto) {
        return songListService.getByPage(pageDto);
    }


    /**
     * 根据关键字模糊查询
     *
     * @param field
     * @return
     */
    @GetMapping("/blur")
    public List<SongList> fuzzySearch(@Param("field") String field) {
        return songListService.fuzzySearch(field);
    }

    /**
     * 根据歌单id删除歌单数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    ResponseResult deleteSongListById(@Param("id") String id) {
        return songListService.deleteSongList(id);
    }


    /**
     * 修改歌单信息
     *
     * @param songList
     * @return
     */

    @PutMapping("/update")
    ResponseResult updateSongList(@RequestBody SongList songList) {
        return songListService.updateSongList(songList);
    }


    /**
     * 批量删除歌单
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/batchDelete")
    ResponseResult batchDeleteById(@Param("ids") String ids) {
        return songListService.batchDeleteById(ids);
    }

    @GetMapping("/search")
    public List<SongList> blurSelect(String field) {
        return songListService.blurSelect(field);
    }


}
