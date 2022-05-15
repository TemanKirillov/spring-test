package tech.onehmh.springtest.properties;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 12.05.2022
 */
public interface AppPropertyDAO
{
    /**
     * @return все настройки
     */
    List<AppProperty> getAllAppProperties();

    /**
     * Вернуть настройку по id, если такая есть
     *
     * @param id идентификатор
     * @return настройка приложения
     */
    Optional<AppProperty> getById(Long id);

    /**
     * Добавить новую настройку
     *
     * @param appProperty добавляемая настройка
     */
    void addAppProperty(AppProperty appProperty);

    /**
     * Обновить настройку с заданным id новыми значениями
     *
     * @param id идентификатор редактируемой настройки
     * @param appProperty новые значения для настройки
     */
    void updateAppProperty(Long id, AppProperty appProperty);

    /**
     * Удалить настройку приложения по её id
     *
     * @param id id удаляемой настройки
     */
    void deleteAppProperty(Long id);
}
