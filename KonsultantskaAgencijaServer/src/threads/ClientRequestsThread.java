/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.ServerController;
import domain.Klijent;
import domain.Konsultant;
import domain.Termin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ClientRequest;
import transfer.ServerResponse;
import transfer.util.Operations;
import transfer.util.ResponseStatus;

/**
 *
 * @author Jela
 */
public class ClientRequestsThread extends Thread {

    private Socket socket;

    ClientRequestsThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
		ClientRequest request = receiveRequest();
                ServerResponse response = handleRequest(request);
		sendResponse(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerResponse handleRequest(ClientRequest request) {
        ServerResponse response = new ServerResponse(null, null, ResponseStatus.Success);
        try {
	    switch (request.getOperation())
	    {
		case Operations.LOGIN:
		    Konsultant konsultant = (Konsultant) request.getData();
		    Konsultant ulogovani = ServerController.getInstance().login(
			    konsultant);
		    response.setData(ulogovani);
		    break;
                case Operations.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) request.getData());
                    break;
                case Operations.ADD_TERMIN:
                    ServerController.getInstance().addTermin((Termin) request.getData());
                    break;
                case Operations.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) request.getData());
                    break;
                case Operations.DELETE_TERMIN:
                    ServerController.getInstance().deleteTermin((Termin) request.getData());
                    break;
                case Operations.UPDATE_KLIJENT:
                    ServerController.getInstance().updateKlijent((Klijent) request.getData());
                    break;
                case Operations.UPDATE_TERMIN:
                    ServerController.getInstance().updateTermin((Termin) request.getData());
                    break;
                case Operations.GET_ALL_KLIJENT:
                    response.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operations.GET_ALL_KONSULTANT:
                    response.setData(ServerController.getInstance().getAllKonsultant());
                    break;
                case Operations.GET_ALL_MARKETINSKA_AGENCIJA:
                    response.setData(ServerController.getInstance().getAllMarketinskaAgencija());
                    break;
                case Operations.GET_ALL_STAVKA_TERMINA:
                    response.setData(ServerController.getInstance().getAllStavkaTermina((Termin) request.getData()));
                    break;
                case Operations.GET_ALL_TERMIN:
                    response.setData(ServerController.getInstance().getAllTermin());
                    break;
                case Operations.GET_ALL_USLUGA:
                    response.setData(ServerController.getInstance().getAllUsluga());
                    break;
		case Operations.GET_ALL_TERMIN_KLIJENTA:
		    response.setData(
			    ServerController.getInstance().getAllTermin(
				    (Klijent) request.getData()));
		    break;

		default:
		    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

    private ClientRequest receiveRequest()
    {
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(
		    socket.getInputStream());
	    return (ClientRequest) ois.readObject();
	} catch (IOException ex)
	{
	    Logger.getLogger(ClientRequestsThread.class.getName()).log(Level.SEVERE,
		    null, ex);
	} catch (ClassNotFoundException ex)
	{
	    Logger.getLogger(ClientRequestsThread.class.getName()).log(Level.SEVERE,
		    null, ex);
	}
	return null;
    }

    private void sendResponse(ServerResponse response)
    {
	try
	{
	    ObjectOutputStream oos = new ObjectOutputStream(
		    socket.getOutputStream());
	    oos.writeObject(response);
	    oos.flush();
	} catch (IOException ex)
	{
	    Logger.getLogger(ClientRequestsThread.class.getName()).log(Level.SEVERE,
		    null, ex);
	}
    }

}
