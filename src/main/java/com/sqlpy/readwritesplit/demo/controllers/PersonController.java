package com.sqlpy.readwritesplit.demo.controllers;

import com.sqlpy.readwritesplit.demo.daos.PersonDao;
import com.sqlpy.readwritesplit.demo.entitys.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonDao personDao;

    // 一个 hello world 程序为了方便这里就直接 Get 了，不用 post 。
    @GetMapping("/users/{name}/{age}")
    public Person addPerson(@PathVariable("name") String name, @PathVariable("age") Integer age){
        Person person = new Person(name,age);
        Integer id = personDao.addPerson(person);
        person.setId(id);
        return person;
    }

    @GetMapping("/users/{id}")
    public Person queryPersonById(@PathVariable("id") Integer id) {
        return personDao.queryPersonById(id);
    }
}
