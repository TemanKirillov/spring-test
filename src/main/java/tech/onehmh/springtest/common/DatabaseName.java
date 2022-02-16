package tech.onehmh.springtest.common;

public class DatabaseName
{
    private final String name;

    public DatabaseName(String name)
    {
        this.name = name;
    }

    public String asString()
    {
        return name;
    }
}
