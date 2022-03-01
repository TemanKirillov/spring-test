package tech.onehmh.springtest.scan;

/**
 * Уникальный id для UserInfo
 *
 * Не могу объявить его как @Component("userInfoGuid"), так как
 *     бины создаются фабрикой {@link GuidFactoryAnno}
 */
public class UserInfoGuidAnno
{
    private final String guid;

    public UserInfoGuidAnno(String guid)
    {
        this.guid = guid;
    }

    public String asString()
    {
        return guid;
    }
}
