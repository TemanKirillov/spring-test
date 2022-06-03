package tech.onehmh.springtest.db.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.properties.AppProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DML операции для таблицы хранения {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 24.05.2022
 */
@Component
public class AppPropertyTableManipulation implements TableManipulation<AppProperty, Long>
{
    private static final String ID_COLUMN = "ID";
    private static final String PROPERTY_KEY_COLUMN = "PROPERTY_KEY";
    private static final String PROPERTY_VALUE_COLUMN = "PROPERTY_VALUE";

    private final H2ConnectionCreator connectionCreator;
    private final SQLHelper sqlHelper;

    @Autowired
    public AppPropertyTableManipulation(H2ConnectionCreator connectionCreator, SQLHelper sqlHelper)
    {
        this.connectionCreator = connectionCreator;
        this.sqlHelper = sqlHelper;
    }

    @Override
    public List<AppProperty> getAll()
    {
        try (
                Connection connection = connectionCreator.getConnection();
                Statement statement = connection.createStatement()
        )
        {
            String sql = sqlHelper.readSqlFromResources("sql/properties/select_all_properties.sql");
            ResultSet resultSet = statement.executeQuery(sql);
            List<AppProperty> result = new ArrayList<>();

            while (resultSet.next())
            {
                result.add(getAppPropertyFromResultSet(resultSet));
            }
            return result;
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось извлечь данные", e);
        }
    }

    @Override
    public Optional<AppProperty> getById(Long id)
    {
        String sql = sqlHelper.readSqlFromResources("sql/properties/select_property_by_id.sql");

        try (
                Connection connection = connectionCreator.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setLong(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next())
            {
                return Optional.of(getAppPropertyFromResultSet(resultSet));
            }
            else
            {
                return Optional.empty();
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось извлечь данные", e);
        }
    }

    @Override
    public void add(AppProperty appProperty)
    {
        String sql = sqlHelper.readSqlFromResources("sql/properties/insert_property.sql");

        try (
                Connection connection = connectionCreator.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setLong(1, appProperty.getId());
            statement.setString(2, appProperty.getPropertyKey());
            statement.setString(3, appProperty.getPropertyValue());
            statement.execute();
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось записать данные", e);
        }
    }

    @Override
    public void update(Long id, AppProperty appProperty)
    {
        String sql = sqlHelper.readSqlFromResources("sql/properties/update_property.sql");

        try (
                Connection connection = connectionCreator.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, appProperty.getPropertyKey());
            statement.setString(2, appProperty.getPropertyValue());
            statement.setLong(3, id);
            statement.execute();
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось обновить данные", e);
        }
    }

    @Override
    public void delete(Long id)
    {
        String sql = sqlHelper.readSqlFromResources("sql/properties/delete_property.sql");

        try (
                Connection connection = connectionCreator.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setLong(1, id);
            statement.execute();
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Не удалось удалить данные", e);
        }
    }

    private AppProperty getAppPropertyFromResultSet(ResultSet resultSet) throws SQLException
    {
        return AppProperty.builder()
                .id(resultSet.getLong(ID_COLUMN))
                .propertyKey(resultSet.getString(PROPERTY_KEY_COLUMN))
                .propertyValue(resultSet.getString(PROPERTY_VALUE_COLUMN))
                .build();
    }
}
