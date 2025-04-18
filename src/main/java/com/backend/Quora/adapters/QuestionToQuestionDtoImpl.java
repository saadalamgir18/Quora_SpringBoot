package com.backend.Quora.adapters;

import com.backend.Quora.dtos.QuestionDto;
import com.backend.Quora.models.Question;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class QuestionToQuestionDtoImpl implements QuestionToQuestionDto {
    private final QuestionDto questionResponseDto;

    public QuestionToQuestionDtoImpl(QuestionDto questionResponseDto) {
        this.questionResponseDto = questionResponseDto;
    }

    @Override
    public List<QuestionDto> convertToQuestionDto(List<Question> question) {
        return question.stream().map(question1 -> {
            QuestionDto dto = new QuestionDto();
            dto.setBody(question1.getBody());
            dto.setTitle(question1.getTitle());
            dto.setId(question1.getId());
            dto.setUserId(question1.getUser().getId());
            return dto;
        }).toList();
    }

    @Override
    public QuestionDto convertToQuestionDto(Question question) {
        questionResponseDto.setBody(question.getBody());
        questionResponseDto.setTitle(question.getTitle());
        questionResponseDto.setUserId(question.getUser().getId());
        questionResponseDto.setId(question.getId());
        return questionResponseDto;
    }
}
