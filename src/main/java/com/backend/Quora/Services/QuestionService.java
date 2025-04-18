package com.backend.Quora.Services;


import com.backend.Quora.dtos.QuestionResponseDto;
import com.backend.Quora.models.Question;

import java.util.List;

public interface QuestionService {
    List<QuestionResponseDto> findAll();
    Question save(Question question);
}
