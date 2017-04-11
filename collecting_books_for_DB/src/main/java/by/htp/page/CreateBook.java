package by.htp.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateBook {

    private static final String URL = "jdbc:mysql://localhost:3306/webdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    private static final String ADD_BOOK = "INSERT INTO webdb.book (title, author, picture, price, link) VALUES (?, ?, ?, ?, ?)";


    public boolean addBook(Book book) {

        String title = book.getTitle();
        String author = book.getAuthor();
        String picUrl = book.getPicURL();
        String price = book.getPrice();
        String url = book.getUrl();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(ADD_BOOK);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, picUrl);
            statement.setString(4, price);
            statement.setString(5, url);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null)
                try {
                    statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }
}
