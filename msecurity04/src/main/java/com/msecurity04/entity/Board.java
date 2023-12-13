package com.msecurity04.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(value = AuditingEntityListener.class)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @NotEmpty
    @Column(length = 200, nullable = false)
    private String title;

    @NotEmpty
    @Column(length = 2000, nullable = false)
    private String content;

    @NotEmpty
    @Column(length = 50, nullable = false)
    private String writer;

    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    private LocalDateTime modDate;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}
