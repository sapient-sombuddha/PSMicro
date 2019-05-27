package profiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import profiles.models.Person;
import profiles.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

//    Create object
    public Person createProfile(String firstname, String lastname, int age){
        return repository.save(new Person(firstname, lastname, age));
    }

//    Retrieve
    public List<Person> getAllProfiles(){
        return repository.findAll();
    }

    public Person getByFirstName(String firstname){
        return repository.findByFirstname(firstname);
    }
//    Update
    public Person update(String id, String firstname, String lastname, int age){
        Optional<Person> x= repository.findById(id);
        Person p =new Person();
        if(x.isPresent()){
            p = x.get();
        }
        p.setAge(age);
        p.setFirstname(firstname);
        p.setLastname(lastname);
        return repository.save(p);
    }

//    Delete
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(String id){
        repository.deleteById(id);
    }

}
