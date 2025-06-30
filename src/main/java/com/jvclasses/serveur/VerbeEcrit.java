package com.jvclasses.serveur;

public class VerbeEcrit
{
    private String verbeEcrit;
    private String tempsEcrit;

    public VerbeEcrit(String verbeEcrit, String tempsEcrit)
    {
        this.verbeEcrit = verbeEcrit;
        this.tempsEcrit = tempsEcrit;
    }

    public String getVerbeEcrit()
    {
        return verbeEcrit;
    }

    public String getTempsEcrit()
    {
        return tempsEcrit;
    }
}
