package com.mikacoder.management.repository;

import com.mikacoder.management.model.entity.BenchMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchMarkRepository extends JpaRepository<BenchMark, Integer> {

}
