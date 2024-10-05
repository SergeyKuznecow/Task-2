package jm.task.core.jdbc.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class Util {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "12345";

    public Util() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345");
            if (connection != null) {
                System.out.println("Connection is successful");
            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException var2) {
            SQLException e = var2;
            e.printStackTrace();
        }

        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = (new Configuration()).addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
