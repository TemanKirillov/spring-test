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
