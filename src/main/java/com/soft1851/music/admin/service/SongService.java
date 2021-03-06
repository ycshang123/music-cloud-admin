package com.soft1851.music.admin.service;

import com.soft1851.music.admin.entity.Song;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2020-04-21
 */
public interface SongService extends IService<Song> {
    /**
     * 导出数据
     */
    void exportData();

}
