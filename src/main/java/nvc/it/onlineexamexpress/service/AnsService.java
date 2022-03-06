package nvc.it.onlineexamexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.onlineexamexpress.model.Ans;
import nvc.it.onlineexamexpress.model.AnsQuestion;
import nvc.it.onlineexamexpress.repository.AnsRepository;

@Service
public class AnsService {
    
    @Autowired
    private AnsRepository ansRepository;

    public List<Ans> getAns(){
        return ansRepository.findAll();
    }

    public Optional<Ans> findById(String id){
        return ansRepository.findById(id);
    }

    public List<Ans> findAnsByUsername(String username){
        return ansRepository.findByUsernameContaining(username);
    }

    public Ans addAns(Ans ans){
        return ansRepository.save(ans);
    }

    public Optional<Ans> addAnsQuestion(String id, AnsQuestion ansQuestion){
        Ans currentAns = ansRepository.findById(id).get();
        List<AnsQuestion> ansQuestions = currentAns.getAnsQuestions();
        ansQuestions.add(ansQuestion);
        currentAns.setAnsQuestions(ansQuestions);

        return Optional.of(ansRepository.save(currentAns));
    }
}
