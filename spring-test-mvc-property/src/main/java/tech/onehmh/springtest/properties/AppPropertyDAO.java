package tech.onehmh.springtest.properties;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с {@link AppProperty}
 *
 * @author Kirillov-AS
 * @since 12.05.2022
 */
@Component
public class AppPropertyDAO
{
    private final List<AppProperty> properties = getDefaultProperties();

    /**
     * @return все настройки
     */
    public List<AppProperty> getAllAppProperties()
    {
        return properties;
    }

    /**
     * Вернуть настройку по id, если такая есть
     *
     * @param id идентификатор
     * @return настройка приложения
     */
    public Optional<AppProperty> getById(Long id)
    {
        return properties.stream()
                .filter(appProperty -> appProperty.getId().equals(id))
                .findFirst();
    }

    /**
     * Добавить новую настройку
     *
     * @param appProperty добавляемая настройка
     */
    public void addAppProperty(AppProperty appProperty)
    {
        properties.add(appProperty);
    }

    /**
     * Обновить настройку с заданным id новыми значениями
     *
     * @param id идентификатор редактируемой настройки
     * @param appProperty новые значения для настройки
     */
    public void updateAppProperty(Long id, AppProperty appProperty)
    {
        Optional<AppProperty> property = getById(id);
        if (property.isPresent())
        {
            AppProperty prop = property.get();
            prop.setPropertyKey(appProperty.getPropertyKey());
            prop.setPropertyValue(appProperty.getPropertyValue());
        }
        else
        {
            throw new IllegalArgumentException("Настройки с id " + id + " не существует");
        }
    }

    private List<AppProperty> getDefaultProperties()
    {
        List<AppProperty> result = new ArrayList<>();

        result.add(AppProperty.builder()
                .id(1L)
                .propertyKey("db.timeout")
                .propertyValue("20")
                .build()
        );

        result.add(AppProperty.builder()
                .id(2L)
                .propertyKey("db.name.default")
                .propertyValue("TDB")
                .build()
        );

        return result;
    }
}
