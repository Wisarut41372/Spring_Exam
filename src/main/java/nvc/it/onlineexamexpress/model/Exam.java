package nvc.it.onlineexamexpress.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("exam")
@Getter @Setter @NoArgsConstructor
public class Exam {
    @Id
    private String _id;
    private String title;
    private String subject;
    private String chapter;
    private Integer score;
    private Integer passed;

    private List<Question> questions = new ArrayList<Question>();

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
