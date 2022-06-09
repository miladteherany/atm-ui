package ir.teherany.model.repository;

import ir.teherany.common.JDBC;
import ir.teherany.entity.Account;
import ir.teherany.entity.AccountType;
import ir.teherany.entity.Person;

import java.sql.*;

public class AccountDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AccountDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Account account) {
        //TODO: Check this out
        Person person = new Person();
        AccountType accountType = new AccountType();

        long dbId = 0;
        String SQL = "INSERT INTO ACCOUNT (accountNo, password, balance, personId, accountType) Value (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getAccountNo());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setDouble(4, person.getId());
            preparedStatement.setDouble(5, accountType.getId());
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    dbId = resultSet.getLong("id");
                } catch (SQLException exception) {
                    throw new RuntimeException(exception.getMessage());
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
