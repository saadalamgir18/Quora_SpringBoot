package com.backend.Quora.adapters;

import com.backend.Quora.dtos.QuestionDto;
import com.backend.Quora.models.Question;

import java.util.List;

public interface QuestionToQuestionDto {
    public List<QuestionDto> convertToQuestionDto(List<Question> question);
    public QuestionDto convertToQuestionDto(Question question);
}
