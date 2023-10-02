/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import domain.Konsultant;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Jela
 */
public class Communication {

    private static Communication instance;
    private Socket socket;
    private Konsultant ulogovani;

    private Communication() {
        try {
	    socket = new Socket("localhost", 2222);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Konsultant ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Konsultant getUlogovani() {
        return ulogovani;
    }

}
