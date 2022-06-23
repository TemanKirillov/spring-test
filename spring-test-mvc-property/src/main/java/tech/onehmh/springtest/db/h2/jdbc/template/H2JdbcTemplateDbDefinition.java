package tech.onehmh.springtest.db.h2.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.DbDefinition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/**
 * DDL операции для БД H2
 *    при использовании JdbcTemplate
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
@Component
public class H2JdbcTemplateDbDefinition implements DbDefinition
{
    private final DriverManagerDataSource dataSource;
    private String dbPath;

    /**
     * Конструктор
     *
     * @param dataSource датасорс для БД H2
     */
    @Autowired
    public H2JdbcTemplateDbDefinition(DriverManagerDataSource dataSource)
    {
        this.dataSource = dataSource;
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
            try (Connection connection = dataSource.getConnection())
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
        if (!isExists())
        {
            throw new IllegalStateException("БД не существует");
        }

        Optional.ofNullable(dbPath)
                .map(Paths::get)
                .ifPresent(path ->
                {
                    try
                    {
                        Files.delete(path);
                    }
                    catch (IOException e)
                    {
                        throw new IllegalStateException("Проблема с удалением БД", e);
                    }
                }
                );
    }

    @Autowired
    public void setProperties(
            @Value("${h2.db.path}") String dbPath
    )
    {
        this.dbPath = dbPath;
    }

    private boolean isExists()
    {
        return Optional.ofNullable(dbPath)
                .map(Paths::get)
                .map(Files::exists)
                .orElseThrow(() -> new IllegalArgumentException("Invalid path"));
    }


}
