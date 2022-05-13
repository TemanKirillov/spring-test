package tech.onehmh.springtest.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private final AppPropertyDAO dao;

    @Autowired
    public AppPropertiesController(AppPropertyDAO dao)
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
            @ModelAttribute(APP_PROPERTY_ATTRIBUTE_NAME) AppProperty appProperty,
            @PathVariable("id") Long id
    )
    {
        dao.updateAppProperty(id, appProperty);
        return "redirect:/appProperties";
    }

    @PostMapping()
    public String createNewAppProperty(@ModelAttribute(APP_PROPERTY_ATTRIBUTE_NAME) AppProperty appProperty)
    {
        dao.addAppProperty(appProperty);
        return "redirect:/appProperties";
    }
}
