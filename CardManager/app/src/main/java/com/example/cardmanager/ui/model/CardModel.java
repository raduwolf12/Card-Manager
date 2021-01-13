package com.example.cardmanager.ui.model;

public class CardModel {
    private String nume;
    private String numarCard;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public void setNumarCard(String numarCard) {
        this.numarCard = numarCard;
    }

    public CardModel()
    {

    }
    public CardModel(String nume) {
        this.nume = nume;
    }
}
