package pro.sky.java.coirse2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;
import pro.sky.java.coirse2.examinerservice.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = new ArrayList<>(getAll());
        if (questions.size() == 0) {
            throw new TheQuestionWasNotFound();
        }
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
