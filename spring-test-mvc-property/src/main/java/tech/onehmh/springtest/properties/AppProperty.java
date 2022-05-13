package tech.onehmh.springtest.properties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Настройка приложения
 *
 * @author Kirillov-AS
 * @since 11.05.2022
 */
@Getter
@Setter
@Builder
public class AppProperty
{
    /**
     * Идентификатор
     */
    private Long id;

    /**
     * Ключ настройки
     */
    private String propertyKey;

    /**
     * Значение настройки
     */
    private String propertyValue;
}
