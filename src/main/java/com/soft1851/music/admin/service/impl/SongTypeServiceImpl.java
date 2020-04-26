package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;
import com.soft1851.music.admin.mapper.SongTypeMapper;
import com.soft1851.music.admin.service.SongTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-21
 */
@Service
public class SongTypeServiceImpl extends ServiceImpl<SongTypeMapper, SongType> implements SongTypeService {
    @Resource
    private SongTypeMapper songTypeMapper;

    @Override
    public List<SongType> getSongTypeByPage(PageDto pageDto) {
        Page<SongType> page = new Page<>(pageDto.getCurrentPage(), pageDto.getPageSize());
        QueryWrapper<SongType> wrapper = new QueryWrapper<>();
        IPage<SongType> iPage = songTypeMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

    @Override
    public List<SongType> fuzzySearch(String filed) {
        QueryWrapper<SongType> wrapper = new QueryWrapper<>();
        wrapper.like("type_name", filed);
        return songTypeMapper.selectList(wrapper);
    }

    @Override
    public ResponseResult bacthDeleteById(String lists) {
        String[] ids = lists.split(",");
        List<String> allIds = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            allIds.add(ids[i]);
        }
        songTypeMapper.deleteBatchIds(allIds);
        return ResponseResult.success();
    }
}
