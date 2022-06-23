package tech.onehmh.springtest.db.h2.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.TableDefinition;
import tech.onehmh.springtest.db.h2.H2AppPropertySQL;
import tech.onehmh.springtest.properties.AppProperty;

/**
 * DDL операции для таблицы хранения {@link AppProperty}
 *     с использованием {@link JdbcTemplate}
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
@Component
public class AppPropertyJdbcTemplateTableDefinition implements TableDefinition<AppProperty>
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppPropertyJdbcTemplateTableDefinition(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTable()
    {
        jdbcTemplate.update(H2AppPropertySQL.CREATE_PROPERTIES.getSqlAsString());
    }
}
