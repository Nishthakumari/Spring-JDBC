package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        System.out.println("My program started");
        //spring jdbc -> jdbcTemplate
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class );

//        Student student  = new Student();
//        student.setId(666);
//        student.setName("Mugdha");
//        student.setCity("hyderabad");
//
//        int result = studentDao.insert(student);
//
//        System.out.println("Student Added "+ result);

//        Student student = new Student();
//        student.setId(1345);
//        student.setName("rimmi");
//        student.setName("delhi");
//
//        int result = studentDao.change(student);
//
//        System.out.println("Student changed "+ result);
//
//        int result = studentDao.delete(5345);
//        System.out.println("deleted "+result);

        Student student = studentDao.getStudent(1345);
        System.out.println(student);





    }
}
