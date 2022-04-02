package pro.sky.java.coirse2.examinerservice.repository;

import org.springframework.stereotype.Service;
import pro.sky.java.coirse2.examinerservice.domain.Question;
import pro.sky.java.coirse2.examinerservice.exception.TheQuestionWasNotFound;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();

        questions.add(new Question("Какое кодовое название получил проект создания Java, как нового языка " +
                "программирования?", "Green"));
        questions.add(new Question("Для чего изначально разрабатывался язык программирования Java?",
                "Для программирования бытовых устройств"));
        questions.add(new Question("Каким должен был быть язык Java, уже в первой своей версии?",
                "Независимым от платформы"));
        questions.add(new Question("Какой язык программирования лежит в основе Java?", "С++"));
        questions.add(new Question("Какая дата считается датой официального выпуска Java?",
                "23 мая 1995 года"));
        questions.add(new Question("Что отсутствовало в Java 1.0?", "Средства вывода на печать"));
        questions.add(new Question("Как первоначально хотели назвать это язык программирования?",
                "Oak (Дуб)"));
        questions.add(new Question("Что такое HotJava?", "Веб-браузер"));
        questions.add(new Question("Какое кодовое имя получила Java 5.0?", "Tiger"));
        questions.add(new Question("Чем является Epsilon, ставший нововведением в Java SE 11?",
                "Новым сборщиком мусора"));
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
