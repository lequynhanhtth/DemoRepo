package demo.service;

import demo.entity.Course;
import demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     *  java doc
     * @return Courses of KR
     */
    public List<Course> getAllCourses() {
        // Return All cours from DB
        return courseRepository.findAll();
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
