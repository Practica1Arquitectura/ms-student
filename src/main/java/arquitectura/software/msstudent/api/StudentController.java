package arquitectura.software.msstudent.api;

import arquitectura.software.msstudent.entity.Student;
import arquitectura.software.msstudent.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public String testStudent(){
        return "Ms-Student";
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        LOGGER.info("Registrando el usuario: con los siguientes datos, {} ",student);
        return studentRepository.save(student);
    }

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        if(students.size()>0){
            LOGGER.info("Se muestra los datos de todos los estudiantes");
        }else {
            LOGGER.warn("No se encontro ningun dato de los estudiantes");
        }
        return students;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Student getStudent(@RequestParam Integer studentId) throws Exception{
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()){
            LOGGER.info("Se encontro al estudiante");
            Student student = studentOptional.get();
            return student;
        }else {
            LOGGER.error("no se encontro al estudiante");
            throw new Exception("No se encuentra el usuario");
        }
    }

}
