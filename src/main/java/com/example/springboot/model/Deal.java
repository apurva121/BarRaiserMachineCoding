package com.example.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "Deals")
@Data
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxCount;
    private int currentSubscriber;
    private Date endDate;
    private Double price;
    private boolean active;

    public Deal(int maxCount, Double price) {
        this.maxCount = maxCount;
        this.price = price;
        LocalDateTime localDateTime = LocalDateTime.now().plus(2, ChronoUnit.HOURS);
        this.endDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        this.name = this.getId() + "_Deal";
        this.active = true;
    }

}