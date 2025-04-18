package com.backend.Quora.controller;

import com.backend.Quora.Services.QuestionService;
import com.backend.Quora.Services.UserService;
import com.backend.Quora.adapters.QuestionToQuestionResponseDto;
import com.backend.Quora.models.Question;
import com.backend.Quora.models.User;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

    private QuestionService questionService;
    private UserService userService;

    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;

    }



    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestions(){
        System.out.println("hitting questions api");
        return ResponseEntity.ok(questionService.findAll());
    }

    @PostMapping("/questions/{user_id}")
    public ResponseEntity<?> saveQuestion(@PathVariable UUID user_id,  @RequestBody Question questionReq){

        System.out.println(questionReq);
       Optional<User> user = userService.findById(user_id);
       if (user.isPresent()){
           questionReq.setUser(user.get());
            Question question = questionService.save(questionReq);
            return new ResponseEntity<>(question, HttpStatus.CREATED);
       }else {
           return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
       }

    }
}
