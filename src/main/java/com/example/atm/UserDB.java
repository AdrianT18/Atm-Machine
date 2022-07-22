package com.example.atm;

import java.sql.*;

public class UserDB {
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    boolean result;
    ResultSet rs;
    int currentBalance = 0;


    //Getting the details from the DB
    //From the AccountNumber column
    public boolean validateAccount(String AccountNumber, String Pin) {
        //Calling the connection
        Connection con = ConnectDB.getConnection();

        try {
            //selecting the data from Account_Number
            statement = con.prepareStatement(
                    "SELECT Account_Number,Pin FROM AtmUsers WHERE Account_Number =? AND Pin =? ");
            statement.setString(1, AccountNumber);
            statement.setString(2, Pin);
            resultSet = statement.executeQuery();
            //If it != query then return false / if its empty row
            result = resultSet.next() || resultSet.getRow() != 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //Getting the details from the DB
    //From the balance column
    //Returns balance details

    //FIX!!
    //FIX!!
    //FIX!!
    public int balance() throws SQLException {
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
    //FIX!!
    //FIX!!
    //FIX!!

    //Updating the new balance of the user when a new amount is sent
    public boolean transferMoney(String balance, String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance =? + Balance  WHERE Account_Number =?"
            );
            statement.setString(1, balance);
            statement.setString(2, accountNumber);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Update the balance of the user sending money
    public boolean userUpdate(String balance, String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Balance = Balance - ?   WHERE Account_Number =?"
            );
            statement.setString(1, balance);
            statement.setString(2, accountNumber);
            return statement.executeUpdate() < 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Changing Pin
    //The query checks if the account details are correct (using validateAccount method) and then update the Pin
    public boolean updatePin(String pin, String account_Number) {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET Pin =? WHERE Account_Number =?"
            );
            statement.setString(1, pin);
            statement.setString(2, account_Number);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    //Blocking a lost/Stolen Card
    public boolean reportCard(String AccountNumber) {
        //Calling the connection
        Connection con = ConnectDB.getConnection();

        try {
            //Updating the first name, pin and balance to null where account number matches
            statement = con.prepareStatement(
                    "UPDATE AtmUsers SET First_Name = '---' , Pin = 0, Balance = 0 WHERE Account_Number = ?");
            statement.setString(1, AccountNumber);

            return statement.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    // Updating personal information
    public boolean updateAccount(String firstName, String address, String accountNumber) {
        //Calling DB
        Connection con = ConnectDB.getConnection();
        try {
            //Verifying account number and then updating the new name and Address
            statement = con.prepareStatement("UPDATE AtmUsers SET First_Name =?, Address =? WHERE Account_Number =?");

            statement.setString(1, firstName);
            statement.setString(2, address);
            statement.setString(3, accountNumber);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    //Verifying balance before deleting account
    //Getting the current balance of the user based of the account number provided
    public int verifyBalance(String accountNumber) throws SQLException {
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement("SELECT Balance FROM AtmUsers WHERE Account_Number =? ");

            statement.setString(1, accountNumber);
            rs = statement.executeQuery();

            if (rs.next())
                rs.getInt("Balance");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs.getInt("Balance");
    }

    //Deleting personal account
    public void deleteAccountDB(String accountNumber) {
        //Connecting to server
        Connection con = ConnectDB.getConnection();
        try {
            statement = con.prepareStatement("DELETE FROM AtmUsers WHERE Account_Number = ?  ");

            statement.setString(1, accountNumber);

            statement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

}