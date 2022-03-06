package nvc.it.onlineexamexpress.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.onlineexamexpress.model.Exam;

public interface ExamRepository extends MongoRepository<Exam,String>{
    
    public List<Exam> findBySubjectContaining(String subject);

}
