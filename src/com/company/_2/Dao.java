package com.company._2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public void insert(User user) throws SQLException {
        String query = createQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(user, preparedStatement);

        preparedStatement.executeUpdate();
    }


    private void setValues(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
    }


    private String createQuery() {
        return "INSERT INTO user VALUES (?, ?, ?)";
    }


}
