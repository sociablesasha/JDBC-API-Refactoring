package com.company._3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public void insert(User user) throws SQLException {
        Template template = new Template(connection) {
            @Override
            void setValues(User user, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getEmail());
            }

            @Override
            String createQuery() {
                return "INSERT INTO user VALUES (?, ?, ?)";
            }
        };
        template.insert(user);
    }


}
