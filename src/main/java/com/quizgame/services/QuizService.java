package com.quizgame.services;

import com.quizgame.entities.Answer;
import com.quizgame.entities.ResponseQuestion;
import com.quizgame.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {
    public List<ResponseQuestion> getQuestions(){
        ResponseQuestion q1 = new ResponseQuestion();
        q1.setId(1);
        q1.setText("What is the capital of france?");
        List<String> list1 = Arrays.asList("London", "Paris", "Berlin","Rome");
        q1.setOptions(list1);
        q1.setCorrectAnswer("Paris");

        ResponseQuestion q2 = new ResponseQuestion();
        q2.setId(2);
        q2.setText("Which planet is Know as the red planet?");
        List<String> list2 = Arrays.asList("Mars", "Venus", "Jupitar","Mercury");
        q2.setOptions(list2);
        q2.setCorrectAnswer("Mars");

        ResponseQuestion q3 = new ResponseQuestion();
        q3.setId(3);
        q3.setText("Who wrote to kill a MockingBird?");
        List<String> list3 = Arrays.asList("Harper Lee", "Jane Austen", "F. scott Fitzgerald","Ernest Hemingway");
        q3.setOptions(list3);
        q3.setCorrectAnswer("Harper Lee");
        List<ResponseQuestion> questions = new ArrayList<>();
        questions.add((q1));
        questions.add(q2);
        questions.add(q3);
        return questions;
    }
    @Autowired
   QuizRepository quezRepo;
    public void saveAnswer(List<Answer> answer) {
        for(Answer ans:answer){
            quezRepo.save(ans);
        }
    }
}
