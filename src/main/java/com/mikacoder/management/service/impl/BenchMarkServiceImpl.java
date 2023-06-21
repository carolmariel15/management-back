package com.mikacoder.management.service.impl;

import com.mikacoder.management.configuration.ResourceNotFoundException;
import com.mikacoder.management.model.entity.BenchMark;
import com.mikacoder.management.repository.BenchMarkRepository;
import com.mikacoder.management.service.BenchMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BenchMarkServiceImpl implements BenchMarkService {

    private final BenchMarkRepository repository;

    @Override
    public List<BenchMark> list() {
        return repository.findAll();
    }

    @Override
    public Optional<BenchMark> listById(int id) {
        return repository.findById(id);
    }

    @Override
    public BenchMark add(BenchMark entity) {
        return repository.save(entity);
    }

    @Override
    public BenchMark edit(BenchMark entity) {
        var bm = repository.findById(entity.getId());

        if(bm.isPresent()) {
            return repository.save(entity);
        } else {
            throw new ResourceNotFoundException("No existe el Bench Mark", HttpStatus.CONFLICT);
        }
    }

    @Override
    public void delete(int id) {
        var bm = repository.findById(id);

        if(bm.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No existe el Bench Mark", HttpStatus.CONFLICT);
        }
    }
}
