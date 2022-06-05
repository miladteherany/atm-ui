package ir.teherany.model.repository;

import ir.teherany.common.JDBC;
import ir.teherany.entity.Person;

import java.sql.*;

public class PersonDA implements AutoCloseable {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Person person) {
        long dbId = 0;
        String SQL = "INSERT INTO PERSON WHERE (FIRSTNAME, LASTNAME, AGE, NATIONALCODE) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getNationalCode());
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        dbId = resultSet.getLong("id");
                    }
                } catch (SQLException exception) {
                    throw new RuntimeException(exception.getMessage());
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public void close() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
