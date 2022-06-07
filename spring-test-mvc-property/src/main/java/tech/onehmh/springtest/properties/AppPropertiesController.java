package tech.onehmh.springtest.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Контроллер настроек приложения
 *
 * @author Kirillov-AS
 * @since 12.05.2022
 */
@Controller
@RequestMapping("/appProperties")
public class AppPropertiesController
{
    private static final String APP_PROPERTY_ATTRIBUTE_NAME = "appProperty";
    private static final String REDIRECT_TO_APP_PROPERTIES = "redirect:/appProperties";

    private final AppPropertyDAO dao;

    @Autowired
    public AppPropertiesController(@Qualifier("appPropertyDbDAO") AppPropertyDAO dao)
    {
        this.dao = dao;
    }

    @GetMapping()
    public String getAllAppProperties(Model model)
    {
        model.addAttribute("listAppProperties", dao.getAllAppProperties());
        return "appProperties/listAppProperties";
    }

    @GetMapping("/{id}")
    public String getById(
            @PathVariable("id") Long id,
            Model model)
    {
        model.addAttribute(APP_PROPERTY_ATTRIBUTE_NAME, dao.getById(id).orElse(null));
        return "appProperties/showAppProperty";
    }

    @GetMapping("/new")
    public String addNewAppPropertyForm(Model model)
    {
        model.addAttribute(APP_PROPERTY_ATTRIBUTE_NAME, AppProperty.builder().build());
        return "appProperties/newAppPropertyForm";
    }

    @GetMapping("/{id}/edit")
    public String updateAppPropertyForm(
            @PathVariable("id") Long id,
            Model model)
    {
        model.addAttribute(APP_PROPERTY_ATTRIBUTE_NAME, dao.getById(id).orElse(null));
        return "appProperties/updateAppPropertyForm";
    }

    @PatchMapping("/{id}")
    public String updateAppProperty(
            @ModelAttribute(APP_PROPERTY_ATTRIBUTE_NAME) @Valid AppProperty appProperty,
            BindingResult bindingResult,
            @PathVariable("id") Long id
    )
    {
        if (bindingResult.hasErrors())
        {
            return "appProperties/updateAppPropertyForm";
        }
        dao.updateAppProperty(id, appProperty);
        return REDIRECT_TO_APP_PROPERTIES;
    }

    @PostMapping()
    public String createNewAppProperty(
            @ModelAttribute(APP_PROPERTY_ATTRIBUTE_NAME) @Valid AppProperty appProperty,
            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "appProperties/newAppPropertyForm";
        }
        dao.addAppProperty(appProperty);
        return REDIRECT_TO_APP_PROPERTIES;
    }

    @DeleteMapping("/{id}")
    public String deleteAppProperty(@PathVariable("id") Long id)
    {
        dao.deleteAppProperty(id);
        return REDIRECT_TO_APP_PROPERTIES;
    }
}
