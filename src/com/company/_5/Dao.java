package com.company._5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public Object selectById(final String id) throws SQLException {
        Template template = new Template(connection) {
            @Override
            Object mapRow(ResultSet resultSet) throws SQLException {
                return new User(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }

            @Override
            void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, id);
            }

            @Override
            String createQuery() {
                return "SELECT * FROM user WHERE id = ?";
            }
        };

        return template.select();
    }


    public Object selectByIdAndName(final String id, final String name) throws SQLException {
        Template template = new Template(connection) {
            @Override
            Object mapRow(ResultSet resultSet) throws SQLException {
                return new User(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }

            @Override
            void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
            }

            @Override
            String createQuery() {
                return "SELECT * FROM user WHERE id = ? AND name = ?";
            }
        };

        return template.select();
    };


}
