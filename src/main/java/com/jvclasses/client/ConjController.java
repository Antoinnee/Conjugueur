package com.jvclasses.client;

import com.jvclasses.serveur.Verbe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConjController
{
    private String ipEnregistree;
    private Integer portEnregistre;
    @FXML
    private TextField serveurIP;
    @FXML
    private TextField serveurPort;
    @FXML
    private TextField verbeAconjuguer;
    @FXML
    private TextField temps;
    @FXML
    private TextArea verbeConjugue;
    @FXML
    private Label erreur;
    @FXML
    private Button buttonEnvoyer;

    public void connect()
    {
        try
        {
            String ip = serveurIP.getText();
            int port = Integer.parseInt(serveurPort.getText());
            Socket socket;

            InetAddress adresse = InetAddress.getByName(ip);

            socket = new Socket(adresse, port);

            System.out.println("socket connecté : " + socket);

            buttonEnvoyer.setVisible(true);

            ipEnregistree = ip;
            portEnregistre = port;
            erreur.setVisible(true);
            erreur.setText("Connexion réussie, maintenant, entrez un verbe à l'infinitif et un temps (passé, présent, futur)");
        }
        catch(NumberFormatException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Veuillez rentrer un entier de 4 chiffres pour le porta");
        }
        catch (UnknownHostException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Host inconnu");
        }
        catch (IOException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Connexion impossible");
        }
        catch(RuntimeException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Veuillez rentrer un entier de 4 chiffres pour le portb");
        }
    }

    public void envoyerVerbe()
    {
        try
        {
            String ip = ipEnregistree;
            int port = portEnregistre;

            verbeConjugue.setText("");

            Socket socket;
            BufferedReader fluxEntrant;
            PrintStream fluxSortant;

            String verbeEtTemps = verbeAconjuguer.getText() + "," + temps.getText();

            InetAddress adresse = InetAddress.getByName(ip);

            socket = new Socket(adresse, port);

            fluxEntrant = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fluxSortant = new PrintStream(socket.getOutputStream());

            fluxSortant.println(verbeEtTemps);

            int line;
            line = Integer.parseInt(fluxEntrant.readLine());
            for(int i = 0; i <= line; i++)
            {
                verbeConjugue.appendText(fluxEntrant.readLine());
                verbeConjugue.appendText("\n");
            }

            erreur.setVisible(true);
            erreur.setText("Connecté");

        }
        catch(NumberFormatException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Veuillez rentrer un entier de 4 chiffres pour le portc");
        }
        catch (UnknownHostException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Host inconnu");
        }
        catch (IOException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Connexion impossible");
        }
        catch(RuntimeException ex)
        {
            erreur.setVisible(true);
            erreur.setText("Veuillez rentrer un entier de 4 chiffres pour le portd");
        }
    }
}
