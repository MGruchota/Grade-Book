package pl.groo.domain;

import java.util.Arrays;

public enum Subject {
    MATH("Math"),
    POLISH("Polish"),
    ENGLISH("English"),
    JAVA("Java"),
    PYTHON("Python"),
    JAVA_SCRIPT("JavaScript"),
    GEOGRAPHY("Geography");

    private final String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject fromString(String subjectNames){
        return Arrays.stream(values()).filter(enumSubject -> getSubjectName().equals(subjectNames))
        .findFirst().orElseThrow(() -> new IllegalArgumentException("zły przedmiot"));

    }
}