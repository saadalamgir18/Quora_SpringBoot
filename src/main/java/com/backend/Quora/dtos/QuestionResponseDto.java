package com.backend.Quora.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class QuestionResponseDto {
    private UUID id;
    private String title;
    private String body;
    private UUID userId;
}
