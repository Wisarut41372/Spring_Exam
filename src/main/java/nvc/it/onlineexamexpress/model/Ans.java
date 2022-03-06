package nvc.it.onlineexamexpress.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Ans {
    @Id
    private String _id;
    private String username;
    private String examId;
    private Integer score;
    private Integer passed;
    private List<AnsQuestion> ansQuestions = new ArrayList<AnsQuestion>();

    private Integer total;
    private boolean pass;
    private Integer round;

    }
