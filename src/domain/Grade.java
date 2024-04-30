package domain;

import constant.GradeConstant;
import dto.GradeDTO;

public class Grade
{
    private final int koreanGrade;
    private final int englishGrade;
    private final int mathGrade;
    private double average;
    protected Grade(GradeDTO gradeDTO){
        this.koreanGrade = gradeDTO.getKoreanGrade();
        this.englishGrade = gradeDTO.getEnglishGrade();
        this.mathGrade = gradeDTO.getMathGrade();
        setAverage();
    }
    public static Grade fromDTO(GradeDTO gradeDTO){
        return new Grade(gradeDTO);
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

    public void setAverage() {
        this.average = (double)(koreanGrade + englishGrade + mathGrade) / GradeConstant.SUBJECT_CONUT;
    }

    public void setKoreanGrade(int koreanGrade) {
        this.koreanGrade = koreanGrade;
        setAverage();
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
        setAverage();
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
        setAverage();
    }

}
