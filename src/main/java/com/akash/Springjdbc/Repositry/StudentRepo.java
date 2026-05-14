package com.akash.Springjdbc.Repositry;

import com.akash.Springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.org.jline.utils.Colors.s;

@Repository
public class StudentRepo {
    @Autowired
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student(roll,name,marks) values(?,?,?)";
       int rows = jdbc.update(sql,s.getRoll(),s.getName(),s.getMarks());
        System.out.println(rows);
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper = (rs, rowNum) -> {
                Student s = new Student();
                s.setRoll(rs.getInt("roll"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            };
        return jdbc.query(sql,mapper);
        }


}
