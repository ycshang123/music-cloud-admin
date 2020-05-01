package com.soft1851.music.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soft1851.music.admin.annotation.PhoneNumber;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

/**
 * <p>
 *
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_admin")

public class SysAdmin extends Model<SysAdmin> {

    private static final long serialVersionUID = 1L;


    private List<SysRole> roles;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 密码
     */
    @JsonIgnore
    @TableField("pass word")
    private String password;

    /**
     * 加密盐
     */
    @JsonIgnore
    @TableField("salt")
    private String salt;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @JsonIgnore
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 账户状态：0 禁用 1 启用
     */
    @JsonIgnore
    @TableField("status")
    private Integer status;

    /**
     * 手机号
     */
    @PhoneNumber
    @TableField("phone")
    private String phone;

    /**
     * 性别
     */
    @Pattern(regexp = "((^男$|^女$|^UGN$))",message = "sex 值不在可选范围内")
    @TableField("gender")
    private String gender;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
