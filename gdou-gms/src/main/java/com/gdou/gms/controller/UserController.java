package com.gdou.gms.controller;

import cn.hutool.json.JSONObject;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.UserService;
import com.gdou.gms.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class UserController
{
    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @GetMapping("/getMsg")
    public String getMsg()
    {
        return "你好";
    }

    // 验证token的有效性
    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request)
    {
        return JwtUtil.checkToken(request.getHeader("token"));
    }

    // 登录
    @PostMapping("/login")
    public Object login(@Validated @RequestBody User user)
    {
        // System.out.println(user);
        UserInfo userInfo = userService.login(user);

        // 登录成功
        if (userInfo != null)
        {
            JSONObject jsonObject = new JSONObject();
            String token = JwtUtil.createToken(userInfo);

            jsonObject.putOpt("userInfo", userInfo);
            jsonObject.putOpt("token", token);

            session.setAttribute("user", userInfo);
            // System.out.println("sessionId=" + session.getId());

            return jsonObject;
        }

        // 失败
        return null;
    }

    // 添加普通用户
    @GetMapping("/addUsers")
    public Object addUsers(@RequestParam(value = "usersJson") String jsonString)
    {
        JSONObject jsonObject = new JSONObject();
        Integer add = userService.addUsers(jsonString);

        if (add != -1)
        {
            jsonObject.putOpt("msg", "添加用户成功");
            jsonObject.putOpt("count", add);
        }
        else
        {
            jsonObject.putOpt("msg", "添加用户失败");
        }

        return jsonObject;
    }

    // 设置管理员权限
    @GetMapping("/setAdmin")
    public Boolean setAdministrator(@RequestParam(value = "userId") String userId)
    {
        return userService.setAdministrator(userId);
    }

    // 更新密码
    @PostMapping("/updatePassword")
    public Boolean updatePassword(@RequestParam(value = "originalPwd") String originalPwd, @RequestBody User user)
    {
        System.out.println("原密码" + originalPwd);
        System.out.println("用户userId + 新密码" + user);

        return userService.updatePassword(originalPwd, user);
    }

    // 更新用户信息
    @PostMapping("/updateUserInfo")
    public Boolean updateUserInfo(@RequestBody UserInfo userInfo)
    {
        return userService.updateUserInfo(userInfo);
    }

    // 查询一个用户的信息
    @GetMapping("/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam(value = "userId") String userId)
    {
        return userService.queryUserInfo(userId);
    }

    // 查询所有用户
    @GetMapping("/queryAllUsers")
    public List<UserInfo> queryUserInfo()
    {
        return userService.queryAllUsers();
    }

    // 根据条件查询用户
    @PostMapping("/queryUsersByCondition")
    public List<UserInfo> queryUsersByCondition(@RequestBody Condition condition)
    {
        return userService.queryUsersByCondition(condition);
    }

    // 删除用户
    @GetMapping("/deleteUser")
    public Boolean deleteUser(@RequestParam(value = "userId") String userId)
    {
        return userService.deleteUser(userId);
    }

    // 移除管理员权限
    @GetMapping("/removeAdmin")
    public Boolean removeAdministrator(@RequestParam(value = "userId") String userId)
    {
        return userService.removeAdministrator(userId);
    }

}
