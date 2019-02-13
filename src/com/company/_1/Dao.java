package com.company._1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {


    private Connection connection;


    public Dao(Connection connection) {
        this.connection = connection;
    }


    public void insert(User user) throws SQLException {
        String query = "INSERT INTO user VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());

        preparedStatement.executeUpdate();
    }


}
