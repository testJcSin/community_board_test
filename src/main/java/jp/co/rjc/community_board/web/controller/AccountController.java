package jp.co.rjc.community_board.web.controller;

import jp.co.rjc.community_board.service.UserService;
import jp.co.rjc.community_board.web.form.AccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/account/login/")
    public String login() {
        return "account/login";
    }

    @RequestMapping(value = "/account/register/", method = RequestMethod.GET)
    public String registInput() {
        return "account/regist";
    }

    @RequestMapping(value = "/account/register/", method = RequestMethod.POST)
    public String regist(AccountForm accountForm) {
        userService.reg2(accountForm.getUsername(), accountForm.getPassword(), accountForm.getMailAddress());
        return "redirect:/";
    }

}
