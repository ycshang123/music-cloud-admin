package com.soft1851.music.admin.service.impl;

import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.mapper.SysAdminMapper;
import com.soft1851.music.admin.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.music.admin.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-21
 */
@Service
@Slf4j
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {
@Resource
private SysAdminMapper sysAdminMapper;

    @Override
    public SysAdmin getAdminAndRolesByName(String name) {
       return sysAdminMapper.selectByName(name);
    }

    @Override
    public boolean login(LoginDto loginDto) {
        SysAdmin sysAdmin = sysAdminMapper.getSysAdminByName(loginDto.getName());
        if (sysAdmin != null){
          String pass =  Md5Util.getMd5(loginDto.getPassword(),true,32);
          if(sysAdmin.getPassword().equals(pass)){
              return true;
          }else{
              log.error("密码错误");
              throw new CustomException("密码错误", ResultCode.USER_PASSWORD_ERROR);
          }
        }else{
            log.error("用户名不存在");
            throw new CustomException("用户名不存在",ResultCode.USER_NOT_FOUND);
        }

    }

    @Override
    public ResponseResult updateAdmin(SysAdmin sysAdmin) {
//        SysAdmin sysAdmin1 = sysAdminMapper.getSysAdminById(sysAdmin.getId());
        SysAdmin sysAdmin1 = new SysAdmin();
        sysAdmin1.setId(sysAdmin.getId());
        sysAdmin1.setName(sysAdmin.getName());
        sysAdmin1.setPhone(sysAdmin.getPhone());
        sysAdmin1.setGender(sysAdmin.getGender());
        sysAdmin1.setAddress(sysAdmin.getAddress());
        sysAdminMapper.updateById(sysAdmin1);
        return ResponseResult.success(sysAdmin1);
    }
}
