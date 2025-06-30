package com.jvclasses.serveur;

public class conjDeuxiemeGroup extends Verbe
{
    private Verbe verbe;
    private Conjuguaison verbeFutur;

    protected conjDeuxiemeGroup(VerbeEcrit verbeEcrit)
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
        try
        {
            String reponse = "";
            String temps = "";

            if(verbeEcrit.getVerbeEcrit().endsWith("ir"))
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
        catch(NullPointerException e)
        {
            return "Verbe introuvable";
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
        return this.pronomPremierePersonne + this.radical + "is";
    }

    @Override
    String deuxiemePersonneSing()
    {
        return "Tu " + this.radical + "is";
    }

    @Override
    String troisiemePersonneSing()
    {
        return "Il " + this.radical + "i";
    }

    @Override
    String premierePersonnePlur()
    {
        return "Nous " + this.radical + "issons";
    }

    @Override
    String deuxiemePersonnePlur()
    {
        return "Vous " + this.radical + "issez";
    }

    @Override
    String troisiemePersonnePlur()
    {
        return "Ils " + this.radical + "issent";
    }

    @Override
    String premierePersonneSingFutur()
    {
        return this.pronomPremierePersonne + this.radical + "irai";
    }

    @Override
    String deuxiemePersonneSingFutur()
    {
        return "Tu " + this.radical + "iras";
    }

    @Override
    String troisiemePersonneSingFutur()
    {
        return "Il " + this.radical + "ira";
    }

    @Override
    String premierePersonnePlurFutur()
    {
        return "Nous " + this.radical + "irons";
    }

    @Override
    String deuxiemePersonnePlurFutur()
    {
        return "Vous " + this.radical + "irez";
    }

    @Override
    String troisiemePersonnePlurFutur()
    {
        return "Ils " + this.radical + "iront";
    }

    @Override
    String premierePersonneSingPasse()
    {
        return "J'ai " + this.radical + "i";
    }

    @Override
    String deuxiemePersonneSingPasse()
    {
        return "Tu as " + this.radical + "i";
    }

    @Override
    String troisiemePersonneSingPasse()
    {
        return "Il a " + this.radical + "i";
    }

    @Override
    String premierePersonnePlurPasse()
    {
        return "Nous avons " + this.radical + "i";
    }

    @Override
    String deuxiemePersonnePlurPasse()
    {
        return "Vous avez " + this.radical + "i";
    }

    @Override
    String troisiemePersonnePlurPasse()
    {
        return "Ils ont " + this.radical + "i";
    }
}
