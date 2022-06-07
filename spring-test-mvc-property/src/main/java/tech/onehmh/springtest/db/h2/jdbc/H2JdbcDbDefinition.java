package tech.onehmh.springtest.db.h2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.DbDefinition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DDL операции для БД H2
 *
 * @author Kirillov-AS
 * @since 22.05.2022
 */
@Component
public class H2JdbcDbDefinition implements DbDefinition
{
    private final H2JdbcConnectionCreator connectionCreator;

    @Autowired
    public H2JdbcDbDefinition(H2JdbcConnectionCreator connectionCreator)
    {
        this.connectionCreator = connectionCreator;
    }

    @Override
    public void createDb()
    {
        if (isExists())
        {
            throw new IllegalStateException("По пути БД файл уже существует");
        }
        else
        {
            try (Connection connection = connectionCreator.getConnection())
            {
                // для создания БД достаточно создать подключение к ней
            }
            catch (SQLException exception)
            {
                throw new IllegalStateException("Проблема с созданием БД", exception);
            }
        }
    }

    @Override
    public void deleteDb()
    {
        Path path = Paths.get(connectionCreator.getDbPath());
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Проблема с удалением БД", e);
        }
    }

    private boolean isExists()
    {
        Path path = Paths.get(connectionCreator.getDbPath());
        return Files.exists(path);
    }

}
