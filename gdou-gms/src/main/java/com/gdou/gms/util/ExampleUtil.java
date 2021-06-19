package com.gdou.gms.util;

import cn.hutool.core.util.StrUtil;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.UserInfoExample;

public class ExampleUtil
{

    public static UserInfoExample createUserInfoExample(Condition condition)
    {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();

        if (StrUtil.isNotBlank(condition.getUsername()))
        {
            criteria.andUsernameLike("%" + condition.getUsername() + "%");
        }
        if (StrUtil.isNotBlank(condition.getGender()))
        {
            criteria.andGenderEqualTo(condition.getGender());
        }
        if (condition.getRoleid() != null)
        {
            criteria.andRoleidEqualTo(condition.getRoleid());
        }

        return example;
    }
}