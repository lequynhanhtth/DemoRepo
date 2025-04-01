package demo.service;

import demo.entity.Course;
import demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CourseService {

    /**
     *  java doc
     * @return Courses of KR
     */
    public List<Course> getAllCourses();

    public void saveCourse(Course course);

    public Course getCourseById(int id) ;

    public void deleteCourse(int id) ;
}
