package demo.service;

import demo.entity.Course;
import demo.entity.Student;
import demo.repository.CourseRepository;
import demo.repository.StudentRepository;
import demo.request.StudentRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(StudentRequest studentRequest) {

        Course course = null;
        if (studentRequest.getCourseId() != null) {
            course = courseRepository.findById(
                    studentRequest.getCourseId()).orElseThrow(() -> new RuntimeException()
            );
        }
        Student student = new Student(studentRequest.getId(), studentRequest.getName(), studentRequest.getEmail(), course);
        studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}