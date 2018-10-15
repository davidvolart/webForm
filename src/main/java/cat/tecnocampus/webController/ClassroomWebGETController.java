package cat.tecnocampus.webController;

import cat.tecnocampus.UseCases.ClassroomUseCases;
import cat.tecnocampus.domain.Classroom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ClassroomWebGETController {


    private final ClassroomUseCases clrUseCases;

    public ClassroomWebGETController(ClassroomUseCases clrUseCases) {
        this.clrUseCases = clrUseCases;
    }


    //Per a probar aquest metode he de fer http://localhost:8080/classroom
    @GetMapping("/classroom")
    public String listUsers(Model model) {
        model.addAttribute("classroomLabList", clrUseCases.findAll());
        return "classrooms";
    }


    /*
    Per a probar aquest metode amb la classroom 100 he de fer:
    http://localhost:8080/showClr/100
    */
    @GetMapping("showClr/{name}")
    public String showUser(@PathVariable String name, Model model) {
        model.addAttribute("clr", clrUseCases.findByName(name));
        return "showClassroom";
    }

}
