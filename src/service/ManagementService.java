package service;

import constant.ValidConstant;
import controller.EditType;

import view.ErrorMessage;
import view.InputView;
import domain.Grade;
import domain.Student;
import dto.GradeDto;
import dto.StudentDto;
import repository.StudentsRepository;

import java.util.List;
import java.util.Scanner;

public class ManagementService {
    public static final StudentsRepository studentRepository = new StudentsRepository();

    public void createStudent(StudentDto studentDTO, Boolean editFlag) {
        Student student = new Student(studentDTO);
        if(!editFlag && studentRepository.findById(student.getStdId())!=null){
            throw new IllegalArgumentException(ErrorMessage.DUP_STUDENT);
        }
        studentRepository.save(student);
    }

    public StudentDto findStudent(String searchStdId){
        if (!searchStdId.matches(ValidConstant.STDID_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.STUDENT_ID_IS_EIGHT_NUMBER);
        }
        Student student = studentRepository.findById(Integer.parseInt(searchStdId));
        if(student==null){
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND);
        }
        return new StudentDto(student.getStdId(), student.getName(), new GradeDto(student.getGrade()));
    }

    public void editStudent(StudentDto studentDTO, EditType editCmd, Scanner scan){
        Grade grade = studentDTO.getGrade();
        switch (editCmd){
            case CHANGE_NAME:
                String name = InputView.readStudentName(scan);
                studentDTO.setName(name);
                break;
            case CHANGE_KOREAN_GRADE:
                int koreanGrade = Integer.parseInt(InputView.readKoreanGrade(scan));
                grade = grade.changeKoreanGrade(koreanGrade);
                studentDTO.setGrade(grade);
                break;
            case CHANGE_ENGLISH_GRADE:
                int englishGrade = Integer.parseInt(InputView.readEnglishGrade(scan));
                grade = grade.changeEnglishGrade(englishGrade);
                studentDTO.setGrade(grade);
                break;
            case CHANGE_MATH_GRADE:
                int mathGrade = Integer.parseInt(InputView.readMathGrade(scan));
                grade = grade.changeMathGrade(mathGrade);
                studentDTO.setGrade(grade);
                break;
            case EXIT:
                return;
            default:
                throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_CMD);
        }
        createStudent(studentDTO, true);
    }

    public void deleteStudent(String deleteStdId) {
        StudentDto studentDTO = findStudent(deleteStdId);
        studentRepository.delete(studentDTO.getStdId());
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
