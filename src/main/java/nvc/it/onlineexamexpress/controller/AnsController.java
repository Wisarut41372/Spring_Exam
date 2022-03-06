package nvc.it.onlineexamexpress.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.onlineexamexpress.model.Ans;
import nvc.it.onlineexamexpress.model.AnsQuestion;
import nvc.it.onlineexamexpress.service.AnsService;

@RestController
@RequestMapping("/ans")
public class AnsController {
    
    @Autowired
    private AnsService ansService;

    @GetMapping("")
    public ResponseEntity<Object> getAllAns(){
        List<Ans> ans = ansService.getAns();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", ans);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAnsById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", ansService.findById(id));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/username/{username}")
    public ResponseEntity<Object> getAnsByUsername(@PathVariable String username){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Serach By Username Success!");
        map.put("data", ansService.findAnsByUsername(username));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @PostMapping("")
    public ResponseEntity<Object> addAns(@RequestBody Ans ans){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Ans Success!");
        map.put("data", ansService.addAns(ans));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateAnsQuestion(@PathVariable String id, @RequestBody AnsQuestion ansQuestion){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Answer Success!");
        map.put("data", ansService.addAnsQuestion(id, ansQuestion));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }
}
