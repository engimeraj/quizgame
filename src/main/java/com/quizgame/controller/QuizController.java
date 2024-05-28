package com.quizgame.controller;

import com.quizgame.entities.Answer;
import com.quizgame.entities.ResponseQuestion;
import com.quizgame.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizController {
   @Autowired
   QuizService quizService;
    @GetMapping("/quiz")
     public ResponseEntity<?> getQuizQuestions(){
       List<ResponseQuestion> questions = quizService.getQuestions();
        Map<String,List<ResponseQuestion>> que= new HashMap<>();
        que.put("questions",questions);
       return new ResponseEntity<>(que,HttpStatus.OK);
}
@PostMapping("/submit")
    public ResponseEntity<String> submitAnswers(@RequestBody Map<String,List<Answer>> answer){
    List<Answer> answers = answer.get("answers");
    quizService.saveAnswer(answers);
    return new ResponseEntity<>("answer submit ", HttpStatus.OK);
}
}
