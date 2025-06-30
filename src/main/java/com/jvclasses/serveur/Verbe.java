package com.jvclasses.serveur;

import java.util.Arrays;

public abstract class Verbe
{
    public String radical;
    public String infinitif;
    public String pronomPremierePersonne;

    abstract void setNextGroupe(Verbe nextVerbe);

    abstract String Terminaison(VerbeEcrit verbeEcrit);

    // PRESENT
    abstract String premierePersonneSing();

    abstract String deuxiemePersonneSing();

    abstract String troisiemePersonneSing();

    abstract String premierePersonnePlur();

    abstract String deuxiemePersonnePlur();

    abstract String troisiemePersonnePlur();

    // FUTUR
    abstract String premierePersonneSingFutur();

    abstract String deuxiemePersonneSingFutur();

    abstract String troisiemePersonneSingFutur();

    abstract String premierePersonnePlurFutur();

    abstract String deuxiemePersonnePlurFutur();

    abstract String troisiemePersonnePlurFutur();

    // PASSÉ COMPOSÉ
    abstract String premierePersonneSingPasse();

    abstract String deuxiemePersonneSingPasse();

    abstract String troisiemePersonneSingPasse();

    abstract String premierePersonnePlurPasse();

    abstract String deuxiemePersonnePlurPasse();

    abstract String troisiemePersonnePlurPasse();

    static public boolean contains(String[] T, String val)
    {
        return Arrays.toString(T).contains(val);
    }

    String conjuguePresent()
    {
        String verbeConjugue = "\n";
        verbeConjugue += this.premierePersonneSing() + "\n";
        verbeConjugue += this.deuxiemePersonneSing() + "\n";
        verbeConjugue += this.troisiemePersonneSing() + "\n";
        verbeConjugue += this.premierePersonnePlur() + "\n";
        verbeConjugue += this.deuxiemePersonnePlur() + "\n";
        verbeConjugue += this.troisiemePersonnePlur() + "\n";

        return verbeConjugue;
    }

    String conjugueFutur()
    {
        String verbeConjugue = "\n";
        verbeConjugue += this.premierePersonneSingFutur() + "\n";
        verbeConjugue += this.deuxiemePersonneSingFutur() + "\n";
        verbeConjugue += this.troisiemePersonneSingFutur() + "\n";
        verbeConjugue += this.premierePersonnePlurFutur() + "\n";
        verbeConjugue += this.deuxiemePersonnePlurFutur() + "\n";
        verbeConjugue += this.troisiemePersonnePlurFutur() + "\n";

        return verbeConjugue;
    }

    String conjuguePasse()
    {
        String verbeConjugue = "\n";
        verbeConjugue += this.premierePersonneSingPasse() + "\n";
        verbeConjugue += this.deuxiemePersonneSingPasse() + "\n";
        verbeConjugue += this.troisiemePersonneSingPasse() + "\n";
        verbeConjugue += this.premierePersonnePlurPasse() + "\n";
        verbeConjugue += this.deuxiemePersonnePlurPasse() + "\n";
        verbeConjugue += this.troisiemePersonnePlurPasse() + "\n";

        return verbeConjugue;
    }
}
