package cn.ydimall.recharge.cmcc.controller;

import cn.ydimall.recharge.cmcc.pojo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by zhongruhang on 2017/12/18
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String hello() {
        return "你好，管理员";
    }
}
