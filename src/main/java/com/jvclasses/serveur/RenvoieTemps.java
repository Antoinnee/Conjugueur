package com.jvclasses.serveur;

public class RenvoieTemps
{
    public Futur verbeFutur;

    public RenvoieTemps(VerbeEcrit verbeEcrit)
    {
        verbeFutur = new Futur();
        PasseCompose verbePasseCompose = new PasseCompose();
        Present verbePresent = new Present();

        verbeFutur.setNextTemps(verbePasseCompose);
        verbePasseCompose.setNextTemps(verbePresent);
    }
}
