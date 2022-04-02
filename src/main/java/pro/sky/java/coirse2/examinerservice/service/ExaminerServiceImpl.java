package pro.sky.java.coirse2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.IncorrectNumberOfQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionService;
    private final Random random;

    public ExaminerServiceImpl(List<QuestionService> questionService) {
        this.questionService = questionService;
        this.random = new Random();
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount <= 0) {
            throw new IncorrectNumberOfQuestionsException();
        }
        while (questions.size() < amount) {
            QuestionService service = questionService.get(random.nextInt(questionService.size()));
            questions.add(service.getRandomQuestion());
        }
        return questions;
    }
}
