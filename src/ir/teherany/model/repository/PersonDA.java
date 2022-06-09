package ir.teherany.model.repository;

import ir.teherany.common.JDBC;
import ir.teherany.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Person person) {
        long dbId = 0;
        String sql = "INSERT INTO PERSON (FIRSTNAME, LASTNAME, AGE, NATIONALCODE) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getNationalCode());
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    dbId = resultSet.getLong("id");
                }
            }
        } catch (Exception exception) {
            System.out.println((exception.getMessage()));
        }
    }

    public void update(Person person) {
        String sql = "UPDATE PERSON SET firstName = ?, lastName = ?, age = ?, nationalCode =? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getNationalCode());
            preparedStatement.setLong(5, person.getId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void delete(long id) {
        String sql = "UPDATE PERSON SET deletedDate = ? WHERE ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, System.currentTimeMillis());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Person selectOne(long id) {
        String sql = "SELECT * FROM person WHERE ID = ?";
        Person person = new Person();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            person.setId(resultSet.getLong("id"))
                    .setFirstName(resultSet.getString("firstName"))
                    .setLastName(resultSet.getString("lastName"))
                    .setAge(resultSet.getInt("age"))
                    .setNationalCode(resultSet.getString("nationalCode"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return person;
    }

    public List<Person> selectAll() {
        List<Person> personList = new ArrayList<>();
        String sql = "Select * from person WHERE deletedDate IS NULL";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person().setId(resultSet.getLong("id"))
                        .setFirstName(resultSet.getString("firstName"))
                        .setLastName(resultSet.getString("lastName"))
                        .setAge(resultSet.getInt("age"))
                        .setNationalCode(resultSet.getString("nationalCode"));
                personList.add(person);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return personList;
    }

    public void close() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
