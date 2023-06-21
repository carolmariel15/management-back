package com.mikacoder.management.service;

import com.mikacoder.management.model.entity.BenchMark;

import java.util.List;
import java.util.Optional;

public interface BenchMarkService {

    List<BenchMark> list();
    Optional<BenchMark> listById(int id);
    BenchMark add(BenchMark entity);
    BenchMark edit(BenchMark entity);
    void delete(int id);

}
