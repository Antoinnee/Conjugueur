package com.jvclasses.serveur;

public class conjTroisiemeGroup_aitre extends conjTroisiemeGroup
{
    private Verbe verbe;
    protected conjTroisiemeGroup_aitre(VerbeEcrit verbeEcrit)
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

        if(verbeEcrit.getVerbeEcrit().endsWith("aitre"))
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
        return this.pronomPremierePersonne + this.radical + "ais";
    }

    @Override
    String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "ais";
    }

    @Override
    String troisiemePersonneSing()
    {
        return "Il " + this.radical + "ait";
    }

    @Override
    String premierePersonnePlur()
    {
        return "Nous " + this.radical + "aissons";
    }

    @Override
    String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "aissez";
    }

    @Override
    String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "aissent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "aitrai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "aitras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "aitra";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "aitrons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "aitrez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "aitront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "u";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "u";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "u";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "u";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "u";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "u";
    }
}
