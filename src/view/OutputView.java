package view;

import domain.Grade;
import domain.Student;
import dto.StudentDto;
import java.util.List;

public class OutputView {
    private static final String MENU_BAR_MSG = "1. 학생 등록, 2. 학생 전체 조회, 3. 학생 검색, 4. 학생 정보 수정, 5. 학생 삭제, 6. 종료";
    private static final String EXIT_MSG = "프로그램을 종료합니다.";
    private static final String STUDENT_REGISTER_PRINT = "\n<학생 등록>";
    private static final String STUDENT_SEARCH_PRINT = "\n<학생 검색>";
    private static final String STUDENT_EDIT_PRINT = "\n<학생 수정>";
    private static final String STUDENT_DELETE_PRINT = "\n<학생 삭제>";
    private static final String STUDENT_INFO_PRINT_FORMAT = "- %s\n학번 : %d\n국어성적 : %3d, 영어성적 : %3d, 수학성적 : %3d\n평균 : %f\n\n";
    private static final String NO_STUDENTS = "학생 등록 후 사용가능합니다.\n";
    public static void printMenuBar() {
        System.out.println(MENU_BAR_MSG);
    }

    public static void printRegister() {
        System.out.println(STUDENT_REGISTER_PRINT);
    }

    public static void printSearchSubject() {
        System.out.println(STUDENT_SEARCH_PRINT);
    }

    public static void printEditSubject() {
        System.out.println(STUDENT_EDIT_PRINT);
    }

    public static void printDeleteSubject() {
        System.out.println(STUDENT_DELETE_PRINT);
    }

    public static void printExit() {
        System.out.println(EXIT_MSG);
    }

    public static void printSearchedStudent(StudentDto studentDTO) {
        Student student = new Student(studentDTO);
        printStudentInfo(student);
    }

    public static void printAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(NO_STUDENTS);
            return;
        }
        for (Student student : students) {
            printStudentInfo(student);
        }
    }

    public static void printStudentInfo(Student student) {
        Grade grade = new Grade(student.getGrade());
        System.out.printf(STUDENT_INFO_PRINT_FORMAT, student.getName(), student.getStdId(),
                grade.getKoreanGrade(), grade.getEnglishGrade(), grade.getMathGrade(), grade.calculateAverage());
    }
}
