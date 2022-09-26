package com.algor.codepool.mvc.dao;

import com.algor.codepool.mvc.bean.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface ProjectInformationDao extends JpaRepository<ProjectInformation, Integer> {
}
