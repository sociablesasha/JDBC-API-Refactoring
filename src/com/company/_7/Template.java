package com.company._7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


    public Object select(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapRow(resultSet);
        } else {
            return null;
        }
    }


    abstract void setValues(PreparedStatement preparedStatement) throws SQLException;


    abstract Object mapRow(ResultSet resultSet) throws SQLException;


}
