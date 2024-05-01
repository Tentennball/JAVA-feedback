package controller;

import domain.Student;
import view.ErrorMessage;
import view.InputView;
import view.OutputView;
import dto.GradeDto;
import dto.StudentDto;
import service.ManagementService;
import java.util.List;
import java.util.Scanner;

public class ManagementController {
    ManagementService managementService;
    private final Scanner scan = new Scanner(System.in);

    public ManagementController() {
        managementService = new ManagementService();
    }

    public void run() {
        while (true) {
            try {
                OutputView.printMenuBar();
                ServiceName cmd = InputView.readMenuBarCmd(scan);
                switch (cmd) {
                    case REGISTER:
                        OutputView.printRegister();
                        StudentDto studentDTO = generateStudentInfo(scan);//
                        managementService.createStudent(studentDTO, false);
                        break;
                    case PRINT_INFO:
                        List<Student> students = managementService.findAll();
                        OutputView.printAllStudents(students);
                        break;
                    case SEARCH:
                        OutputView.printSearchSubject();
                        String searchStdId = InputView.readStudentID(scan);
                        StudentDto searchStudentDto = managementService.findStudent(searchStdId);
                        OutputView.printSearchedStudent(searchStudentDto);
                        break;
                    case EDIT:
                        OutputView.printEditSubject();
                        String editStdId = InputView.readStudentID(scan);
                        StudentDto editStudentDto = managementService.findStudent(editStdId);
                        EditType editCmd = InputView.readEditCmd(scan);
                        managementService.editStudent(editStudentDto, editCmd, scan);
                        break;
                    case DELETE:
                        String deleteStdId = InputView.readStudentID(scan);
                        managementService.deleteStudent(deleteStdId);
                        OutputView.printDeleteSubject();
                        break;
                    case EXIT:
                        OutputView.printExit();
                        return;
                    default:
                        throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_CMD);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private StudentDto generateStudentInfo(Scanner scan) {
        try {
            int stdId = Integer.parseInt(InputView.readStudentID(scan));
            String name = InputView.readStudentName(scan);
            int koreanGrade = Integer.parseInt(InputView.readKoreanGrade(scan));
            int englishGrade = Integer.parseInt(InputView.readEnglishGrade(scan));
            int mathGrade = Integer.parseInt(InputView.readMathGrade(scan));
            GradeDto gradeDTO = new GradeDto(koreanGrade, englishGrade, mathGrade);
            return new StudentDto(stdId, name, gradeDTO);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_CMD);
        }
    }


}
