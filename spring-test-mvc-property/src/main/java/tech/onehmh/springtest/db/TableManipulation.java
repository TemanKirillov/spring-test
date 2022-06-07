package tech.onehmh.springtest.db;

import java.util.List;
import java.util.Optional;

/**
 * Операции для DML операций над сущностью таблицы
 *
 * @param <T> тип сущности, которая хранится в таблице
 * @param <K> тип ключа первичного ключа
 *
 * @author Kirillov-AS
 * @since 31.05.2022
 */
public interface TableManipulation<T, K>
{
    /**
     * Получить все результаты
     */
    List<T> getAll();

    /**
     * Получить настройку по идентификатору
     *
     * @param id идентификатор
     */
    Optional<T> getById(K id);

    /**
     * Добавить сущность
     *
     * @param entity сущность
     */
    void add(T entity);

    /**
     * Обновить сущность по ее id
     *
     * @param id id
     * @param entity данные для обновления сущности
     */
    void update(K id, T entity);

    /**
     * Удалить сущность по идентификатору
     *
     * @param id идентификатор
     */
    void delete(K id);
}
