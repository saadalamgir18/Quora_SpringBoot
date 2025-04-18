package com.backend.Quora.controller;

import com.backend.Quora.Services.QuestionService;
import com.backend.Quora.Services.UserService;
import com.backend.Quora.dtos.QuestionDto;
import com.backend.Quora.models.Question;
import com.backend.Quora.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;

    }



    @GetMapping("/questions/search")
    public ResponseEntity<?> getAllQuestions(@RequestParam(required = false) String text){
        System.out.println(text);
        System.out.println("hitting questions api");
        return ResponseEntity.ok(questionService.findAll(text));
    }

    @PostMapping("/questions")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionDto questionReq){


       Optional<User> user = userService.findById(questionReq.getUserId());

       if (user.isEmpty()){
           return new ResponseEntity<>("User not exist!", HttpStatus.NOT_FOUND);


       }

       Question question = Question.builder()
               .body(questionReq.getBody())
               .title(questionReq.getTitle())
               .user(user.get())
               .build();
        QuestionDto questionDto = questionService.save(question);
        return new ResponseEntity<>(questionDto, HttpStatus.CREATED);

    }
}
