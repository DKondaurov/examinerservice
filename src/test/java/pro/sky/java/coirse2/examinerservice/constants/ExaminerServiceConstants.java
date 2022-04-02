package pro.sky.java.coirse2.examinerservice.constants;

import pro.sky.java.coirse2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.Set;

public class ExaminerServiceConstants {
    public static final String QUESTION = "Вопрос?";
    public static final String ANSWER = "Ответ";
    public static final Question CORRECT_QUESTION = new Question(QUESTION, ANSWER);
    public static final Collection<Question> CORRECT_COLLECTION = Set.of();

}
