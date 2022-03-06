package nvc.it.onlineexamexpress.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.onlineexamexpress.model.Ans;

public interface AnsRepository extends MongoRepository<Ans,String>{
    
    public List<Ans> findByUsernameContaining(String username);
}
