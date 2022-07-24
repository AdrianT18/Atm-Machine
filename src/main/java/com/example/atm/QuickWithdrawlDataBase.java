package com.example.atm;

import java.sql.*;

public class QuickWithdrawlDataBase {
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    boolean result;
    ResultSet rs;

    public int balances() throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT Account_Number, Balance FROM AtmUsers  ";
            rs = statement.executeQuery(sql);

            if (rs.next())
                rs.getInt("Balance");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs.getInt("Balance");
    }

    public boolean withdraw10(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 10   WHERE Account_Number =?"
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() < 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
