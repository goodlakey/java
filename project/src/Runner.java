import by.gsu.pms.*;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean run = true;
        Mapper mapper = new Mapper();
        ArrayList<Object> queryParameters = new ArrayList<>();
        Connection connection = ConnectionDriver.openConnection();
        //     ScriptRunner scriptRunner = new ScriptRunner(connection);
        //  Reader readerCreate = new BufferedReader(new FileReader("./project/resources/create_script.sql"));
        // scriptRunner.runScript(readerCreate);
        // Reader readerInsert = new BufferedReader(new FileReader("./project/resources/insert_script.sql"));
        //   scriptRunner.runScript(readerInsert);

        if (connection != null) {
            while (run) {
                showMenu();
                System.out.print("\nChoose menu item: ");
                userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        String result = "";
                        ArrayList<FamilyRecord> familyRecords = SelectQuaryDriver.selectFamilyRecords(connection);
                        for (FamilyRecord familyRecord : familyRecords) {
                            Income income = SelectQuaryDriver.selectIncomeById(familyRecord.getIncomes_id(), connection);
                            Expenses expenses = SelectQuaryDriver.selectExpensesById(familyRecord.getExpences_id(), connection);
                            FmDTO fmDTO = mapper.mapFmDTO(familyRecord, expenses, income);
                        }
                        reportToHTML(result);
                        break;
                    case 2:
                        String result1 = "";
                        ArrayList<Income> incomes = SelectQuaryDriver.selectIncome(connection);
                        reportToHTML(result1);
                        break;
                    case 3:
                        String result2 = "";
                        ArrayList<Expenses> expenses = SelectQuaryDriver.selectExpenses(connection);
                        reportToHTML(result2);
                        break;
                    case 4:
                        System.out.print("Enter incomes id: ");
                        int incomes_id = scanner.nextInt();
                        queryParameters.add(incomes_id);
                        System.out.print("Enter expenses id: ");
                        int expenses_id = scanner.nextInt();
                        queryParameters.add(expenses_id);
                        System.out.print("Enter familymember_name: ");
                        String familymember_name = scanner.next();
                        queryParameters.add(familymember_name);
                        InsertQuaryDriver.insertProductsRecord(queryParameters, connection);
                        break;
                    case 5:
                        System.out.print("Enter incomes name: ");
                        String incomes_name = scanner.next();
                        queryParameters.add(incomes_name);
                        System.out.print("Enter incomes sum: ");
                        int incomes_sum = scanner.nextInt();
                        queryParameters.add(incomes_sum);
                        InsertQuaryDriver.insertIncomes(queryParameters, connection);
                        break;
                    case 6:
                        System.out.print("Enter Expenses name: ");
                        String Expenses_name = scanner.next();
                        queryParameters.add(Expenses_name);
                        System.out.print("Enter Expenses_sum : ");
                        int Expenses_sum = scanner.nextInt();
                        queryParameters.add(Expenses_sum);
                        InsertQuaryDriver.insertExpenses(queryParameters, connection);
                        break;

                    case 7:
                        System.out.println("\n>>> Exiting program...");
                        run = false;
                        connection.close();
                        break;
                    default:
                        System.out.println(">>> Unknown menu item! Choose another one.");
                        break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n\t\tUSER MENU");
        System.out.println("------------------------------");
        System.out.println("1. SELECT family member ");
        System.out.println("2. SELECT expenses list");
        System.out.println("3. SELECT incomes list");
        System.out.println("4. INSERT family member  record");
        System.out.println("5. INSERT expenses");
        System.out.println("6. INSERT incomes ");
        System.out.println("7. EXIT program");
    }

    public static void reportToHTML(String result) {
        File f = new File("./resources/index.html");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))) {
            System.out.println(">>> Creating report index.html file...");
            bufferedWriter.write(
                    "<!DOCTYPE html>" +
                            "<html lang=\"en\">" +
                            "   <head>" +
                            "       <meta charset=\"UTF-8\">" +
                            "       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                            "       <title>Результаты работы программы</title>" +
                            "   </head>" +
                            "   <body>" +
                            "       <h1>Результат работы программы:</h1>" +
                            "       <p>" + result + "</p>" +
                            "   </body>" +
                            "</html>"
            );
            System.out.println(">>> File saved to ./resources/index.html");
        } catch (Exception ex) {
            System.out.println(">>> Error occurred during markup save");
            ex.printStackTrace();
        }
    }
}
