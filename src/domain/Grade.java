package domain;

import dto.GradeDto;

public class Grade
{
    private final int koreanGrade;
    private final int englishGrade;
    private final int mathGrade;
    final int SUBJECT_CONUT = 3;

    protected Grade(GradeDto gradeDTO){
        this.koreanGrade = gradeDTO.getKoreanGrade();
        this.englishGrade = gradeDTO.getEnglishGrade();
        this.mathGrade = gradeDTO.getMathGrade();
    }
    public Grade(int koreanGrade, int englishGrade, int mathGrade){
        this.koreanGrade = koreanGrade;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
    }
    public Grade(Grade grade){
        this.koreanGrade = grade.getKoreanGrade();
        this.englishGrade = grade.getEnglishGrade();
        this.mathGrade = grade.getMathGrade();
    }
    public static Grade fromDTO(GradeDto gradeDTO){
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


    public Grade changeKoreanGrade(int koreanGrade) {
        return new Grade(koreanGrade, this.englishGrade, this.mathGrade);
    }

    public Grade changeEnglishGrade(int englishGrade) {
        return new Grade(this.koreanGrade, englishGrade, this.mathGrade);
    }

    public Grade changeMathGrade(int mathGrade) {
        return new Grade(this.koreanGrade, this.englishGrade, mathGrade);
    }
    public Double calculateAverage(){
        return ((double)(getKoreanGrade()+getEnglishGrade()+getMathGrade()))/SUBJECT_CONUT;
    }
}
