package com.company._8;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public void insert(User user) throws SQLException {
        Template template = new Template(connection);
        template.insert(
                "INSERT INTO user VALUES (?, ?, ?)",
                preparedStatement -> {
                    preparedStatement.setString(1, user.getId());
                    preparedStatement.setString(2, user.getName());
                    preparedStatement.setString(3, user.getEmail());
                }
        );
    }


    public Object select(String id) throws SQLException {
        Template template = new Template(connection);
        return template.select(
                "SELECT * FROM user WHERE id = ?",
                preparedStatement -> {
                    preparedStatement.setString(1, id);
                },
                resultSet -> new User(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                )
        );
    }

    
}
