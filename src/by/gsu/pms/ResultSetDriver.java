package by.gsu.pms;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDriver {
    private ResultSetDriver() {
    }

    public static String parseResultSet(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<p>Task number: " + taskNumber + "</p>");
        while (resultSet.next()) {
            String gName = resultSet.getString(1);
            String pName = resultSet.getString(2);
            String life = resultSet.getString(3);
            String sattelite = resultSet.getString(4);
            taskResult.append(String.format("Galaxy name: %-10s | planet name: %-10s | life: %-10s | sattelite %-10s<br>", gName, pName, life, sattelite));
        }
        return taskResult.toString();
    }

    public static String parseResultSetExtended(int taskNumber, ResultSet resultSet) throws SQLException {
        StringBuilder taskResult = new StringBuilder("<p>Task number: " + taskNumber + "</p>");
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int param1 = resultSet.getInt(2);
            taskResult.append(String.format("name: %-10s | parametr: %-10s <br>", name, param1));
        }
        return taskResult.toString();
    }
}