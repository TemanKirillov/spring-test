# Создание Spring MVC приложения на базе Maven

1. Создать новый проект maven командой ??? из архетипа ??? . Или использовать имеющийся проект.
1. в pom.xml добавить зависимости:
    - spring-core
    - spring-context
    - spring-web
    - spring-webmvc
    - thymeleaf-spring5
1. Если новые зависимости в pom.xml Intellij Idea подсвечивает красным, то возможно понадобится:
   - перезагрузить зависимости mvn dependency:purge-local-repository
   - перезагрузить Idea (File - Invalidate Caches / Restart - Just Restart)
1. Создать src/main/webapp/WEB-INF/web.xml
   - прописать там DispatcherServlet
   - прописать там маппинг этого сервлета
   - прописать там путь до конфига Spring applicationContextMVC.xml
   - Пример: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson15.SpringMVCApp1/src/main/webapp/WEB-INF/web.xml
1. Создать конфиг для Spring src/main/webapp/WEB-INF/applicationContextMVC.xml
   - прописать пакет, где искать бины
   - прописать <mvc:annotation-driven/> для маппинга бинов контроллеров
   - прописать бины для шаблонизатора thymeleaf
   - указать там префикс и суффикс для представлений (views)
   - Пример: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson15.SpringMVCApp1/src/main/webapp/WEB-INF/applicationContextMVC.xml
1. Создать представление. Например, src/main/webapp/WEB-INF/views/hello.html
1. Создать контроллер (@Controller) в пакет, где ищутся бины. Возвращать представление.
1. Может возникать проблема с Tomcat 10 (404). Попробовать запустить на Tomcat 9