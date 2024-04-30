package service;

import controller.EditType;

import view.InputView;
import view.OutputView;
import domain.Grade;
import domain.Student;
import dto.GradeDTO;
import dto.StudentDTO;
import repository.StudentsRepository;
import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class ManagementService {
    public static final StudentsRepository studentRepository = new StudentsRepository();

    public void createStudent(StudentDTO studentDTO) {
        Student student = Student.fromDTO(studentDTO);
        Validate.isDupStudent(studentRepository, student);
        studentRepository.save(student);
    }

    public StudentDTO findStudent(Scanner scan){
        String searchStdId = InputView.readStudentID(scan);
        Validate.isValidStudentNumber(searchStdId);
        Student student = studentRepository.findById(Integer.parseInt(searchStdId));
        Validate.isValidStudent(student);
        Grade grade = student.getGrade();
        return new StudentDTO(student.getStdId(), student.getName(), new GradeDTO(grade));
    }

    public void editStudent(StudentDTO studentDTO, String editCmd, Scanner scan){
        Grade grade = studentDTO.getGrade();
        Validate.isValidCmd(editCmd);
        EditType cmd = EditType.valueOf(editCmd.toUpperCase());
        switch (cmd){
            case CHANGE_NAME:
                String name = InputView.readStudentName(scan);
                studentDTO.setName(name);
                break;
            case CHANGE_KOREAN_GRADE:
                int koreanGrade = Integer.parseInt(InputView.readKoreanGrade(scan));
                grade.setKoreanGrade(koreanGrade);
                studentDTO.setGrade(grade);
                break;
            case CHANGE_ENGLISH_GRADE:
                int englishGrade = Integer.parseInt(InputView.readEnglishGrade(scan));
                grade.setEnglishGrade(englishGrade);
                studentDTO.setGrade(grade);
                break;
            case CHANGE_MATH_GRADE:
                int mathGrade = Integer.parseInt(InputView.readMathGrade(scan));
                grade.setMathGrade(mathGrade);
                studentDTO.setGrade(grade);
                break;
            case EXIT:
                return;
            default:
                OutputView.printWrong();
        }
        createStudent(studentDTO);
    }

    public void deleteStudent(Scanner scan) {
        StudentDTO studentDTO = findStudent(scan);
        studentRepository.delete(studentDTO.getStdId());
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll();
    }
}
