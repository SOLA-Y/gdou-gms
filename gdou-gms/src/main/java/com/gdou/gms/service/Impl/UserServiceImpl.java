package com.gdou.gms.service.Impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.gdou.gms.mapper.UserInfoMapper;
import com.gdou.gms.mapper.UserMapper;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;
import com.gdou.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(User user)
    {
        List<User> userList = userMapper.selectByExample(null);
        String password = DigestUtil.md5Hex(user.getPassword());

        for (User user1 : userList)
        {
            if (user.getUserid().equals(user1.getUserid()) && password.equals(user1.getPassword()))
            {
                return userInfoMapper.selectByPrimaryKey(user1.getUserid());
            }
        }

        return null;
    }

    // @Transactional：事务，将下面的所有操作视为一个操作，所有操作成功才提交到数据库，不然就回滚
    @Override
    @Transactional
    public Boolean addAdministrator(UserInfo userInfo, User user)
    {
        int update1 = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        int update2 = userMapper.updateByPrimaryKeySelective(user);

        return update1 == update2 && update1 != 0;
    }

    @Override
    @Transactional
    public Boolean addUsers(List<UserInfo> userInfoList, List<User> userList)
    {
        int insert1 = 0;
        int insert2 = 0;

        for (UserInfo userInfo : userInfoList)
        {
            insert1 += userInfoMapper.insert(userInfo);
        }

        for (User user : userList)
        {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
            insert2 += userMapper.insert(user);
        }

        return insert1 == insert2;
    }

    @Override
    public Boolean updatePassword(String originalPassword, User user)
    {
        String password = DigestUtil.md5Hex(originalPassword);
        User dbUser = userMapper.selectByPrimaryKey(user.getUserid());

        if (password.equals(dbUser.getPassword()))
        {
            int update = userMapper.updateByPrimaryKeySelective(user);

            return update != 0;
        }

        return false;
    }

    @Override
    public Boolean updateUserInfo(UserInfo userInfo)
    {
        int update = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        return update != 0;
    }

    @Override
    public UserInfo queryUserInfo(String userId)
    {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserInfo> queryAllUsers()
    {
        return userInfoMapper.selectByExample(null);
    }

    @Override
    public List<UserInfo> queryUsersByCondition(UserInfoExample example)
    {
        return userInfoMapper.selectByExample(example);
    }


}
