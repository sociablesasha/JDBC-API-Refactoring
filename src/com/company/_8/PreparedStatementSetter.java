package com.company._8;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {

    void setValues(PreparedStatement preparedStatement) throws SQLException;

}
