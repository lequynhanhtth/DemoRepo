package demo;

import demo.service.CourseService;

public class demo {
    CourseService courseService;

    public demo(CourseService courseService) {
        this.courseService = courseService;
    }

    public void demo() {
        courseService.getCourseById(1231);
    }
}
