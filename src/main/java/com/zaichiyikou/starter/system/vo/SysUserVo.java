package com.zaichiyikou.starter.system.vo;

import com.zaichiyikou.starter.system.pojo.SysUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户类VO
 * 
 * @author zaichiyikoua
 * @since 2020-4-21
 */

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVo extends SysUser {
    private Integer page;
    private Integer limit;
}
