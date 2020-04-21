package com.zaichiyikou.starter.system.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zaichiyikou.starter.system.pojo.SysRole;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色VO
 * 
 * @author zaichiyikoua
 * @since 2020-4-21
 */

@Data
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
public class SysRoleVo extends SysRole {

    private Integer page = 1;
    private Integer limit = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
