package nvc.it.onlineexamexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.onlineexamexpress.model.Exam;
import nvc.it.onlineexamexpress.model.Question;
import nvc.it.onlineexamexpress.repository.ExamRepository;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getExams(){
        return examRepository.findAll();
    }

    public Optional<Exam> findById(String id){
        return examRepository.findById(id);
    }

    public List<Exam> findExamBySubject(String subject){
        return examRepository.findBySubjectContaining(subject);
    }

    public Exam addExam(Exam exam){
        return examRepository.save(exam);
    }

    public Optional<Exam> updateExam(String id, Exam exam){
        Exam currentExam = examRepository.findById(id).get();
        currentExam.setTitle(exam.getTitle());
        currentExam.setSubject(exam.getSubject());
        currentExam.setChapter(exam.getChapter());
        currentExam.setScore(exam.getScore());
        currentExam.setPassed(exam.getPassed());
        return Optional.of(examRepository.save(currentExam));
    }

    public Optional<Exam> addQuestion(String id, Question question){
        Exam currentExam = examRepository.findById(id).get();
        List<Question> questions = currentExam.getQuestions();
        questions.add(question);
        currentExam.setQuestions(questions);

        return Optional.of(examRepository.save(currentExam));
    }

    public boolean deleteExam(String id){
        try{
            examRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
