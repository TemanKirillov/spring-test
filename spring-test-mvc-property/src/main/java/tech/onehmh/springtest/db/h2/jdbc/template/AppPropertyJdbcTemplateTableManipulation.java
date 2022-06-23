package tech.onehmh.springtest.db.h2.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.TableManipulation;
import tech.onehmh.springtest.db.h2.H2AppPropertySQL;
import tech.onehmh.springtest.properties.AppProperty;

import java.util.List;
import java.util.Optional;

/**
 * DML операции для таблицы хранения {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 24.05.2022
 */
@Component
public class AppPropertyJdbcTemplateTableManipulation implements TableManipulation<AppProperty, Long>
{
    private final JdbcTemplate jdbcTemplate;
    private final AppPropertyRowMapper rowMapper;

    @Autowired
    public AppPropertyJdbcTemplateTableManipulation(JdbcTemplate jdbcTemplate, AppPropertyRowMapper rowMapper)
    {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<AppProperty> getAll()
    {
        try
        {
            String sql = H2AppPropertySQL.SELECT_ALL_PROPERTIES.getSqlAsString();
            return jdbcTemplate.query(sql, rowMapper);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Не удалось извлечь данные", e);
        }
    }

    @Override
    public Optional<AppProperty> getById(Long id)
    {
        String sql = H2AppPropertySQL.SELECT_PROPERTY_BY_ID.getSqlAsString();

        try
        {
            AppProperty result = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return Optional.ofNullable(result);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Не удалось извлечь данные", e);
        }
    }

    @Override
    public void add(AppProperty appProperty)
    {
        try
        {
            jdbcTemplate.update(
                    H2AppPropertySQL.INSERT_PROPERTY.getSqlAsString(),
                    appProperty.getId(),
                    appProperty.getPropertyKey(),
                    appProperty.getPropertyValue());
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Не удалось записать данные", e);
        }
    }

    @Override
    public void update(Long id, AppProperty appProperty)
    {
        try
        {
            jdbcTemplate.update(
                    H2AppPropertySQL.UPDATE_PROPERTY.getSqlAsString(),
                    appProperty.getPropertyKey(),
                    appProperty.getPropertyValue(),
                    id);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Не удалось обновить данные", e);
        }
    }

    @Override
    public void delete(Long id)
    {
        try
        {
            jdbcTemplate.update(
                    H2AppPropertySQL.DELETE_PROPERTY.getSqlAsString(),
                    id
            );
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Не удалось удалить данные", e);
        }
    }
}
