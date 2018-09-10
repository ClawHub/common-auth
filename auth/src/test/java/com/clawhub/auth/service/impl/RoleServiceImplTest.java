//package com.clawhub.auth.service.impl;
//
//import com.clawhub.auth.AuthApp;
//import com.clawhub.auth.service.RoleService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AuthApp.class)
//public class RoleServiceImplTest {
//    @Autowired
//    private RoleService roleService;
//
//    @Test
//    public void findRolesByUser() {
//        Set<String> roleNames = roleService.findRoleNamesByUserId("0");
//        for (String roleName : roleNames) {
//            System.out.println(roleName);
//        }
//    }
//}