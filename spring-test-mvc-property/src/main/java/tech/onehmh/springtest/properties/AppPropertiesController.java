package tech.onehmh.springtest.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("appProperty", dao.getById(id).orElse(null));
        return "appProperties/showAppProperty";
    }
}
