package ir.teherany.model.repository;

import ir.teherany.common.JDBC;
import ir.teherany.entity.Account;
import ir.teherany.entity.Deposit;
import ir.teherany.entity.TransactionStatus;
import ir.teherany.entity.TransactionType;

import java.sql.*;

public class DepositDA implements AutoCloseable {
    Connection connection;
    PreparedStatement preparedStatement;

    public DepositDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Deposit deposit) {
        Account account = new Account();
        TransactionStatus transactionStatus = new TransactionStatus();
        TransactionType transactionType = new TransactionType();
        long dbId = 0;
        String SQL = "INSERT INTO transaction (amount, createdDate, accountID, transactionStatusId, transactionTypeId) Values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, deposit.getAmount());
            preparedStatement.setTimestamp(2, deposit.getCreatedDate());
            preparedStatement.setDouble(3, account.getId());
            preparedStatement.setDouble(4, transactionStatus.getId());
            preparedStatement.setDouble(5, transactionType.getId());
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
