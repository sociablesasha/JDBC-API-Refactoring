package com.company._3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Template {


    private Connection connection;


    public Template(Connection connection) {
        this.connection = connection;
    }


    public void insert(User user) throws SQLException {
        String query = createQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(user, preparedStatement);

        preparedStatement.executeUpdate();
    }


    abstract void setValues(User user, PreparedStatement preparedStatement) throws SQLException;


    abstract String createQuery();


}
