package com.company._4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Template {


    private Connection connection;


    public Template(Connection connection) {
        this.connection = connection;
    }


    public void insert(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(preparedStatement);

        preparedStatement.executeUpdate();
    }


    abstract void setValues(PreparedStatement preparedStatement) throws SQLException;


}
