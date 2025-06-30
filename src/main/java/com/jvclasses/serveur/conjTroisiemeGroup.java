package com.jvclasses.serveur;

public class conjTroisiemeGroup extends Verbe
{
    private Verbe verbe;

    protected conjTroisiemeGroup(VerbeEcrit verbeEcrit)
    {
        try
        {
            this.infinitif = verbeEcrit.getVerbeEcrit();

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
    public void setNextGroupe(Verbe nextVerbe)
    {
        this.verbe = nextVerbe;
    }

    @Override
    String Terminaison(VerbeEcrit verbeEcrit)
    {
        return null;
    }

    @Override
    String premierePersonneSing() {
        return null;
    }

    @Override
    String deuxiemePersonneSing() {
        return null;
    }

    @Override
    String troisiemePersonneSing() {
        return null;
    }

    @Override
    String premierePersonnePlur() {
        return null;
    }

    @Override
    String deuxiemePersonnePlur() {
        return null;
    }

    @Override
    String troisiemePersonnePlur() {
        return null;
    }

    @Override
    String premierePersonneSingFutur() {
        return null;
    }

    @Override
    String deuxiemePersonneSingFutur() {
        return null;
    }

    @Override
    String troisiemePersonneSingFutur() {
        return null;
    }

    @Override
    String premierePersonnePlurFutur() {
        return null;
    }

    @Override
    String deuxiemePersonnePlurFutur() {
        return null;
    }

    @Override
    String troisiemePersonnePlurFutur() {
        return null;
    }

    @Override
    String premierePersonneSingPasse() {
        return null;
    }

    @Override
    String deuxiemePersonneSingPasse() {
        return null;
    }

    @Override
    String troisiemePersonneSingPasse() {
        return null;
    }

    @Override
    String premierePersonnePlurPasse() {
        return null;
    }

    @Override
    String deuxiemePersonnePlurPasse() {
        return null;
    }

    @Override
    String troisiemePersonnePlurPasse() {
        return null;
    }

}
