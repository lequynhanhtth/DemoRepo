package demo.controller;

import demo.entity.Student;
import demo.exception.SaveDuplicatException;
import demo.request.StudentRequest;
import demo.service.CourseService;
import demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new StudentRequest());
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }

    @PostMapping
    public String createStudent(
            @Valid @ModelAttribute("student") StudentRequest student,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "student-form";
        }
        studentService.saveStudent(student);
        throw new SaveDuplicatException("Duplicate");
//        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        return "student-form";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute StudentRequest student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // Xử lý ngoại lệ trong controller
    @ExceptionHandler(Exception.class)
    public String handleIllegalArgumentException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // Trả về trang lỗi
    }
}