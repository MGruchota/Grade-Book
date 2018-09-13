package pl.groo.domain;
import pl.groo.exception.PupilNotEnrolledOnSubject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import java.util.stream.Collectors;


@Entity
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String surname;
    private List<PupilGrade> pupilGrades = new ArrayList<>();

    public boolean enrollToSubject(Subject subject){
        boolean alreadyExist = pupilGrades.stream().anyMatch(pupilGrade -> pupilGrade.getSubject().equals(subject));

        if(!alreadyExist){
            pupilGrades.add(new PupilGrade(subject));
        }
        return !alreadyExist;
    }

    public Set<Subject> enrollOnSubjects(Set <Subject> subjects){
        List<Subject> enrolledSubjects = pupilGrades.stream()
                .map(PupilGrade::getSubject)
                .collect(Collectors.toList());


        Set<Subject> setOfSubjects = new HashSet<>(subjects);
        subjects.removeAll(enrolledSubjects);

        setOfSubjects.forEach(this::enrollToSubject);

        return setOfSubjects;
    }

    public void addGradeFromSubject (Subject subject, Grade grade) throws PupilNotEnrolledOnSubject {
        Optional<PupilGrade> gradeOfPupil = pupilGrades.stream().filter(pupilGrade -> pupilGrade.getSubject() == subject)
                .findFirst();

        /*
        //todo  czym jest ten zapis? Stream, mapowanie
        pupilGrades.stream()
                .map(PupilGrade::getGradeList)
                .filter(subjectFromStream -> subjectFromStream.equals(subject))
                .findFirst().isPresent();
        */


        if (gradeOfPupil.isPresent()) {
            gradeOfPupil.get().addGrade(grade);
        } else {
            throw new PupilNotEnrolledOnSubject(String.format("Pupil [%s %s] isn't enrolled on subject [%s]", name, surname, subject));
        }
    }


    public Pupil() {
    }

    public Pupil(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public List<PupilGrade> getPupilGrades() {
        return pupilGrades;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pupilGrades=" + pupilGrades +
                '}';
    }
}
