package com.RAINBOY.RainWeb.model;

public class Alien
{

    private final int ID;
    private final String NAME;

    public Alien(int ID,String NAME)
    {
        //Constructor or Setter-field injection is fine
        this.NAME=NAME;
        this.ID=ID;
    }

    //Corresp view file would need to use${"*Model class*.*fieldName*"} e.g)${Alien.NAME}

    @Override
    public String toString()
    {
        return "{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
