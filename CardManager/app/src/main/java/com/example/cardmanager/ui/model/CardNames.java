package com.example.cardmanager.ui.model;

public enum CardNames {
    CATENA("Catena"),
    DONA("Dona"),
    HELP_NET("Help net"),
    ECO("Eco"),
    ING("ING"),
    BCR("BCR"),
    TRANSILVANIA("Transilvania"),
    INTERSPORT("Intersport");
    CardNames(String val)
    {
        this.val = val;
    }
    private String val;

    public String getVal()
    {
        return val;
    }
}
