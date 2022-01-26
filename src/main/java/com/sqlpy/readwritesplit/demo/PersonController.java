package com.sqlpy.readwritesplit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @GetMapping("/users/{name}/{age}")
    public Person addPerson(@PathVariable("name") String name,@PathVariable("age") Integer age){
        Person person = new Person(name,age);
        Integer id = personDao.addPerson(person);
        person.setId(id);
        return person;
    }
}
