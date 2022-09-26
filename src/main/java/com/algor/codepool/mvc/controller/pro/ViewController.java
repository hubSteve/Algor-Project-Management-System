package com.algor.codepool.mvc.controller.pro;

import com.algor.codepool.common.term.Result;
import com.algor.codepool.mvc.bean.ProjectInformation;
import com.algor.codepool.mvc.service.ProjectInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro/view")
@CrossOrigin(origins = {"http://localhost:63342"})
public class ViewController {

    @Autowired
    ProjectInformationService proInfoService;

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Result<?> findAll(@RequestBody ProjectInformation proInfo) {
        Result<List<ProjectInformation>> result = new Result<>();
        try {
            List<ProjectInformation> ans = proInfoService.findAll(proInfo);
            result.setObj(ans);
            result.setCode(200);
            result.setMessage("查询项目信息成功!");
        } catch (Exception e) {
            result.setCode(400);
            result.setMessage("查询项目信息失败，原因为：", e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<?> create(@RequestBody ProjectInformation proInfo) {
        Result<List<ProjectInformation>> result = new Result<>();
        try {
            proInfoService.create(proInfo);
            result.setCode(200);
            result.setMessage("保存项目信息成功!");
        }catch (Exception e) {
            result.setCode(400);
            result.setMessage("保存项目信息失败，失败原因：", e.getMessage());
        }
        return result;
    }

    public String update() {
        return "";
    }

    public String delete() {
        return "";
    }
}
