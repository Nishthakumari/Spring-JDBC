package com.spring.jdbc.dao;

import com.spring.jdbc.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao{

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
}
