package tech.onehmh.springtest.db.h2.jdbc.template;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.properties.AppProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper для {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
@Component
public class AppPropertyRowMapper implements RowMapper<AppProperty>
{
    private static final String ID_COLUMN = "ID";
    private static final String PROPERTY_KEY_COLUMN = "PROPERTY_KEY";
    private static final String PROPERTY_VALUE_COLUMN = "PROPERTY_VALUE";

    @Override
    public AppProperty mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return AppProperty.builder()
                .id(rs.getLong(ID_COLUMN))
                .propertyKey(rs.getString(PROPERTY_KEY_COLUMN))
                .propertyValue(rs.getString(PROPERTY_VALUE_COLUMN))
                .build();
    }
}
