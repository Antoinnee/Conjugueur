package com.jvclasses.serveur;

public class  conjPremierGroup extends Verbe
{
    private Verbe verbe;

    protected conjPremierGroup(VerbeEcrit verbeEcrit)
    {
        try
        {
            this.infinitif = verbeEcrit.getVerbeEcrit();
            String newRadical = this.infinitif.substring(0, this.infinitif.length() - 2);
            this.radical = newRadical;

            String[] voyelles = {"a", "e", "i", "o", "u"};

            char firstCharacter = this.infinitif.charAt(0);
            if(contains(voyelles, String.valueOf(firstCharacter)))
            {
                this.pronomPremierePersonne = "J' ";

            }
            else
            {
                this.pronomPremierePersonne = "Je ";
            }
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

        if(verbeEcrit.getVerbeEcrit().endsWith("er"))
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
    public String premierePersonneSing()
    {
        return this.pronomPremierePersonne + this.radical + "e";
    }

    @Override
    public String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "es";
    }

    @Override
    public String troisiemePersonneSing()
    {
        return "Il " + this.radical + "e";
    }

    @Override
    public String premierePersonnePlur()
    {
        return "Nous " + this.radical + "ons";
    }

    @Override
    public String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "ez";
    }

    @Override
    public String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "ent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "erai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "eras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "era";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "erons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "erez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "eront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "é";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "é";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "é";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "é";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "é";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "é";
    }
}
