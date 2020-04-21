package com.zaichiyikou.starter.system.vo;

import com.zaichiyikou.starter.system.pojo.SysPermission;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统权限VO
 * 
 * @author zaichiyikoua
 * @since 2020-4-21
 */

@Data
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
public class SysPermissionVo extends SysPermission {
    private Integer page = 1;
    private Integer limit = 10;
}
