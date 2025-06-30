package com.jvclasses.serveur;

public class conjTroisiemeGroup_oudre extends conjTroisiemeGroup
{
    private Verbe verbe;

    protected conjTroisiemeGroup_oudre(VerbeEcrit verbeEcrit)
    {
        super(verbeEcrit);

        try
        {
            String newRadical = this.infinitif.substring(0, this.infinitif.length() - 3);
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

        if(verbeEcrit.getVerbeEcrit().endsWith("oudre"))
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
        return this.pronomPremierePersonne + this.radical + "ds";
    }

    @Override
    String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "ds";
    }

    @Override
    String troisiemePersonneSing()
    {
        return "Il " + this.radical + "d";
    }

    @Override
    String premierePersonnePlur()
    {
        return "Nous " + this.radical + "sons";
    }

    @Override
    String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "sez";
    }

    @Override
    String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "sent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "drai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "dras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "dra";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "drons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "drez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "dront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "ds";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "ds";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "ds";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "ds";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "ds";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "ds";
    }
}
