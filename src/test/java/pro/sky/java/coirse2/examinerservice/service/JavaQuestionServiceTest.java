package pro.sky.java.coirse2.examinerservice.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;

import java.util.Collection;

import static pro.sky.java.coirse2.examinerservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void add() {
        Question result = out.add(QUESTION, ANSWER);
        assertEquals(new Question(QUESTION, ANSWER), result);
    }

    @Test
    public void addQuestion() {
        Question result = out.add(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    void remove() {
        out.add(CORRECT_QUESTION);
        Question result = out.remove(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    void notCorrectRemove() {
        assertThrows(TheQuestionWasNotFound.class, () -> out.remove(CORRECT_QUESTION));
    }

//    Я не понял как напистаь тесть на сбор коллекции не удалив при этом те вопросы что добавил ранее
//    @Test
//    void getAll() {
//        out.add(CORRECT_QUESTION);
//        Collection<Question> result = out.getAll();
//        assertEquals(out.getAll(), result);
//    }
}