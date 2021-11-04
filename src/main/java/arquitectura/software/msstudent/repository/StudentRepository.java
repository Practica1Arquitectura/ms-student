package arquitectura.software.msstudent.repository;

import arquitectura.software.msstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
