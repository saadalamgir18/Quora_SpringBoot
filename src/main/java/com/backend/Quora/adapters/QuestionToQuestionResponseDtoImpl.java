package com.backend.Quora.adapters;

import com.backend.Quora.dtos.QuestionResponseDto;
import com.backend.Quora.models.Question;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class QuestionToQuestionResponseDtoImpl implements QuestionToQuestionResponseDto{
    private final QuestionResponseDto questionResponseDto;

    public QuestionToQuestionResponseDtoImpl(QuestionResponseDto questionResponseDto) {
        this.questionResponseDto = questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> convertDto(List<Question> question) {
        return question.stream().map( question1 -> {
            questionResponseDto.setBody(question1.getBody());
            questionResponseDto.setTitle(question1.getTitle());
            questionResponseDto.setId(question1.getId());
            questionResponseDto.setUserId(question1.getUser().getId());
            return questionResponseDto;
                }

        ).toList();
    }
}
