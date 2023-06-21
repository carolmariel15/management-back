package com.mikacoder.management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_bench_mark")
public class BenchMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String location;
    private BigDecimal cota;
    private String name;
    private int latitudeGrade;
    private int latitudeMin;
    private BigDecimal latitudeSeg;
    private int lengthGrade;
    private int lengthMin;
    private BigDecimal lengthSeg;


}
