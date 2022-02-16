package tech.onehmh.springtest.anno;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Фабрика для создания Guid
 */
@Component("guidFactory")
public class GuidFactoryAnno implements FactoryBean<UserInfoGuidAnno>
{
    @Override
    public UserInfoGuidAnno getObject() throws Exception
    {
        return new UserInfoGuidAnno(RandomStringUtils.randomAlphanumeric(10));
    }

    @Override
    public Class<UserInfoGuidAnno> getObjectType()
    {
        return UserInfoGuidAnno.class;
    }

    @Override
    public boolean isSingleton()
    {
        return false;
    }
}
