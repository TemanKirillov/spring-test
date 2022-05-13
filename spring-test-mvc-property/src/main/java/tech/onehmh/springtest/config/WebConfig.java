package tech.onehmh.springtest.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException
    {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext)
    {
        aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null ,true, "/*");
    }
}
