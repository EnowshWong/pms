package com.pms.inteceptor;

import com.pms.common.utils.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:wong
 */
@Component
public class LoginInteceptor implements HandlerInterceptor{

    @Value("${COOKIE_USERNAME}")
    private String COOKIE_USERNAME;
    @Value("${LOGIN_PAGE_URL}")
    private String LOGIN_PAGE_URL;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //直接从cookie中取username
        String username=CookieUtils.getCookieValue(request,COOKIE_USERNAME);
        //判断其是否为空
        if (StringUtils.isBlank(username)){
            //是空的话强制跳转到首页登陆页面
            response.sendRedirect(LOGIN_PAGE_URL);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
