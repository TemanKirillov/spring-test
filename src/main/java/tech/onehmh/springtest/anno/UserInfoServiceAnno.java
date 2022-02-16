package tech.onehmh.springtest.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.common.DatabaseService;

@Component("userInfoService")
public class UserInfoServiceAnno
{
    private DatabaseService databaseService;

    public String getUserInfo(Long id)
    {
        return databaseService.getUserInfoById(id);
    }

    @Autowired
    public void setDatabaseService(@Qualifier("databaseDefaultAnno") DatabaseService databaseService)
    {
        this.databaseService = databaseService;
    }
}
