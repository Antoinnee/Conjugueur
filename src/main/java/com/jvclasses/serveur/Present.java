package com.jvclasses.serveur;

public class Present implements Conjuguaison
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
        try
        {
            if(verbeEcrit.getTempsEcrit().equals("présent"))
            {
                return "présent";
            }
            else
            {
                return verbe.checkTemps(verbeEcrit);
            }
        }
        catch(NullPointerException e)
        {
            return "Temps introuvable" + "\n" + "Veuillez reessayer" + "\n";
        }
    }
}
