package com.spring.jdbc.dao;

import com.spring.jdbc.Student;

public interface StudentDao {

    public int insert(Student student);
    public  int change(Student student);
    public int delete(int studentId);
    public Student getStudent(int studentId);
}
