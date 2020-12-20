package by.gsu.pms;

import java.sql.*;
import java.util.ArrayList;

public class SelectQuaryDriver {
    public static final String FAMILYMEMBER_QUERY = "SELECT * FROM familymember";
    public static final String EXPENSES_QUERY = "SELECT * FROM expenses";
    public static final String EXPENSE_QUERY = "SELECT expenses_name, expenses_sum FROM expenses WHERE expenses_id = ?";
    public static final String INCOMES_QUERY = "SELECT * FROM incomes";
    public static final String INCOME_QUERY = "SELECT incomes_name, incomes_sum FROM incomes WHERE incomes_id = ?";

    private SelectQuaryDriver() {
    }

    public static ArrayList<FamilyRecord> selectFamilyRecords(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<FamilyRecord> familyRecords = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FAMILYMEMBER_QUERY);
            int familymember_id = resultSet.getInt("familymember_id");
            int incomes_id = resultSet.getInt("incomes_id");
            int expenses_id = resultSet.getInt("expenses_id");
            String familymember_name = resultSet.getString("familymember_name");

            familyRecords.add(new FamilyRecord(familymember_id, incomes_id, expenses_id, familymember_name));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return familyRecords;
    }

    public static ArrayList<Expenses> selectExpenses(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Expenses> expenses = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(EXPENSES_QUERY);

            int expenses_id = resultSet.getInt("expenses_id");
            String expenses_name = resultSet.getString("expenses_name");
            int expenses_sum = resultSet.getInt("expenses_sum");

            expenses.add(new Expenses(expenses_id, expenses_name, expenses_sum));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return expenses;
    }

    public static Expenses selectExpensesById(int expenses_id, Connection connection) throws SQLException {
        Expenses expenses;

        try (PreparedStatement preparedStatement = connection.prepareStatement(EXPENSE_QUERY)) {
            preparedStatement.setInt(1, expenses_id);
            ResultSet resultSet = null;
            expenses = null;

            try {
                resultSet = preparedStatement.executeQuery();

                String expenses_name = resultSet.getString("expenses_name");
                int expenses_sum = resultSet.getInt("expenses_sum");

                expenses = new Expenses(expenses_id, expenses_name, expenses_sum);
            } catch (SQLException sqlException) {
                System.out.println(">>> Select query execution failed.");
                sqlException.printStackTrace();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }
        return expenses;
    }

    public static ArrayList<Income> selectIncome(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Income> incomes = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(INCOMES_QUERY);

            int incomes_id = resultSet.getInt("incomes_id");
            String incomes_name = resultSet.getString("incomes_name");
            int incomes_sum = resultSet.getInt("incomes_sum");

            incomes.add(new Income(incomes_id, incomes_name, incomes_sum));
        } catch (SQLException sqlException) {
            System.out.println(">>> Select query execution failed.");
            sqlException.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
            assert resultSet != null;
            resultSet.close();
        }
        return incomes;
    }

    public static Income selectIncomeById(int incomes_id, Connection connection) throws SQLException {
        Income income;

        try (PreparedStatement preparedStatement = connection.prepareStatement(INCOME_QUERY)) {
            preparedStatement.setInt(1, incomes_id);
            ResultSet resultSet = null;
            income = null;

            try {
                resultSet = preparedStatement.executeQuery();

                String incomes_name = resultSet.getString("incomes_name");
                int incomes_sum = resultSet.getInt("incomes_sum");

                income = new Income(incomes_id, incomes_name, incomes_sum);
            } catch (SQLException sqlException) {
                System.out.println(">>> Select query execution failed.");
                sqlException.printStackTrace();
            } finally {
                assert resultSet != null;
                resultSet.close();
            }
        }
        return income;
    }
}

