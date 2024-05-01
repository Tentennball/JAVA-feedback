package dto;

import domain.Grade;

public class StudentDto {
    private final int stdId;
    private String name;
    private Grade grade;

    public StudentDto(int stdId, String name, GradeDto gradeDTO){
        this.stdId = stdId;
        this.name = name;
        this.grade = Grade.fromDTO(gradeDTO);
    }

    public int getStdId() {
        return stdId;
    }
    public String getName() {
        return name;
    }
    public Grade getGrade(){
        return grade;
    }
    public void setName(String name){ this.name = name; }
    public void setGrade(Grade grade){
        this.grade = grade;
    }

}
