package com.jvclasses.serveur;

public class conjPremierGroup_ger extends  conjPremierGroup
{
    private Verbe verbe;

    protected conjPremierGroup_ger(VerbeEcrit verbeEcrit)
    {
        super(verbeEcrit);
    }

    @Override
    public String premierePersonnePlur()
    {
        return "Nous " + this.radical + "eons";
    }

    @Override
    public String Terminaison(VerbeEcrit verbeEcrit)
    {
        String reponse = "";
        String temps = "";

        if(verbeEcrit.getVerbeEcrit().endsWith("ger"))
        {
            reponse += "Conjuguaison du verbe " + verbeEcrit.getVerbeEcrit() + " au temps " + verbeEcrit.getTempsEcrit() + " : ";
            RenvoieTemps renvoieTemps = new RenvoieTemps(verbeEcrit);
            temps = renvoieTemps.verbeFutur.checkTemps(verbeEcrit);

            if(temps.equals("présent"))
            {
                reponse += conjuguePresent();
            }
            else if(temps.equals("futur"))
            {
                reponse += conjugueFutur();
            }
            else if(temps.equals("passé composé"))
            {
                reponse += conjuguePasse();
            }
            else
            {
                reponse = "Temps introuvable";
            }

            return reponse;
        }
        else
        {
            return verbe.Terminaison(verbeEcrit);
        }
    }

    @Override
    public void setNextGroupe(Verbe nextVerbe)
    {
        this.verbe = nextVerbe;
    }
}
