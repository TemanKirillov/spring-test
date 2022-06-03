package tech.onehmh.springtest.db.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.properties.AppProperty;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DDL операции для таблицы хранения {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 24.05.2022
 */
@Component
public class AppPropertyTableDefinition
{
    private final H2ConnectionCreator connectionCreator;
    private final SQLHelper sqlHelper;

    @Autowired
    public AppPropertyTableDefinition(H2ConnectionCreator connectionCreator, SQLHelper sqlHelper)
    {
        this.connectionCreator = connectionCreator;
        this.sqlHelper = sqlHelper;
    }

    /**
     * Создать таблицу
     */
    public void createTable()
    {
        try (
                Connection connection = connectionCreator.getConnection();
                Statement statement = connection.createStatement()
        )
        {
            String sql = sqlHelper.readSqlFromResources("sql/properties/create_properties.sql");
            statement.execute(sql);
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось создать таблицу", e);
        }
    }

}
