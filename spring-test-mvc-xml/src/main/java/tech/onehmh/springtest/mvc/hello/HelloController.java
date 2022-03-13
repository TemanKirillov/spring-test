package tech.onehmh.springtest.mvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для вывода приветствия
 *
 * @author Kirillov-AS
 * @since 08.03.2022
 */
@Controller
public class HelloController
{

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
