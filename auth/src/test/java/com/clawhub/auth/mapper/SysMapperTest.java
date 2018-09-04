package com.clawhub.auth.mapper;

import com.clawhub.auth.AuthApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApp.class)
public class SysMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysResourceMapper sysResourceMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Test
    public void selectAll() {
//        System.out.println(sysUserMapper.selectAll());
//        System.out.println(sysRoleMapper.selectAll().get(0).getRoleName());
//        System.out.println(sysResourceMapper.selectAll().get(0).getPermission());
//        System.out.println(userRoleMapper.selectAll().get(0).getRoleId());
//        System.out.println(roleResourceMapper.selectAll().get(0).getRoleId());
//        System.out.println(userRoleMapper.findRoleIdsByUserId("0"));
        List<String> roleIds = new ArrayList<>();
        roleIds.add("0");
        System.out.println(sysRoleMapper.findRoleNamesByRoleIds(roleIds));
    }
}