package tech.onehmh.springtest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Замена web.xml для разворачивания Spring MVC приложения
 *
 * @author Kirillov-AS
 * @since 09.03.2022
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[] {
                SpringMVCConfig.class
        };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] {
                "/"
        };
    }
}
