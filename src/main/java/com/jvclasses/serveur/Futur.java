package com.jvclasses.serveur;

public class Futur implements Conjuguaison {

    private Conjuguaison verbe;

    @Override
    public void setNextTemps(Conjuguaison nextTemps)
    {
        this.verbe = nextTemps;
    }

    @Override
    public String checkTemps(VerbeEcrit verbeEcrit)
    {
        if(verbeEcrit.getTempsEcrit().equals("futur"))
        {
            return "futur";
        }
        else
        {
            return verbe.checkTemps(verbeEcrit);
        }
    }
}
