package tech.onehmh.springtest.db;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Хелпер для работы с SQL
 *
 * @author Kirillov-AS
 * @since 31.05.2022
 */
@Component
public class SQLHelper
{
    private static final String FILE_NAME_INCORRECT_TEXT = "fileName is incorrect";

    /**
     * Прочитать выражение SQL из файла
     *
     * @param fileName имя файла
     * @return строка с SQL
     */
    public String readSqlFromResources(String fileName)
    {
        if (fileName == null)
        {
            throw new IllegalArgumentException(FILE_NAME_INCORRECT_TEXT);
        }

        URL url = getClass().getClassLoader().getResource(fileName);

        if (url == null)
        {
            throw new IllegalArgumentException(FILE_NAME_INCORRECT_TEXT);
        }

        try
        {
            Path path = Paths.get(url.toURI());
            return Files.readString(path);
        }
        catch (URISyntaxException | IOException e)
        {
            throw new IllegalArgumentException(FILE_NAME_INCORRECT_TEXT);
        }
    }
}
