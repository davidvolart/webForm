package cat.tecnocampus.webController;

import cat.tecnocampus.UseCases.ClassroomUseCases;
import cat.tecnocampus.domain.Classroom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.form.ErrorsTag;

import javax.validation.Valid;


@Controller
public class ClassroomWEBPOSTController {


    private ClassroomUseCases clrUseCases;


    public ClassroomWEBPOSTController(ClassroomUseCases clrUseCases) {
        this.clrUseCases = clrUseCases;
    }


    @GetMapping("/newClass")
    public String createClassroom(Model model) {
        model.addAttribute("clr", new Classroom());
        return "CreateClassroom";
    }


    @PostMapping("/newClassroom")
    //See Errors error parameters: it takes the errors from the validators. It MUST be right after the parameters
    public String createClassroom(@Valid @ModelAttribute("clr") Classroom clr, Errors errors, Model model, RedirectAttributes redirectAttributes) {


        if (errors.hasErrors()) {
            model.addAttribute("clr", clr);

            return "CreateClassroom";
        }

        model.addAttribute("name", clr.getName());

        clrUseCases.insert(clr);

        redirectAttributes.addAttribute("name", clr.getName());

        return "redirect:/showClr/{name}";
    }


}
