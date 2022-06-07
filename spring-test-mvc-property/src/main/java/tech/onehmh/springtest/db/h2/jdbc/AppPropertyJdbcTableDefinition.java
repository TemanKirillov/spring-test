package tech.onehmh.springtest.db.h2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.TableDefinition;
import tech.onehmh.springtest.db.h2.H2AppPropertySQL;
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
public class AppPropertyJdbcTableDefinition implements TableDefinition<AppProperty>
{
    private final H2JdbcConnectionCreator connectionCreator;

    @Autowired
    public AppPropertyJdbcTableDefinition(H2JdbcConnectionCreator connectionCreator)
    {
        this.connectionCreator = connectionCreator;
    }

    @Override
    public void createTable()
    {
        try (
                Connection connection = connectionCreator.getConnection();
                Statement statement = connection.createStatement()
        )
        {
            String sql = H2AppPropertySQL.CREATE_PROPERTIES.getSqlAsString();
            statement.execute(sql);
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось создать таблицу", e);
        }
    }

}
