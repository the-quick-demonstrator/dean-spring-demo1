package com.example.deandemo;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/person")
// make a call to this controller, the endpoint I am calling is prefixed with `/person`
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(value = "/create") // make a call to `/person/create`
    public ResponseEntity<Person> create(Person personToPersist) {
        Person personInDatabase = personRepository.save(personToPersist);
        return new ResponseEntity<>(personInDatabase, HttpStatus.CREATED);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<String> page() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
