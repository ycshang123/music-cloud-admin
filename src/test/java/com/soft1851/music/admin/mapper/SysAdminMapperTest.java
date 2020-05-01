package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysAdminMapperTest {
@Resource
private  SysAdminMapper sysAdminMapper;
    @Test
    void selectByname() {
        SysAdmin sysAdmin = sysAdminMapper.selectById("music");
        System.out.println("admin基础信息");
        System.out.println(sysAdmin.getId());
        System.out.println(sysAdmin.getName());
        System.out.println(sysAdmin.getAvatar());
        System.out.println("他的所有角色：");
        List<SysRole> roles = sysAdmin.getRoles();
        for(SysRole role :roles){
            System.out.println(role.getRoleId() + ":" +role.getRoleName());
        }
    }

    @Test
    void getSysAdminByName() {
        System.out.println(sysAdminMapper.getSysAdminByName("music"));
    }

    @Test
   void updateInfo() {
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId("22516FB6A9D389D7FC21420806150A7B");
        sysAdmin.setName("123");
        sysAdmin.setPhone("123");
        sysAdmin.setGender("男");
        sysAdmin.setAddress("日本");
        sysAdminMapper.updateById(sysAdmin);
    }
}