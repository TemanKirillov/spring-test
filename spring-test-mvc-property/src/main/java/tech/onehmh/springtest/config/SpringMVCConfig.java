package tech.onehmh.springtest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * Конфиг Spring MVC
 *
 * @author Kirillov-AS
 * @since 09.03.2022
 */
@Configuration
@ComponentScan("tech.onehmh.springtest")
@EnableWebMvc
@PropertySource("classpath:database.properties")
public class SpringMVCConfig implements WebMvcConfigurer
{
    private final ApplicationContext applicationContext;

    private String h2DataSourceUrl;
    private String h2DataSourceUsername;
    private String h2DataSourcePassword;

    @Autowired
    public SpringMVCConfig(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver()
    {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(resolver);
    }

    @Bean
    public DriverManagerDataSource h2DataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(org.h2.Driver.class.getName());
        dataSource.setUrl(h2DataSourceUrl);
        dataSource.setUsername(h2DataSourceUsername);
        dataSource.setPassword(h2DataSourcePassword);

        return dataSource;
    }

    @Autowired
    public void setH2DataSourceProperties(
            @Value("${h2.datasource.url}") String h2DataSourceUrl,
            @Value("${h2.datasource.username}") String h2DataSourceUsername,
            @Value("${h2.datasource.password}") String h2DataSourcePassword
    )
    {
        this.h2DataSourceUrl = h2DataSourceUrl;
        this.h2DataSourceUsername = h2DataSourceUsername;
        this.h2DataSourcePassword = h2DataSourcePassword;
    }

    @Bean
    public JdbcTemplate h2JdbcTemplate()
    {
        return new JdbcTemplate(h2DataSource());
    }

}
