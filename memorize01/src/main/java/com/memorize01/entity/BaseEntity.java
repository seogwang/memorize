package com.memorize01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
abstract class BaseEntity {

    @Column(name="resdate", updatable = false)
    @CreatedDate
    private LocalDateTime resDate;

    @Column(name="moddate")
    @LastModifiedDate
    private LocalDateTime modDate;

}
