package pl.sda.poznan;

import javax.print.attribute.standard.MediaSize;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static final String CREATE_USERS_QUERY = "CREATE TABLE if NOT EXISTS " +
            "USERS(id int primary key AUTO_INCREMENT, name varchar(255), surname varchar(255), email varchar(255))";

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/sda-jdbc-intro", "root", "Toshiba05");

        Statement statement = connection.createStatement();
        statement.execute(CREATE_USERS_QUERY);

        connection.createStatement()
                .execute("INSERT into USERS(name, surname, email) values('jan', 'kowalski', 'jan.kowalski@sda.pl')");
        connection.createStatement()
                .execute("INSERT into USERS(name, surname, email) values('krzysztof', 'nowak', 'krzysztof.nowak@sda.pl')");
        connection.createStatement()
                .execute("INSERT into USERS(name, surname, email) values('jan', 'nowak', 'jan.nowak@sda.pl')");

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT id, name, surname, email FROM USERS");

        List<User> users = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            users.add(user);
        }

        users.forEach(System.out::println);

        //COUNT
        ResultSet otherResultSet = connection.createStatement().executeQuery("SELECT COUNT(id) FROM USERS");
        otherResultSet.next();
        int count = otherResultSet.getInt(1);
        System.out.println("Users amount: " + count);

        //UPDATE - email update for specified user id
        connection.createStatement().executeUpdate("UPDATE USERS SET email = 'newmail@sda.eu' WHERE id = 1");

        //DELETE - user delete for specified user id
        connection.createStatement().executeUpdate("DELETE FROM USERS WHERE id > 3");

        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your surname: ");
        String name = scanner.next();

        connection.createStatement().execute("INSERT INTO USERS(surname) VALUES('"+ name +"');");
    }
}
