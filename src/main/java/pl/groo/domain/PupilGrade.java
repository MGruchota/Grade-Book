package pl.groo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PUPIL_GRADES")
public class PupilGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long PupilId;
    private final Subject subject;
    private List<Grade> gradeList = new ArrayList<>();

    public PupilGrade(Subject subject) {
        this.subject = subject;
    }


    public void addGrade(Grade grade){
        gradeList.add(grade);
    }

    public Subject getSubject() {
        return subject;
    }

    public long getId() {
        return id;
    }

    public long getPupilId() {
        return PupilId;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    @Override
    public String toString() {
        return "PupilGrade{" +
                "id=" + id +
                ", PupilId=" + PupilId +
                ", subject=" + subject +
                ", gradeList=" + gradeList +
                '}';
    }
}
