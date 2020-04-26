package com.soft1851.music.admin.service;

import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ycshang
 * @since 2020-04-21
 */
public interface SongListService extends IService<SongList> {
    /**
     * 分页查询所有歌单
     *
     * @param pageDto
     * @return
     */
    ResponseResult searchSongList(PageDto pageDto);

    /**
     * 分页查询
     *
     * @param pageDto
     * @return
     */
    Map<String, Object> getByPage(PageDto pageDto);

    /**
     * 模糊查询
     *
     * @param filed
     * @return
     */
    List<SongList> fuzzySearch(String filed);

    /**
     * 查询所有歌单
     *
     * @return
     */
    List<Map<String, Object>> selectAll();


    /**
     * 根据id删除歌单
     *
     * @param id
     * @return
     */
    ResponseResult deleteSongList(String id);


    /**
     * 修改歌单数据
     *
     * @param songList
     * @return
     */
    ResponseResult updateSongList(SongList songList);

    /**
     * 批量删除
     *
     * @param idLists
     * @return
     */
    ResponseResult batchDeleteById(String idLists);

    /**
     * 根据type字段进行分组，将每种类型的所有歌单作为该类型的子菜单
     *
     * @return
     */
     List<Map<String, Object>> getByType();


    /**
     * 分页查询
     * @param field
     * @return
     */
    List<SongList> blurSelect(String field);
}
