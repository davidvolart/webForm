package cat.tecnocampus.UseCases;

import cat.tecnocampus.domain.Classroom;
import cat.tecnocampus.persintence.ClassroomDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("classroomUseCases")
public class ClassroomUseCases {

    private final ClassroomDAO clrDAO;


    public ClassroomUseCases(ClassroomDAO clrDAO) {
        this.clrDAO = clrDAO;
    }


    //The @Transactiona annotation states that saveClassroom is a transaction. So ,if a unchecked exception is signaled
    // (and not cached) during the saveUser method the transaction is going to rollback
    @Transactional
    public int insert(Classroom clr) {
        return this.clrDAO.insert(clr);
    }


    public int[] insertBatch(List<Classroom> aux) {
        return this.clrDAO.insertBatch(aux);
    }


    public List<Classroom> findAll() {
        return this.clrDAO.findAll();
    }


    public List<Classroom> findCapacityLargerThan(int capacity) {
        return this.clrDAO.findCapacityLargerThan(capacity);
    }


    public List<Classroom> findCapacityLowerThan(int capacity) {
        return this.clrDAO.findCapacityLowerThan(capacity);
    }


    public List<Classroom> findWithPlugs() {
        return this.clrDAO.findWithPlugs();
    }


    public List<Classroom> findWithNoPlugs() {
        return this.clrDAO.findWithNoPlugs();
    }


    public Classroom findByName(String name) {
        return this.clrDAO.findByName(name);
    }
}