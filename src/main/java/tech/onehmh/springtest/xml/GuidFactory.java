package tech.onehmh.springtest.xml;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Фабрика для создания Guid
 */
public class GuidFactory
{
    /**
     * @return новый guid для UserInfo
     */
    public UserInfoGuid newUserInfoGuid()
    {
        return new UserInfoGuid(RandomStringUtils.randomAlphanumeric(10));
    }
}
