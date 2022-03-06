package nvc.it.onlineexamexpress.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AnsQuestion {
    private String no;
    private String questionTitle;
    private String ans;
    private boolean correct;
}
