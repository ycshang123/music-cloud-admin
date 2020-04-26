package com.soft1851.music.admin.service;

import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ychsang
 * @since 2020-04-21
 */
public interface SongTypeService extends IService<SongType> {

    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    List<SongType> getSongTypeByPage(PageDto pageDto);

    /**
     * 模糊查询
     * @param filed
     * @return
     */
    List<SongType> fuzzySearch(String filed);


    /**
     * 批量删除
     * @param lists
     * @return
     */
    ResponseResult bacthDeleteById(String lists);

}
