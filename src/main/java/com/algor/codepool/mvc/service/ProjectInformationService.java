package com.algor.codepool.mvc.service;

import com.algor.codepool.mvc.bean.ProjectInformation;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProjectInformationService {

    List<ProjectInformation> findAll(ProjectInformation proInfo);

    Integer create(ProjectInformation proInfo);
}
