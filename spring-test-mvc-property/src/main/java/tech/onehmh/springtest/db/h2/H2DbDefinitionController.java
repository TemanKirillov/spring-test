package tech.onehmh.springtest.db.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.onehmh.springtest.db.DbDefinition;
import tech.onehmh.springtest.db.TableDefinition;
import tech.onehmh.springtest.properties.AppProperty;

/**
 * Контроллер для выполнения DDL операции для БД H2
 *
 * @author Kirillov-AS
 * @since 22.05.2022
 */
@Controller
@RequestMapping("/h2")
public class H2DbDefinitionController
{
    private static final String HAS_ERROR_ATTR = "hasError";
    private static final String MESSAGE_ATTR = "message";
    private static final String ERROR_ATTR = "error";
    private static final String SHOW_MESSAGE_VIEW_NAME = "showMessage";

    DbDefinition definitionDbObject;
    TableDefinition<AppProperty> appPropertyTableDefinition;

    @Autowired
    public H2DbDefinitionController(
            @Qualifier("h2JdbcTemplateDbDefinition")
            DbDefinition definitionDbObject,
            @Qualifier("appPropertyJdbcTemplateTableDefinition")
            TableDefinition<AppProperty> appPropertyTableDefinition
    )
    {
        this.definitionDbObject = definitionDbObject;
        this.appPropertyTableDefinition = appPropertyTableDefinition;
    }

    @GetMapping("/createDb")
    public String createDb(Model model)
    {
        try
        {
            definitionDbObject.createDb();
            model.addAttribute(HAS_ERROR_ATTR, false);
            model.addAttribute(MESSAGE_ATTR, "База успешно создана");
        } catch (Exception e)
        {
            model.addAttribute(HAS_ERROR_ATTR, true);
            model.addAttribute(ERROR_ATTR, e);
        }
        return SHOW_MESSAGE_VIEW_NAME;
    }

    @GetMapping("/deleteDb")
    public String deleteDb(Model model)
    {
        try
        {
            definitionDbObject.deleteDb();
            model.addAttribute(HAS_ERROR_ATTR, false);
            model.addAttribute(MESSAGE_ATTR, "База успешно удалена");
        } catch (Exception e)
        {
            model.addAttribute(HAS_ERROR_ATTR, true);
            model.addAttribute(ERROR_ATTR, e);
        }
        return SHOW_MESSAGE_VIEW_NAME;
    }

    @GetMapping("/fillDb")
    public String fillDb(Model model)
    {
        try
        {
            appPropertyTableDefinition.createTable();
            model.addAttribute(HAS_ERROR_ATTR, false);
            model.addAttribute(MESSAGE_ATTR, "База успешно заполнена");
        } catch (Exception e)
        {
            model.addAttribute(HAS_ERROR_ATTR, true);
            model.addAttribute(ERROR_ATTR, e);
        }
        return SHOW_MESSAGE_VIEW_NAME;
    }
}
