package com.jvclasses.serveur;

public interface Conjuguaison
{
    void setNextTemps(Conjuguaison nextTemps);

    String checkTemps(VerbeEcrit verbeEcrit);
}
