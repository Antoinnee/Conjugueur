package com.jvclasses.serveur;

public class RenvoieGroupe
{
    public conjPremierGroup verbePrGroupeCer;

    public RenvoieGroupe(VerbeEcrit verbeEcrit)
    {
        verbePrGroupeCer = new conjPremierGroup_cer(verbeEcrit);
        conjPremierGroup_ger verbePrGroupeGer = new conjPremierGroup_ger(verbeEcrit);
        conjTroisiemeGroup_ettre verbeTrGroupeEttre = new conjTroisiemeGroup_ettre(verbeEcrit);
        conjTroisiemeGroup_aitre verbeTrGroupeAitre = new conjTroisiemeGroup_aitre(verbeEcrit);
        conjTroisiemeGroup_indre verbeTrGroupeIndre = new conjTroisiemeGroup_indre(verbeEcrit);
        conjTroisiemeGroup_oudre verbeTrGroupeOudre = new conjTroisiemeGroup_oudre(verbeEcrit);
        conjPremierGroup verbePrGroupe = new conjPremierGroup(verbeEcrit);
        conjDeuxiemeGroup verbeDxGroupe = new conjDeuxiemeGroup(verbeEcrit);

        verbePrGroupeCer.setNextGroupe(verbePrGroupeGer);
        verbePrGroupeGer.setNextGroupe(verbeTrGroupeEttre);
        verbeTrGroupeEttre.setNextGroupe(verbeTrGroupeAitre);
        verbeTrGroupeAitre.setNextGroupe(verbeTrGroupeIndre);
        verbeTrGroupeIndre.setNextGroupe(verbeTrGroupeOudre);
        verbeTrGroupeOudre.setNextGroupe(verbePrGroupe);
        verbePrGroupe.setNextGroupe(verbeDxGroupe);
    }
}

