package com.gdou.gms.service;

import cn.hutool.core.thread.ThreadUtil;
import com.gdou.gms.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest
{

    @Autowired
    private MailService mailService;

    public void test()
    {
        for (int i = 0; i < 99999999; i++)
        {

        }

        System.out.println("打印成功");
    }

    @Test
    void sendAddMail()
    {
        UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        // mailService.sendSetMail(userInfo);



        try
        {
            // mailService.sendSetMail(userInfo);

            for (int i = 0; i < 10; i++)
            {

            }

            ThreadUtil.execute(() -> mailService.sendSetMail(userInfo));

            // ThreadUtil.execAsync();
            System.out.println("添加成功");

        } catch (Exception e)
        {
            System.out.println("发送失败");
        }

    }

    @Test
    void sendRemoveMail()
    {
        UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        mailService.sendRemoveMail(userInfo);
    }

    @Test
    void sendRandomStringMail()
    {
        // UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        System.out.println(mailService.sendRandomStringMail(null));
    }
}