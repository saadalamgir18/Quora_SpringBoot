package com.backend.Quora.adapters;

import com.backend.Quora.dtos.QuestionResponseDto;
import com.backend.Quora.models.Question;

import java.util.List;

public interface QuestionToQuestionResponseDto {
    public List<QuestionResponseDto> convertDto(List<Question> question);
}
