package com.company._4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public User selectById(String id) throws SQLException {
        String query = createQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(id, preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapRow(resultSet);
        } else {
            return null;
        }
    }


    private User mapRow(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("email")
        );
    }


    private void setValues(String id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, id);
    }


    private String createQuery() {
        return "select * from user where id = ?";
    }


}
