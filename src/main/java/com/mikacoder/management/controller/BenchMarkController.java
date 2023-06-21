package com.mikacoder.management.controller;

import com.mikacoder.management.model.entity.BenchMark;
import com.mikacoder.management.service.BenchMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/bm")
@RestController
@RequiredArgsConstructor
public class BenchMarkController {

    private final BenchMarkService service;

    @GetMapping
    ResponseEntity<List<BenchMark>> list() {
        var result = service.list();
        if(result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<BenchMark> listById(int id) {
        var result = service.listById(id).get();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    ResponseEntity<BenchMark> add(BenchMark entity) {
        var result = service.add(entity);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PatchMapping
    ResponseEntity<BenchMark> edit(BenchMark entity) {
        var result = service.edit(entity);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
