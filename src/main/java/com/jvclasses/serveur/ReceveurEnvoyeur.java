package com.jvclasses.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.io.InputStreamReader;

public class ReceveurEnvoyeur extends Thread
{
    Socket socket;
    int noConnexion;
    BufferedReader fluxEntrant; PrintStream fluxSortant;
    private conjPremierGroup verbePrGroupeCer;

    public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion) throws IOException, IOException
    {
        super(groupe, "ReceveurEnvoyeur");
        this.socket = socket;
        this.noConnexion = noConnexion;
        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        fluxSortant = new PrintStream(this.socket.getOutputStream());
    }

    private static int countLine(String string)
    {
        String[] line = string.split("\n \r |\r|\n");
        return line.length;
    }

    public void run()
    {
        String ligne;
        String reponse = "";
        try
        {
            while (true)
            {
                ligne = fluxEntrant.readLine();
                String verbeEtTemps[] = ligne.split(",");
                String verbeAconjuguer = verbeEtTemps[0];
                String temps = verbeEtTemps[1];

                System.out.println(" le client numéro " + this.noConnexion + " a envoyé le verbe : " + verbeAconjuguer + " au temps : " + temps);

                VerbeEcrit verbeEcrit = new VerbeEcrit(verbeAconjuguer, temps);
                RenvoieGroupe renvoieGroupe = new RenvoieGroupe(verbeEcrit);

                reponse = renvoieGroupe.verbePrGroupeCer.Terminaison(verbeEcrit);
                reponse += "\n" + "\n";
                int nbLine = countLine(reponse);
                System.out.println(nbLine);

                fluxSortant.println(nbLine + "\n" + reponse);

                sleep(5);
            }
        }
        catch(InterruptedException erreur)
        {
            System.out.println("Interrupted exception");
        }
        catch(IOException erreur)
        {
            System.out.println("On ne peut pas lire sur le socket provenant du client");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            fluxSortant.println("Veuillez rentrer un verbe et un temps");
        }
    }
}

