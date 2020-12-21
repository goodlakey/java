package by.lab10;

import by.gsu.pms.ConnectionDriver;
import by.gsu.pms.SelectQueryDriver;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean test = true;

        Connection connection = new ConnectionDriver().getConnect();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
    //    try {
   //         Reader readerCreate = new BufferedReader(new FileReader("./resources/CreateScript.sql"));
      //      scriptRunner.runScript(readerCreate);

      //     Reader readerInsert = new BufferedReader(new FileReader("./resources/InsertScript.sql"));
       //     scriptRunner.runScript(readerInsert);
       //     System.out.println("Tables created and inserted");
     //   }catch (Exception ex ){
    //        System.out.println("Tables alredy exist");
    //    }
        if (connection != null) {
            showMenu();
            System.out.println("\n Please choose: ");
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    String result = "";
                    String exercise1Select = "SELECT galaxy.galaxy_name, planets.planet_name, planets.life, satellites.satellite_name\n" +
                            "FROM satellites INNER JOIN (planets INNER JOIN galaxy ON planets.id = galaxy.planets_id) ON satellites.id = planets.satellite_count\n" +
                            "WHERE (((galaxy.galaxy_name)=\"Млечный путь\") AND ((planets.life)=\"yes\"));";
                    result += SelectQueryDriver.executeSelectQuery(1, exercise1Select, connection);
                    String exercise2Select = "SELECT planet_name, COUNT(planet_name)  as NumberOfSatellites\n" +
                            "FROM planets\n" +
                            "GROUP BY planet_name\n" +
                            "HAVING COUNT(planet_name) \n" +
                            "ORDER BY NumberOfSatellites DESC LIMIT 1;";
                    result += SelectQueryDriver.executeSelectQuery(2, exercise2Select, connection);
                    String exercise3Select =
                            "SELECT galaxy.galaxy_name, Max(planets.temp_core) AS Maxtemp_core\n" +
                                    "FROM satellites INNER JOIN (planets INNER JOIN galaxy ON planets.id = galaxy.planets_id) ON satellites.id = planets.satellite_count\n" +
                                    "GROUP BY galaxy.galaxy_name;";
                    result += SelectQueryDriver.executeSelectQuery(3, exercise3Select, connection);
                    reportToHTML(result);
                    break;
                case 2:
                    System.out.println("exit");
                    test = false;
                    connection.close();
                    break;
                default:
                    System.out.println("err input");
                    break;
            }
        } else {
            System.out.println("exit");
        }

    }

    public static void showMenu() {
        System.out.println("Please select query type : ");
        System.out.println("Select query : 1");
        System.out.println("exit program : 2");
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
