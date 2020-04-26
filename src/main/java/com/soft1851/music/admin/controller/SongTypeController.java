package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;
import com.soft1851.music.admin.service.SongTypeService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/songType")
public class SongTypeController {
    @Resource
    private SongTypeService songTypeService;

    /**
     * 分页查找
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    public List<SongType> getSongListByPage(@RequestBody PageDto pageDto){
        return  songTypeService.getSongTypeByPage(pageDto);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */

    @DeleteMapping("/batchDelete")
    ResponseResult batchDeleteById(@Param("ids") String ids){
        return songTypeService.bacthDeleteById(ids);
    }

    @GetMapping("/blur")
    public List<SongType> fuzzySearch(@Param("field") String field){
        return songTypeService.fuzzySearch(field);
    }

}
