package nvc.it.onlineexamexpress.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.onlineexamexpress.model.Exam;
import nvc.it.onlineexamexpress.model.Question;
import nvc.it.onlineexamexpress.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {
    
    @Autowired
    private ExamService examService;

    @GetMapping("")
    public ResponseEntity<Object> getAllExams(){
        List<Exam> exams = examService.getExams();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", exams);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExamById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", examService.findById(id));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getExamBySubject(@PathVariable String subject){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Serach By Subject Success!");
        map.put("data", examService.findExamBySubject(subject));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addExam(@RequestBody Exam exam){
        HashMap<String,Object> map = new HashMap<>();
        map.put("msg", "Add Exam Success!");
        map.put("data", examService.addExam(exam));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExam(@PathVariable String id, @RequestBody Exam exam){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Exam Success!");
        map.put("data", examService.updateExam(id, exam));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateQuestion(@PathVariable String id, @RequestBody Question question){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Question Success!");
        map.put("data", examService.addQuestion(id, question));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExam(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if(!examService.deleteExam(id)){
            map.put("msg", "Error delete");
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            map.put("msg", "Delete Success!");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }
}
