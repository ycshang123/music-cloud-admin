package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.entity.Song;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.service.SysAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2020-04-21
 */

@RestController
@RequestMapping("/api")

public class SongController {
    @Resource
    private SysAdminService sysAdminService;

    @PostMapping("/song")
    @ControllerWebLog
    public ResponseEntity<Song> saveSong(@RequestBody @Valid Song song) {
        return ResponseEntity.ok().body(song);
    }

    @PostMapping("/update")
    @ControllerWebLog
    ResponseResult updateAdmin(@RequestBody @Valid SysAdmin sysAdmin) {
        return sysAdminService.updateAdmin(sysAdmin);
    }
}
