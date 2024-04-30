package controller;

import view.ErrorView;
import view.InputView;
import view.OutputView;
import dto.GradeDTO;
import dto.StudentDTO;
import service.ManagementService;
import validate.Validate;
import java.util.List;
import java.util.Scanner;

public class ManagementController {
    ManagementService managementService;
    private static final Scanner scan = new Scanner(System.in);

    public ManagementController() {
        managementService = new ManagementService();
    }

    public void run() {
        while (true) {
            try {
                OutputView.printMenuBar();
                String cmd = InputView.readMenuBarCmd(scan);
                Validate.isValidCmd(cmd);
                ServiceName selectedService = ServiceName.valueOf(cmd.toUpperCase());
                switch (selectedService) {
                    case REGISTER://학생 등록
                        OutputView.printRegister();
                        StudentDTO studentDTO = inputStudent(scan);//
                        managementService.createStudent(studentDTO);
                        break;
                    case PRINT_INFO://학생 정보 출력
                        List<StudentDTO> studentsDTO = managementService.findAll();
                        OutputView.printAllStudents(studentsDTO);
                        break;
                    case SEARCH://학생 찾기
                        OutputView.printSearchSubject();
                        StudentDTO searchStudentDTO = managementService.findStudent(scan);
                        OutputView.printSearchedStudent(searchStudentDTO);
                        break;
                    case EDIT://학생 정보 수정
                        OutputView.printEditSubject();
                        StudentDTO editStudentDTO = managementService.findStudent(scan);
                        String editCmd = InputView.readEditCmd(scan);
                        managementService.editStudent(editStudentDTO, editCmd, scan);
                        break;
                    case DELETE://학생 삭제
                        managementService.deleteStudent(scan);
                        OutputView.printDeleteSubject();
                        break;
                    case EXIT://종료
                        OutputView.printExit();
                        return;
                    default:
                        OutputView.printWrong();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public StudentDTO inputStudent(Scanner scan) {
        try {
            int stdId = Integer.parseInt(InputView.readStudentID(scan));
            String name = InputView.readStudentName(scan);
            int koreanGrade = Integer.parseInt(InputView.readKoreanGrade(scan));
            int englishGrade = Integer.parseInt(InputView.readEnglishGrade(scan));
            int mathGrade = Integer.parseInt(InputView.readMathGrade(scan));
            GradeDTO gradeDTO = new GradeDTO(koreanGrade, englishGrade, mathGrade);
            return new StudentDTO(stdId, name, gradeDTO);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorView.NOT_VALID_INPUT_CMD);
        }
    }


}
