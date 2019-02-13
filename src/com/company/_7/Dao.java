package com.company._7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public void insert (final User user) throws SQLException {
        Template template = new Template(connection) {
            @Override
            void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(1, user.getEmail());
            }

            @Override
            Object mapRow(ResultSet resultSet) throws SQLException {
                return null;
            }
        };

        template.insert("INSERT INTO user VALUES (?, ?, ?)");
    }


    public Object select (final String id) throws SQLException {
        Template template = new Template(connection) {
            @Override
            void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, id);
            }

            @Override
            Object mapRow(ResultSet resultSet) throws SQLException {
                return new User(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
        };

        return template.select("SELECT * FROM user WHERE id = ?");
    }

}
