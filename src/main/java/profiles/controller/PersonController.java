package profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import profiles.models.Person;
import profiles.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping("/create")
    public Person create(@RequestParam String firstname, @RequestParam String lastname, @RequestParam int age){
        Person p = service.createProfile(firstname, lastname, age);
        return p;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, params = {"firstname"})
    public Person getPerson(@RequestParam String firstname){
        return service.getByFirstName(firstname);
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Person> getAll(){
        return service.getAllProfiles();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, params = {"id", "firstname", "lastname", "age"})
    public Person update(@RequestParam String id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age){
        return service.update(id, firstname, lastname, age);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, params = {"id"})
    public void deleteById(@RequestParam String id){
        service.deleteById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteAll(){
        service.deleteAll();
    }
}
