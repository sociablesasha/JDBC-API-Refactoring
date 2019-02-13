package com.company._7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Template {


    private Connection connection;


    public Template(Connection connection) {
        this.connection = connection;
    }


    public void insert(String query, PreparedStatementSetter preparedStatementSetter) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatementSetter.setValues(preparedStatement);

        preparedStatement.executeUpdate();
    }


    public Object select(String query, PreparedStatementSetter preparedStatementSetter, RowMapper rowMapper) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatementSetter.setValues(preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return rowMapper.mapRow(resultSet);
        } else {
            return null;
        }
    }


}
