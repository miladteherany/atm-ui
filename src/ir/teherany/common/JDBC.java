package ir.teherany.common;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUrl("jdbc:postgresql://156.253.5.223:5432/atm");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("myjava123");
        basicDataSource.setMaxTotal(100);
        basicDataSource.setMaxIdle(50);
    }

    public static Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }
}
