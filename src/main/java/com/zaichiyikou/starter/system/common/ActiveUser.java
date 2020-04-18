package com.zaichiyikou.starter.system.common;

import java.util.List;

import com.zaichiyikou.starter.system.pojo.SysUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser {
    private SysUser user;
    private List<String> roles;
    private List<String> permissions;
}
