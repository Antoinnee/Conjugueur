package com.jvclasses.serveur;

public class PasseCompose implements Conjuguaison
{
    private Conjuguaison verbe;

    @Override
    public void setNextTemps(Conjuguaison nextTemps)
    {
        this.verbe = nextTemps;
    }

    @Override
    public String checkTemps(VerbeEcrit verbeEcrit)
    {
        if(verbeEcrit.getTempsEcrit().equals("passé composé"))
        {
            return "passé composé";
        }
        else
        {
            return verbe.checkTemps(verbeEcrit);
        }
    }
}
