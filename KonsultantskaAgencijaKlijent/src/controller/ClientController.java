/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Klijent;
import domain.Konsultant;
import domain.MarketinskaAgencija;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import socket.Communication;
import transfer.ClientRequest;
import transfer.ServerResponse;
import transfer.util.Operations;
import transfer.util.ResponseStatus;

/**
 *
 * @author Jela
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Konsultant login(Konsultant konsultant) throws Exception {
        return (Konsultant) sendRequest(Operations.LOGIN, konsultant);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operations.ADD_KLIJENT, klijent);
    }

    public void addTermin(Termin termin) throws Exception {
        sendRequest(Operations.ADD_TERMIN, termin);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operations.DELETE_KLIJENT, klijent);
    }

    public void deleteTermin(Termin termin) throws Exception {
        sendRequest(Operations.DELETE_TERMIN, termin);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operations.UPDATE_KLIJENT, klijent);
    }

    public void updateTermin(Termin termin) throws Exception {
        sendRequest(Operations.UPDATE_TERMIN, termin);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operations.GET_ALL_KLIJENT, null);
    }

    public ArrayList<Termin> getAllTermin() throws Exception {
        return (ArrayList<Termin>) sendRequest(Operations.GET_ALL_TERMIN, null);
    }

    public ArrayList<Konsultant> getAllKonsultant() throws Exception {
        return (ArrayList<Konsultant>) sendRequest(Operations.GET_ALL_KONSULTANT, null);
    }

    public ArrayList<MarketinskaAgencija> getAllMarketinskaAgencija() throws Exception {
        return (ArrayList<MarketinskaAgencija>) sendRequest(Operations.GET_ALL_MARKETINSKA_AGENCIJA, null);
    }

    public ArrayList<Usluga> getAllUsluga() throws Exception {
        return (ArrayList<Usluga>) sendRequest(Operations.GET_ALL_USLUGA, null);
    }

    public ArrayList<StavkaTermina> getAllStavkaTermina(Termin t) throws Exception {
        return (ArrayList<StavkaTermina>) sendRequest(Operations.GET_ALL_STAVKA_TERMINA, t);
    }


    private Object sendRequest(int operation, Object data) throws Exception {
        ClientRequest request = new ClientRequest(operation, data);

	ObjectOutputStream oos = new ObjectOutputStream(
		Communication.getInstance().getSocket().getOutputStream());
	oos.writeObject(request);

	ObjectInputStream ois = new ObjectInputStream(
		Communication.getInstance().getSocket().getInputStream());
	ServerResponse response = (ServerResponse) ois.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

    public ArrayList<Termin> getAllTermin(Klijent k) throws Exception
    {
	return (ArrayList<Termin>) sendRequest(
		Operations.GET_ALL_TERMIN_KLIJENTA, k);
    }
}
