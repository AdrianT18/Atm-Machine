package com.example.atm;

import java.sql.*;

public class QuickWithdrawlDataBase {

    //This class is for the quickWithdrawal Class
    //This query takes the mainPage account details and verifies it with the DB the users Balance
    //Then it subtracts the appropriate amount
    PreparedStatement statement = null;
    ResultSet rs;

    public boolean withdraw10(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 10   WHERE Account_Number = ? "
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean withdraw20(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 20   WHERE Account_Number = ? "
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean withdraw50(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 50   WHERE Account_Number = ? "
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean withdraw100(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 100   WHERE Account_Number = ? "
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean withdraw150(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - 150   WHERE Account_Number = ? "
            );

            statement.setString(1, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean otherAmount(Integer otherAmount, String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - ?   WHERE Account_Number = ? "
            );

            statement.setInt(1, otherAmount);
            statement.setString(2, accountNumber);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Balance
    public int balance(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "SELECT Balance FROM AtmUsers WHERE Account_Number = ?"
            );

            statement.setString(1, accountNumber);

            rs = statement.executeQuery();
            if (rs.next()) {
                rs.getInt("Balance");
            }
//            Statement statement = con.createStatement();
//            String sql = "SELECT Balance FROM AtmUsers";
//            ResultSet rs = statement.executeQuery(sql);


        } catch (SQLException E) {
            throw new RuntimeException();
        }
        return rs.getInt("Balance");
    }

}
