package com.algor.codepool.mvc.controller.pro;

import com.algor.codepool.common.term.Result;
import com.algor.codepool.mvc.bean.ProjectInformation;
import com.algor.codepool.mvc.service.ProjectInformationService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ProjectInformationController {

    @Autowired
    ProjectInformationService proInfoService;

    @PostMapping("/findAll")
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

    @PostMapping("/create")
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

    @PostMapping("/update")
    public Result<?> update(@RequestBody ProjectInformation proInfo) {
        Result<ProjectInformation> result = new Result<>();
        try {
            proInfoService.update(proInfo);
            result.setCode(200);
            result.setMessage("更新成功!");
        } catch (Exception e) {
            result.setCode(400);
            result.setMessage("更新失败!");
        }
        return result;
    }

    @GetMapping(value = "delete/{id}")
    public Result<?> delete(@PathVariable(name = "id") String id) {
        Result<ProjectInformation> result = new Result<>();
        try{
            proInfoService.deleteById(id);
            result.setCode(200);
        } catch (Exception e) {
            result.setCode(400);
        }
        return result;
    }
}
