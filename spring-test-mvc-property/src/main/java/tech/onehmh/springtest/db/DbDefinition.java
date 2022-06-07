package tech.onehmh.springtest.db;

/**
 * Методы для создания/удаления БД
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
public interface DbDefinition
{
    /**
     * Создать пустую БД
     */
    void createDb();

    /**
     * Удалить БД
     */
    void deleteDb();
}
