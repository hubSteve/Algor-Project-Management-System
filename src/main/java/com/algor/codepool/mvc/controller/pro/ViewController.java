package com.algor.codepool.mvc.controller.pro;

import com.algor.codepool.mvc.bean.ProjectInformation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pro/view")
public class ViewController {

    @RequestMapping("/query")
    public String query(@RequestBody ProjectInformation proInfo) {

        return "";
    }

    public String create() {
        return "";
    }

    public String update() {
        return "";
    }

    public String delete() {
        return "";
    }
}
