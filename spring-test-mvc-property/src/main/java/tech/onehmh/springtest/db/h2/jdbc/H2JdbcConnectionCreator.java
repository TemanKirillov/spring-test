package tech.onehmh.springtest.db.h2.jdbc;

import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Помощник по созданию соединений к БД H2
 */
@Component
public class H2JdbcConnectionCreator
{
    private static final String DB_PATH = "/Users/U19011169/work/databases/properties.mv.db";
    private static final String DB_JDBC_PATH = "jdbc:h2:~/work/databases/properties";
    private static final String USER_H2_DEFAULT = "sa";
    private static final String PASSWORD_H2_DEFAULT = "";

    /**
     * @return Соединение к БД
     */
    @SuppressWarnings({"squid:S2115", "squid:S4925"}) //4925: необходимо подгружать драйвер
    public Connection getConnection()
    {
        try
        {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(DB_JDBC_PATH, USER_H2_DEFAULT, PASSWORD_H2_DEFAULT);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new IllegalStateException("Проблема с соединением к БД", e);
        }
    }

    /**
     * @return путь до БД
     */
    public String getDbPath()
    {
        return DB_PATH;
    }

}
