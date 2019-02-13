package com.company._6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Template {


    private Connection connection;


    public Template(Connection connection) {
        this.connection = connection;
    }


    public Object select() throws SQLException {
        String query = createQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        setValues(preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapRow(resultSet);
        } else {
            return null;
        }
    }


    abstract Object mapRow(ResultSet resultSet) throws SQLException;


    abstract void setValues(PreparedStatement preparedStatement) throws SQLException;


    abstract String createQuery();


}
