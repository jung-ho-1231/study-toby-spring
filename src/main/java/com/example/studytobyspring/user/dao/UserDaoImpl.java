package com.example.studytobyspring.user.dao;

import com.example.studytobyspring.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public static final RowMapper<User> USER_ROW_MAPPER = (rs, rwoNum) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        return user;
    };
    private DataSource dataSource;
    private JdbcContext jdbcContext;
    private JdbcTemplate jdbcTemplate;


    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcContext = new JdbcContext(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy strategy = c -> {
            PreparedStatement ps = c.prepareStatement(
                    "insert into users(id, name, password) values (?, ?, ?)"
            );
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            return ps;
        };
        jdbcContext.workWithStatementStrategy(strategy);
    }

    @Override
    public User get(String id) throws ClassNotFoundException, SQLException {
        return jdbcTemplate.queryForObject(
                "select * from users where id = ?",
                USER_ROW_MAPPER,
                id
        );
    }

    @Override
    public void deleteAll() throws SQLException {
        jdbcTemplate.update("delete from users");
    }

    @Override
    public int getCount() throws SQLException {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from users;", Integer.class);
        return integer;
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(
                "select * from users order by id",
                USER_ROW_MAPPER
        );
    }
}
