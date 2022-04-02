package pro.sky.java.coirse2.examinerservice.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.coirse2.examinerservice.constants.ExaminerServiceConstants.FULL_QUESTION;

class MathQuestionRepositoryTest {
    private final MathQuestionRepository out = new MathQuestionRepository();

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

}