//package com.doraemon.lottery.login.service;
//
//import com.doraemon.lottery.login.dao.MenuDao;
//import com.doraemon.lottery.login.dao.RoleDao;
//import com.doraemon.lottery.login.dao.UserDao;
//import com.doraemon.lottery.login.entity.Menu;
//import com.doraemon.lottery.login.entity.Role;
//import com.doraemon.lottery.login.entity.UserEntity;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private RoleDao roleDao;
//    @Autowired
//    private MenuDao menuDao;
//
//    @Override
//    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 根据用户名查找用户
//        UserEntity user = userDao.getUserByUsername(username);
//        System.out.println(user);
//        if (user != null) {
//            System.out.println("UserDetailsService");
//            //根据用户id获取用户角色
//            List<Role> roles = roleDao.getUserRoleByUserId(user.getId());
//            // 填充权限
//            Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
//            List<Long> roleIds = new ArrayList<>();
//            for (Role role : roles) {
//                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//                roleIds.add(role.getId());
//            }
//            //填充权限菜单
//            List<Menu> menus=menuDao.getRoleMenuByRoles(roleIds);
//            return new UserEntity(username,user.getPassword(),authorities,menus);
//        } else {
//            System.out.println(username +" not found");
//            throw new UsernameNotFoundException(username +" not found");
//        }
//    }
//}
