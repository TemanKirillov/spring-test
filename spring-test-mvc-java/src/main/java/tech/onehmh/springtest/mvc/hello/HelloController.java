package tech.onehmh.springtest.mvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Контроллер для вывода приветствия
 *
 * @author Kirillov-AS
 * @since 08.03.2022
 */
@Controller
@RequestMapping("/hello")
public class HelloController
{

    @GetMapping("/java")
    public String helloJava()
    {
        return "hello/java";
    }

    @GetMapping("/world")
    public String helloWorld()
    {
        return "hello/world";
    }

    @GetMapping
    public String hello(Model model)
    {
        model.addAttribute("firstName", "Артем");
        model.addAttribute("lastName", "Кириллов");
        return "hello/helloName";
    }

    @GetMapping("/name")
    public String helloForName(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            Model model
    )
    {
        model.addAttribute("firstName", Optional.ofNullable(firstName).orElse("Неизвестно"));
        model.addAttribute("lastName", Optional.ofNullable(lastName).orElse("Неизвестно"));
        return "hello/helloName";
    }
}