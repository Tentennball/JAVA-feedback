package dto;

import domain.Grade;

public class GradeDto {
    private final int koreanGrade;
    private final int englishGrade;
    private final int mathGrade;


    public GradeDto(int koreanGrade, int englishGrade, int mathGrade){
        this.koreanGrade = koreanGrade;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
    }
    public GradeDto(Grade grade){
        this.koreanGrade = grade.getKoreanGrade();
        this.englishGrade = grade.getEnglishGrade();
        this.mathGrade = grade.getMathGrade();
    }
    public int getEnglishGrade() {
        return englishGrade;
    }
    public int getKoreanGrade() {
        return koreanGrade;
    }
    public int getMathGrade() {
        return mathGrade;
    }
}
