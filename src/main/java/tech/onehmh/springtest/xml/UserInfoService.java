package tech.onehmh.springtest.xml;

import tech.onehmh.springtest.common.DatabaseService;

public class UserInfoService
{
    private DatabaseService databaseService;

    public String getUserInfo(Long id)
    {
        return databaseService.getUserInfoById(id);
    }

    public void setDatabaseService(DatabaseService databaseService)
    {
        this.databaseService = databaseService;
    }
}
