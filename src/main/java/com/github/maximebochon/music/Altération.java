package com.github.maximebochon.music;

public enum Altération
{
    DOUBLE_BÉMOL("\uD834\uDD2B"),
    BÉMOL("♭"),
    NATUREL(""),
    DIÈSE("♯"),
    DOUBLE_DIÈSE("𝄪");

    private String symbole;

    Altération(final String symbole)
    {
        this.symbole = symbole;
    }

    public String getSymbole()
    {
        return this.symbole;
    }

    public int getDemiTons()
    {
        return this.ordinal() - NATUREL.ordinal();
    }

    public static Altération byDemiTons(final int demiTons)
    {
        return Altération.values()[demiTons + NATUREL.ordinal()];
    }
}
