package jp.co.rjc.community_board.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TopController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
