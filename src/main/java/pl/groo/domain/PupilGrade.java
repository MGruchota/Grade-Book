package pl.groo.domain;

import java.util.ArrayList;
import java.util.List;

public class PupilGrade {
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

    public List<Grade> getGradeList() {
        return gradeList;
    }

    @Override
    public String toString() {
        return "PupilGrade{" +
                "subject=" + subject +
                ", gradeList=" + gradeList +
                '}';
    }
}
