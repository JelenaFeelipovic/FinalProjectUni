/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jela
 */
public class StartServerThread extends Thread {

    private ServerSocket serverSocket;

    public StartServerThread() {
        try {
	    serverSocket = new ServerSocket(2222);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
		Socket socket = serverSocket.accept();
		System.out.println("Povezan klijent preko soketa.");
                ClientRequestsThread th = new ClientRequestsThread(socket);
                th.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

}
