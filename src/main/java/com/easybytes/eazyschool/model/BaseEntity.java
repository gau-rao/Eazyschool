package com.easybytes.eazyschool.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@MappedSuperclass
public class BaseEntity {
    @Getter@Setter
    private LocalDateTime createdAt;
    @Getter@Setter
    private String createdBy;
    @Setter
    private LocalDateTime updatedAt;
    @Setter
    private String updatedBy;




}
