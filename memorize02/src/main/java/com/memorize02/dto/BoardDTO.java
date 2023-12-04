package com.memorize02.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long bno;

    @NotEmpty
    @Size(max = 200)
    private String title;

    @NotEmpty
    @Size(max = 2000)
    private String content;

    @NotEmpty
    @Size(max = 50)
    private String writer;

    private LocalDateTime resDate;
    private LocalDateTime modDate;
}
