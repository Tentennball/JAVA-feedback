package domain;

import constant.ValidConstant;
import dto.StudentDto;
import view.ErrorMessage;

public class Student {
    private final int stdId;
    private final String name;
    private final Grade grade;
    private static final int MAX_GRADE = 100;
    private static final int MIN_GRADE = 0;

    public Student(StudentDto studentDTO){
        validate(studentDTO);
        this.stdId = studentDTO.getStdId();
        this.name = studentDTO.getName();
        this.grade = studentDTO.getGrade();
    }
    public Student(Student student){
        this.stdId = student.getStdId();
        this.name = student.getName();
        this.grade = student.getGrade();
    }
    private void validate(StudentDto studentDTO){
        isValidStudentNumber(Integer.toString(studentDTO.getStdId()));
        isValidStudentName(studentDTO.getName());
        isValidStudentGrade(studentDTO.getGrade());
    }
    private void isValidStudentNumber(String stdID) {
        if (!stdID.matches(ValidConstant.STDID_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.STUDENT_ID_IS_EIGHT_NUMBER);
        }
    }

    private void isValidStudentName(String name) {
        if(!name.matches(ValidConstant.NAME_REGEX)){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_STUDENT_NAME);
        }
    }

    private void isValidStudentGrade(Grade grade) {
        int[] grades = {grade.getKoreanGrade(), grade.getEnglishGrade(), grade.getMathGrade()};
        for(int eachGrade: grades)
        {
            if(eachGrade<MIN_GRADE || eachGrade>MAX_GRADE) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_GRADE);
            }
        }
    }
    public int getStdId(){ return stdId; }
    public String getName(){ return name; }
    public Grade getGrade(){ return grade; }

}
