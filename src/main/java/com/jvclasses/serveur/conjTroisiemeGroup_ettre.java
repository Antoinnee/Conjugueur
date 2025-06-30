package com.jvclasses.serveur;

public class conjTroisiemeGroup_ettre extends conjTroisiemeGroup
{
    private Verbe verbe;

    protected conjTroisiemeGroup_ettre(VerbeEcrit verbeEcrit)
    {
        super(verbeEcrit);

        try
        {
            String newRadical = this.infinitif.substring(0, this.infinitif.length() - 5);
            this.radical = newRadical;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Veuillez rentrer un verbe et un temps valide");
        }
    }

    @Override
    public String Terminaison(VerbeEcrit verbeEcrit)
    {
        String reponse = "";
        String temps = "";

        if(verbeEcrit.getVerbeEcrit().endsWith("ettre"))
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

    @Override
    String premierePersonneSing()
    {
        return this.pronomPremierePersonne + this.radical + "ets";
    }

    @Override
    String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "ets";
    }

    @Override
    String troisiemePersonneSing()
    {
        return "Il " + this.radical + "et";
    }

    @Override
    String premierePersonnePlur()
    {
        return "Nous " + this.radical + "ettons";
    }

    @Override
    String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "ettez";
    }

    @Override
    String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "ettent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "ettrai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "ettras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "ettra";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "ettrons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "ettrez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "ettront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "is";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "is";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "is";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "is";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "is";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "is";
    }
}

