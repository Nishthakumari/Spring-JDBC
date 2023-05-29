package com.spring.jdbc.dao;

import com.spring.jdbc.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(){

    }

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        //insert query
        String query= "insert into student(id, name, city) values(?,?, ?)";
        int f = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return f;
    }

    @Override
    public int change(Student student) {
        //updating data
        String query = "update student set name=?, city=? where id=?";
        int r  =this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
    }

    @Override
    public int delete(int studentId) {
        //deleting data
        String query = "delete from student where id =?";
        int r = this.jdbcTemplate.update(query, studentId);
        return r;

    }

    @Override
    public Student getStudent(int studentId) {
        //selecting single student data
        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;

    }

    @Override
    public List<Student> getAllStudents() {
        String query  ="select * from student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;

    }
}
