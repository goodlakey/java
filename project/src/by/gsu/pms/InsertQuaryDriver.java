package by.gsu.pms;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class InsertQuaryDriver {
    public static final String FAMILYMEMBER_QUERY = "INSERT INTO familymember (incomes_id, expenses_id, familymember_name) VALUES (?, ?, ?);";
    public static final String INCOMES_QUERY = "INSERT INTO incomes (incomes_name, incomes_sum) VALUES (?, ?);";
    public static final String EXPENSES_QUERY = "INSERT INTO expenses (expenses_name, expenses_sum) VALUES (?, ?);";

    private InsertQuaryDriver(){}

    public static void insertProductsRecord(ArrayList<Object> queryParameters, Connection connection){
        try (PreparedStatement preparedStatement = connection.prepareStatement(FAMILYMEMBER_QUERY)) {
            preparedStatement.setInt(1, (Integer) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.setString(3,  (String) queryParameters.get(2));

            preparedStatement.execute();
            System.out.println(">>> Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        }
    }
    public static void insertIncomes(ArrayList<Object> queryParameters, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INCOMES_QUERY)) {
            preparedStatement.setString(1, (String) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.execute();
            System.out.println(">>> Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        }
    }
    public static void insertExpenses(ArrayList<Object> queryParameters, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(EXPENSES_QUERY)) {
            preparedStatement.setString(1, (String) queryParameters.get(0));
            preparedStatement.setInt(2, (Integer) queryParameters.get(1));
            preparedStatement.execute();
            System.out.println(">>> Insert query executed...");
        } catch (SQLException sqlEx) {
            System.out.println(">>> Insert query execution failed.");
            sqlEx.printStackTrace();
        }
    }
}
