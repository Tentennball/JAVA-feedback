package repository;

import domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentsRepository {

    public static final Map<Integer, Student> students = new ConcurrentHashMap<>();

    public void save(Student student){
        students.put(student.getStdId(), student);
    }

    public Student findById(int searchStdId) {
        return students.get(searchStdId);
    }

    public List<Student> findAll(){
        List<Student> findStudents= new ArrayList<>();
        for (Map.Entry<Integer, Student> entrySet : students.entrySet()) {
            findStudents.add(new Student(entrySet.getValue()));
        }
        return findStudents;
    }

    public void delete(int stdId){
        students.remove(stdId);
    }
}
