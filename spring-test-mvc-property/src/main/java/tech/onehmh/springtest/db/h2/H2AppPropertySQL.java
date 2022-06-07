package tech.onehmh.springtest.db.h2;

import lombok.Getter;
import tech.onehmh.springtest.db.SQLHelper;
import tech.onehmh.springtest.properties.AppProperty;

/**
 * Коллекция запросов SQL для работы с {@link AppProperty} с H2 диалектом
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
@Getter
public enum H2AppPropertySQL
{
    CREATE_PROPERTIES("sql/properties/create_properties.sql"),
    SELECT_ALL_PROPERTIES("sql/properties/select_all_properties.sql"),
    SELECT_PROPERTY_BY_ID("sql/properties/select_property_by_id.sql"),
    INSERT_PROPERTY("sql/properties/insert_property.sql"),
    UPDATE_PROPERTY("sql/properties/update_property.sql"),
    DELETE_PROPERTY("sql/properties/delete_property.sql"),
    ;

    private final String sqlAsString;
    private final String pathToSqlFile;

    H2AppPropertySQL(String pathToSqlFile)
    {
        this.pathToSqlFile = pathToSqlFile;
        this.sqlAsString = InternalStaticFields.SQL_HELPER.readSqlFromResources(pathToSqlFile);
    }

    private static class InternalStaticFields
    {
        public static final SQLHelper SQL_HELPER = new SQLHelper();
    }
}
