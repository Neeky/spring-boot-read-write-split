package com.sqlpy.readwritesplit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String sqlAddPerson = "insert into tempdb.person(name,age) values(?,?);";

    public Integer addPerson(Person person) {

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sqlAddPerson, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, person.getName());
                statement.setInt(2, person.getAge());
                return statement;
            }
        }, holder);
        return holder.getKey().intValue();
    }
}
