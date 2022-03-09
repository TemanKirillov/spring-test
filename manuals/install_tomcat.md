# Установка TomCat на Mac

1. Скачать дистрибутив с https://tomcat.apache.org/. Для запуска Spring лучше версия 9. 
   В 10 может не запуститься из-за перехода на jakarta.
1. Распаковать. Например в work/java
1. Настроить в идее через Run -> Edit Configuration -> Tomcat Server -> Local Server
1. Application Server -> Configure...
1. Указать адрес и порт развертывания
1. Нажать Fix для выбора артефакта для развертывания
1. В Deployment -> Application Context задать читаемый URL для приложения
1. Дать права на исполнение командой chmod +x <директория TomCat>/bin/catalina.sh
1. Сервер настроен, нужно перезапустить идею (иногда нужно, но необязательно)