package tech.onehmh.springtest.properties;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с {@link AppProperty}
 *     с помощью List
 *
 * @author Kirillov-AS
 * @since 12.05.2022
 */
@Component
public class AppPropertyListDAO implements AppPropertyDAO
{
    private final List<AppProperty> properties = getDefaultProperties();

    @Override
    public List<AppProperty> getAllAppProperties()
    {
        return properties;
    }

    @Override
    public Optional<AppProperty> getById(Long id)
    {
        return properties.stream()
                .filter(appProperty -> appProperty.getId().equals(id))
                .findFirst();
    }

    @Override
    public void addAppProperty(AppProperty appProperty)
    {
        properties.add(appProperty);
    }

    @Override
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

    @Override
    public void deleteAppProperty(Long id)
    {
        properties.removeIf(appProperty -> appProperty.getId().equals(id));
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
