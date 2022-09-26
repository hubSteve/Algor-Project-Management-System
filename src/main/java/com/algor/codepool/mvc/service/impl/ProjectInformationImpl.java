package com.algor.codepool.mvc.service.impl;

import com.algor.codepool.mvc.bean.ProjectInformation;
import com.algor.codepool.mvc.dao.ProjectInformationDao;
import com.algor.codepool.mvc.service.ProjectInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectInformationImpl implements ProjectInformationService {

    @Autowired
    ProjectInformationDao proInfoDao;

    @Override
    public List<ProjectInformation> findAll(ProjectInformation proInfo) {
        Example<ProjectInformation> example = Example.of(proInfo);
        return proInfoDao.findAll(example);
    }

    @Override
    public Integer create(ProjectInformation proInfo) {
        proInfoDao.saveAndFlush(proInfo);
        return 1;
    }
}
