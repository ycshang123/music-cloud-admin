package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongMapperTest {
    @Resource
    private SongMapper songMapper;

    @Test
    void test(){
        List<Song> list = songMapper.selectList(null);
        System.out.println(list);
    }


}