package com.darrendelimond.crud_demo.dao;

import com.darrendelimond.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
}
