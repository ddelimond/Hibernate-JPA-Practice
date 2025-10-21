package com.darrendelimond.crud_demo.dao;

import com.darrendelimond.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(int id);

    public void update(Student student);

    public void delete(int id);


    public List<Student> findAll();

    public List<Student> findByLastName(String lastname);
}
