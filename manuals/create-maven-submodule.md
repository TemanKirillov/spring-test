# Создание Spring MVC модуля в проекте

1. File -> Module... -> Maven 
1. Использовать архетип org.apache.maven.archetypes:maven-archetype-webapp
1. Идея сама пропишет новый модуль в родительском pom. Там должно быть:
   <pre><code>
       &lt;modules>
           &lt;module>имя-дочернего-модуля&lt;/module>
       &lt;/modules>
       &lt;packaging>pom&lt;/packaging>
   </code></pre>
1. В pom дочернего модуля должно быть (пример):
   <pre><code>
       &lt;parent>
           &lt;artifactId>spring-test&lt;/artifactId>
           &lt;groupId>tech.onehmh&lt;/groupId>
           &lt;version>1.0-SNAPSHOT&lt;/version>
       &lt;/parent>
    </code></pre>
1. Теперь все зависимости parent-модуля можно использовать в дочернем.
   Теперь можно выбрать новый артефакт при развертывании в Tomcat
   