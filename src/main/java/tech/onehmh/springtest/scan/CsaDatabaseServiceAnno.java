package tech.onehmh.springtest.scan;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.common.DatabaseName;
import tech.onehmh.springtest.common.DatabaseService;

@Component("databaseCsaAnno")
public class CsaDatabaseServiceAnno implements DatabaseService, InitializingBean, DisposableBean
{
    private final DatabaseName name;
    private String userInfoTableName;

    @Autowired
    public CsaDatabaseServiceAnno(@Qualifier("csaName") DatabaseName name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name.asString();
    }

    @Override
    public String getUserInfoById(Long id)
    {
        return String.format("UserInfo(id=%d) from %s (%s)", id, getUserInfoTableName(), getName());
    }

    public String getUserInfoTableName()
    {
        return userInfoTableName;
    }

    @Value("${csa.database.user.info.table.name}")
    public void setUserInfoTableName(String userInfoTableName)
    {
        this.userInfoTableName = userInfoTableName;
    }


    @Override // destroy-method почему-то не работает
    public void destroy() throws Exception
    {
        close();
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        init();
    }

    private void init()
    {
        System.out.println("Инициализирую подключение к БД");
    }

    private void close()
    {
        System.out.println("Закрываю соединения с БД");
    }

}