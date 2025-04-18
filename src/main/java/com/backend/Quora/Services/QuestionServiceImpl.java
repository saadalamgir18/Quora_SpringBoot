package com.backend.Quora.Services;

import com.backend.Quora.adapters.QuestionToQuestionDto;
import com.backend.Quora.dtos.QuestionDto;
import com.backend.Quora.models.Question;
import com.backend.Quora.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepo;
    private final QuestionToQuestionDto questionToQuestionResponseDto;


    QuestionServiceImpl(QuestionRepository questionRepo, QuestionToQuestionDto questionToQuestionResponseDto){
        this.questionRepo = questionRepo;
        this.questionToQuestionResponseDto = questionToQuestionResponseDto;
    }




    @Override
    public List<QuestionDto> findAll(String text) {
        if(text == null){
            return questionToQuestionResponseDto.convertToQuestionDto(questionRepo.findAll());
        }
       return questionToQuestionResponseDto.convertToQuestionDto(questionRepo.findByTitleIgnoreCaseContaining(text));
    }


    @Override
    public QuestionDto save(Question question) {
        System.out.println(question);

        return questionToQuestionResponseDto.convertToQuestionDto(questionRepo.save(question));
    }


}
