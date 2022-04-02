package pro.sky.java.coirse2.examinerservice.repository;

import org.springframework.stereotype.Service;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {

        this.questions = new HashSet<>();

        questions.add(new Question("2 * 2", "4"));
        questions.add(new Question("14 / 7", "2"));
        questions.add(new Question("12 * 6", "72"));
        questions.add(new Question("86 - 35", "51"));
        questions.add(new Question("42 * 8", "336"));
        questions.add(new Question("336 - 248", "88"));
        questions.add(new Question("88 / 4", "22"));
        questions.add(new Question("22 + 17", "39"));
        questions.add(new Question("39 * 5", "195"));
        questions.add(new Question("195 - 82", "113"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new TheQuestionWasNotFound();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
