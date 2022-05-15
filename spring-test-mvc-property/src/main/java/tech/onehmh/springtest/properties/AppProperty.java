package tech.onehmh.springtest.properties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @Min(value = 0, message = "Property id should be higher 0")
    private Long id;

    /**
     * Ключ настройки
     */
    @NotEmpty(message = "Property key should not be empty")
    @Size(min = 2, max = 512, message = "Property key should between 2 and 512 characters")
    private String propertyKey;

    /**
     * Значение настройки
     */
    @NotEmpty(message = "Property value should not be empty")
    @Size(min = 1, max = 512, message = "Property value should between 1 and 512 characters")
    private String propertyValue;
}
