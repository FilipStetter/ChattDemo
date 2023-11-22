package ServerPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Handler extends Thread{

    private Socket socket;
    private MultiWriter multiWriter;

    public Handler (Socket socket, MultiWriter multiWriter){
        this.socket = socket;
        this.multiWriter = multiWriter;
    }

    public void run(){

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //true for autoflush
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));){


            multiWriter.addWriter(out);
            String input = "";

            while((input = in.readLine()) != null){
                multiWriter.print(input);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}