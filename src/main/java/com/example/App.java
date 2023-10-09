package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        try{
            ServerSocket server = new ServerSocket(3000);
            System.out.print("creo il server\n");
            Socket s = server.accept();
            System.out.print("creo la socket\n");        
            

            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out =  new DataOutputStream(s.getOutputStream());
            System.out.print("buffer");


            String string = in.readLine().toUpperCase();
            System.out.println("Il client ha inviato " + string);

            
            out.writeBytes(string + "\n");
            
            server.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
