package com.backend.Quora.Services;


import com.backend.Quora.dtos.QuestionDto;
import com.backend.Quora.models.Question;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> findAll(String text);
    QuestionDto save(Question question);
}
