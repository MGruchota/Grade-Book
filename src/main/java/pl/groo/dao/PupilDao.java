package pl.groo.dao;

import pl.groo.domain.Grade;
import pl.groo.domain.Subject;

public interface PupilDao {
    void addPupil(String name, String surname);
    void enrollToSubjects (Subject subject);
    void addGrade(Subject subject, Grade grade);
}
