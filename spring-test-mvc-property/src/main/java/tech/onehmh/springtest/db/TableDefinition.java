package tech.onehmh.springtest.db;

/**
 * Операции для DML операций над сущностью таблицы
 *
 * @param <T> тип сущности, которая хранится в таблице
 *
 * @author Kirillov-AS
 * @since 07.06.2022
 */
@SuppressWarnings("squid:S2326") // параметр нужен для большей читаемости, и внедрения по интерфейсу
public interface TableDefinition<T>
{
    /**
     * Создать таблицу
     */
    void createTable();
}
