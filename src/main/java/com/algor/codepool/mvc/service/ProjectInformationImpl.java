package com.algor.codepool.mvc.service;

import com.algor.codepool.mvc.bean.ProjectInformation;
import com.algor.codepool.mvc.dao.ProjectInformationDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectInformationImpl implements CrudRepository<ProjectInformation, Integer> {
    @Override
    public <S extends ProjectInformation> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProjectInformation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProjectInformation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<ProjectInformation> findAll() {
        return null;
    }

    @Override
    public Iterable<ProjectInformation> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ProjectInformation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProjectInformation> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
