package bilgeadam;

import bilgeadam.dao.PersonDAO;
import bilgeadam.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @Autowired
    @Qualifier("personDAO")
    private PersonDAO personDAO;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersonList(Model model) {
        model.addAttribute("personList", this.personDAO.personList());
        return "person";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person) {
        if (person != null && this.personDAO.findById(person.getId()) != null) {
            this.personDAO.updatePerson(person);
        } else {
            this.personDAO.addPerson(person);
        }
        return "redirect:/persons";
    }

    @RequestMapping(value = "/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        this.personDAO.deletePerson(id);
        return "redirect:/persons";
    }
}
