package com.sheefee.simple.sso.server.controller;

import com.sheefee.simple.sso.client.constant.AuthConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证中心页面显示控制器
 *
 * @author sheefee
 * @date 2017年9月12日 下午2:17:19
 */
@Controller
public class IndexController {
    /**
     * 登录页面
     *
     * @param request
     * @param model
     * @return
     * @author sheefee
     * @date 2017年9月12日 下午2:17:51
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute(AuthConst.CLIENT_URL, request.getParameter(AuthConst.CLIENT_URL));
        return "index";
    }

    /**
     * 登录成功页面
     *
     * @return
     * @author sheefee
     * @date 2017年9月12日 下午2:18:02
     */
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}