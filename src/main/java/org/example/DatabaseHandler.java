package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseHandler {

    private static final String URL = "`accolite interview data - q4 2023 - grad program november 2023`";
    private static final String USER = "admin";
    private static final String PASSWORD = "Tdjs@9401";

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
    }

    public static void insertDataIntoDatabase(List<YourDataModel> records) {
        try (Connection connection = dataSource.getConnection()) {
            String insertQuery = "INSERT INTO your_table (column1, column2, ...) VALUES (?, ?, ...)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (YourDataModel record : records) {
                    preparedStatement.setString(1, record.getValue1());
                    preparedStatement.setString(2, record.getValue2());
                    // Set more parameters as needed

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
