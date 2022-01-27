package com.sqlpy.readwritesplit.demo.daos;

import com.sqlpy.readwritesplit.demo.entitys.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PersonDao {

    //@Autowired
    @Resource(name="jdbcTemplateWrite")
    private JdbcTemplate jdbcTemplate;

    @Resource(name="jdbcTemplateRead")
    private JdbcTemplate jdbcTemplateRead;

    private String sqlAddPerson = "insert into tempdb.person(name,age) values(?,?);";
    private String sqlQueryPerson = "select id,name,age from tempdb.person where id = ?;";

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

    public Person queryPersonById(Integer id) {
        return this.jdbcTemplateRead.queryForObject(this.sqlQueryPerson,new BeanPropertyRowMapper<>(Person.class),id);
    }

}
