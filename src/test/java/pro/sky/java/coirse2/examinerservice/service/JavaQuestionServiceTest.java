package pro.sky.java.coirse2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;
import pro.sky.java.coirse2.examinerservice.repository.QuestionRepository;

import java.util.Collection;

import static org.mockito.Mockito.*;
import static pro.sky.java.coirse2.examinerservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void add() {
        when(questionRepository.add(new Question(QUESTION, ANSWER)))
                .thenReturn(FULL_QUESTION);
        assertEquals(FULL_QUESTION, out.add(QUESTION, ANSWER));
    }

    @Test
    public void addFullQuestion() {
        when(questionRepository.add(FULL_QUESTION))
                .thenReturn(FULL_QUESTION);
        assertEquals(FULL_QUESTION, out.add(FULL_QUESTION));
    }

    @Test
    public void remove() {
        when(questionRepository.remove(FULL_QUESTION))
                .thenReturn(FULL_QUESTION);
        assertEquals(FULL_QUESTION, out.remove(FULL_QUESTION));
    }

    @Test
    public void getAll() {
        when(questionRepository.getAll())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(CORRECT_COLLECTION, out.getAll());
    }
}