package com.gdou.gms.interceptor;

import com.gdou.gms.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 做登录检查，判断是否已经进行登录，没登录直接跳转到登录页面
/**
 * 步骤：
 * 1.配置拦截器要拦截的请求
 * 2.把这些配置放在容器中
 *
 */
public class LoginInterceptor implements HandlerInterceptor
{

    /**
     * 在目标方法执行之前，在这里做登录检查
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 放行
        if (user != null)
        {
            return true;
        }

        // 拦截，然后重定向到登录页面
        response.sendRedirect("/");

        return false;
    }

    /**
     * 在目标方法执行后，但还没进行页面跳转
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    /**
     * 在页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}