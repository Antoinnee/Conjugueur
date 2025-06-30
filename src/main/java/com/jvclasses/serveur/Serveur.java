package com.jvclasses.serveur;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur
{
    public static void main(String[] args) throws IOException, AlreadyBoundException
    {
        ServerSocket serveur;
        serveur = new ServerSocket(9111);
        System.out.println("Serveur conjugueur démarré : " + serveur);
        InetAddress cetteMachine;
        int portLocal;
        ThreadGroup groupe;
        portLocal = serveur.getLocalPort();
        cetteMachine = InetAddress.getLocalHost();
        System.out.println("Adresse IP du serveur : " + cetteMachine.getHostAddress());
        System.out.println("Port du serveur : "+portLocal);
        groupe = new ThreadGroup("socketsClients");

        int noConnexion = 0;

        while(true)
        {
            Socket nouveauClientSocket;
            ReceveurEnvoyeur nouveauClientThread;

            nouveauClientSocket = serveur.accept();
            ++noConnexion;
            System.out.println("Connexion réussie numéro : " + noConnexion);

            nouveauClientThread = new ReceveurEnvoyeur(nouveauClientSocket, groupe, noConnexion);
            nouveauClientThread.start();
        }
    }
}


