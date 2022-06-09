package ir.teherany.model.repository;

import ir.teherany.common.JDBC;
import ir.teherany.entity.Account;
import ir.teherany.entity.TransactionStatus;
import ir.teherany.entity.TransactionType;
import ir.teherany.entity.Withdraw;

import java.sql.*;

public class WithdrawDA implements AutoCloseable {
    Connection connection;
    PreparedStatement preparedStatement;

    public WithdrawDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Withdraw withdraw) {
        Account account = new Account();
        TransactionStatus transactionStatus = new TransactionStatus();
        TransactionType transactionType = new TransactionType();
        long dbId = 0;
        String SQL = "INSERT INTO transaction (amount, createdDate, accountID, transactionStatusId, transactionTypeId) Values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, withdraw.getAmount());
            preparedStatement.setTimestamp(2, withdraw.getCreatedDate());
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

    }
}
