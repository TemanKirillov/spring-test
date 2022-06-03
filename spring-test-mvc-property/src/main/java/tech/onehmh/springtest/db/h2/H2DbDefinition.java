package tech.onehmh.springtest.db.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class H2DbDefinition
{
    private final H2ConnectionCreator connectionCreator;

    @Autowired
    public H2DbDefinition(H2ConnectionCreator connectionCreator)
    {
        this.connectionCreator = connectionCreator;
    }

    /**
     * Создать пустую БД
     */
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

    /**
     * Удалить БД
     */
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
