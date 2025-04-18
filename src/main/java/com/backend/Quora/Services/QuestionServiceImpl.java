package com.backend.Quora.Services;

import com.backend.Quora.adapters.QuestionToQuestionResponseDto;
import com.backend.Quora.dtos.QuestionResponseDto;
import com.backend.Quora.models.Question;
import com.backend.Quora.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepo;
    private final QuestionToQuestionResponseDto questionToQuestionResponseDto;


    QuestionServiceImpl(QuestionRepository questionRepo, QuestionToQuestionResponseDto questionToQuestionResponseDto){
        this.questionRepo = questionRepo;
        this.questionToQuestionResponseDto = questionToQuestionResponseDto;
    }




    @Override
    public List<QuestionResponseDto> findAll() {
       return questionToQuestionResponseDto.convertDto(questionRepo.findAll());
    }

    @Override
    public Question save(Question question) {
        System.out.println(question);

        return questionRepo.save(question);
    }


}
