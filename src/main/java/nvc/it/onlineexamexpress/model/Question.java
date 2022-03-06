package nvc.it.onlineexamexpress.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Question {
    private String no;
    private String questionTitle;
    private String titleOptionA;
    private String titleOptionB;
    private String titleOptionC;
    private String titleOptionD;
    
    private String ans;
}
