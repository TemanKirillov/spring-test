package tech.onehmh.springtest.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.db.h2.AppPropertyTableManipulation;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с {@link AppProperty},
 *    которые хранятся в БД H2
 *
 * @author Kirillov-AS
 * @since 24.05.2022
 */
@Component
public class AppPropertyH2DbDAO implements AppPropertyDAO
{
    private final AppPropertyTableManipulation table;

    @Autowired
    public AppPropertyH2DbDAO(AppPropertyTableManipulation table)
    {
        this.table = table;
    }

    @Override
    public List<AppProperty> getAllAppProperties()
    {
        return table.getAll();
    }

    @Override
    public Optional<AppProperty> getById(Long id)
    {
        return table.getById(id);
    }

    @Override
    public void addAppProperty(AppProperty appProperty)
    {
        table.add(appProperty);
    }

    @Override
    public void updateAppProperty(Long id, AppProperty appProperty)
    {
        table.update(id, appProperty);
    }

    @Override
    public void deleteAppProperty(Long id)
    {
        table.delete(id);
    }
}
