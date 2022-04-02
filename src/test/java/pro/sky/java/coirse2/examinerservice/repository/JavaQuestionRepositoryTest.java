package pro.sky.java.coirse2.examinerservice.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;

import java.util.Collection;

import static pro.sky.java.coirse2.examinerservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    void add() {
        Question result = out.add(FULL_QUESTION);
        assertEquals(FULL_QUESTION, result);
    }

    @Test
    void remove() {
        out.add(FULL_QUESTION);
        Question result = out.remove(FULL_QUESTION);
        assertEquals(FULL_QUESTION, result);
    }

    @Test
    void notCorrectRemove() {
        assertThrows(TheQuestionWasNotFound.class, () -> out.remove(FULL_QUESTION));
    }

//    Я не понял как напистаь тесть на сбор коллекции не удалив при этом те вопросы что добавил ранее
//    поробовал все assert и искал интернете не нашёл отвент.
//    @Test
//    void getAll() {
//        out.add(FULL_QUESTION);
//        Collection<Question> result = out.getAll();
//        assertEquals(FULL_QUESTION, result);
//    }
}