package tech.onehmh.springtest;

public class DatabaseService
{
    private String name;

    public DatabaseService(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
