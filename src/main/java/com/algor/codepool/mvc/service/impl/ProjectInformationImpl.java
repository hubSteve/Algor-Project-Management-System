package com.algor.codepool.mvc.service.impl;

import com.algor.codepool.common.utils.QueryUtils;
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
        if (QueryUtils.isEmpty(proInfo)) {
            return proInfoDao.findAll();
        }
        Example<ProjectInformation> example = Example.of(proInfo);
        return proInfoDao.findAll(example);
    }

    @Override
    public void create(ProjectInformation proInfo) {
        proInfoDao.saveAndFlush(proInfo);
    }

    @Override
    public void update(ProjectInformation proInfo) {
        proInfoDao.saveAndFlush(proInfo);
    }

    @Override
    public void deleteById(String id) {
        proInfoDao.deleteById(Integer.parseInt(id));
    }
}
