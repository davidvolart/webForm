package cat.tecnocampus;

import cat.tecnocampus.UseCases.ClassroomUseCases;
import cat.tecnocampus.domain.Classroom;
import cat.tecnocampus.webController.ClassroomWebGETController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EX4Application implements CommandLineRunner {

    @Autowired
    ClassroomUseCases clrUsesCases;


    public static void main(String[] args) {
        SpringApplication.run(EX4Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {


        System.out.println("Find all:");
        clrUsesCases.findAll().forEach(System.out::println);

        System.out.println("\n\nFind capacity larger than");
        clrUsesCases.findCapacityLargerThan(50).forEach(System.out::println);

        System.out.println("\n\nFind capacity lower than");
        clrUsesCases.findCapacityLowerThan(60).forEach(System.out::println);

        System.out.println("\n\nFind no plugs");
        clrUsesCases.findWithNoPlugs().forEach(System.out::println);

        System.out.println("\n\nFind with plugs");
        clrUsesCases.findWithPlugs().forEach(System.out::println);


        List<Classroom> classroomList = new ArrayList<>();
        classroomList.add(new Classroom.ClassroomBuilder()
                .name("Class1").capacity(10).orientation("sud").plugs(false).build());
        classroomList.add(new Classroom.ClassroomBuilder()
                .name("Class2").capacity(10).orientation("sud").plugs(false).build());
        clrUsesCases.insertBatch(classroomList);

        clrUsesCases.insert(new Classroom.ClassroomBuilder()
                .name("Class3").capacity(10).orientation("sud").plugs(false).build());

        System.out.println("\n\nFind all:");
        clrUsesCases.findAll().forEach(System.out::println);


        System.out.println("\n\nFind with name: 100");
        System.out.println(clrUsesCases.findByName("100"));

    }
}
