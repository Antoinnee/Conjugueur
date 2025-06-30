package com.jvclasses.serveur;

public class conjTroisiemeGroup_indre extends conjTroisiemeGroup
{
    private Verbe verbe;

    protected conjTroisiemeGroup_indre(VerbeEcrit verbeEcrit)
    {
        super(verbeEcrit);

        try
        {
            String newRadical = this.infinitif.substring(0, this.infinitif.length() - 4);
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

        if(verbeEcrit.getVerbeEcrit().endsWith("indre"))
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
        return this.pronomPremierePersonne + this.radical + "ns";
    }

    @Override
    String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "ns";
    }

    @Override
    String troisiemePersonneSing()
    {
        return "Il " + this.radical + "nt";
    }

    @Override
    String premierePersonnePlur()
    {
        return "Nous " + this.radical + "gnons";
    }

    @Override
    String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "gnez";
    }

    @Override
    String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "gnent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "ndrai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "ndras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "ndra";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "ndrons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "ndrez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "ndront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "nt";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "nt";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "nt";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "nt";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "nt";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "nt";
    }
}
