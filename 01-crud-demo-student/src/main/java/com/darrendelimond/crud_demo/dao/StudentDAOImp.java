package com.darrendelimond.crud_demo.dao;

import com.darrendelimond.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImp implements StudentDAO{

   private EntityManager entityManager;

@Autowired
   public StudentDAOImp(EntityManager entityManager){
       this.entityManager = entityManager;
   }


    @Override
    @Transactional
    public void save(Student theStudent){

        entityManager.persist(theStudent);

        System.out.println("Saving Student Object");
    }


    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> findAll(){

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

            return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lastname){

    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);

    theQuery.setParameter("theData", lastname);

    return theQuery.getResultList();
    };


@Override
@Transactional
    public void update(Student student){

        entityManager.merge(student);
}


@Override
@Transactional
    public void delete(int id){

    Student returnedStudent = entityManager.find(Student.class, id);

    entityManager.remove(returnedStudent);
}
}
