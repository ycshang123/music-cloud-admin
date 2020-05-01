package com.soft1851.music.admin.service;

import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysAdminServiceTest {
    @Resource
    private  SysAdminService sysAdminService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder().name("mqxu").password("123456").build();
        if(sysAdminService.login(loginDto)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }

    @Test
    void getAdminAndRolesByName() {
        SysAdmin sys = sysAdminService.getAdminAndRolesByName("music");
        System.out.println(sys);
    }

    @Test
    void updateAdmin() {
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId("22516FB6A9D389D7FC21420806150A7B");
        sysAdmin.setName("123");
        sysAdmin.setPhone("123");
        sysAdmin.setGender("男");
        sysAdmin.setAddress("徐州");
        sysAdminService.updateAdmin(sysAdmin);
    }
}