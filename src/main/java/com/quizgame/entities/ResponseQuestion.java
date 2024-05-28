package com.quizgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseQuestion {
    private int id;
    private String text;
    private List<String> options;
    private String correctAnswer;
}
