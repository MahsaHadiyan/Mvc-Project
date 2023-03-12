package org.j2os.project.common.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.10   Mahsa.h
 */
public class JDBC {

    private static final BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();

    static {
        BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        BASIC_DATA_SOURCE.setUsername("mahsa");
        BASIC_DATA_SOURCE.setPassword("myJava123");
        BASIC_DATA_SOURCE.setMaxTotal(10);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = BASIC_DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
