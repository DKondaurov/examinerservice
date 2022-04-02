package pro.sky.java.coirse2.examinerservice.service;

import pro.sky.java.coirse2.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
