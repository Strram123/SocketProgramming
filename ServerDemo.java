package socket.factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) {
		
	System.out.println("waiting for client");
	try {
		ServerSocket serversocket=new ServerSocket(9876);
		Socket socket=serversocket.accept();
		System.out.println("Connection Established");
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		int number=Integer.parseInt(reader.readLine());
	
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("factorial of "+number+" is: "+calculate(number));
	
		
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	static int calculate(int number){
		int fact=1;
		for(int i=1;i<=number;i++) {
			fact=fact*i;
		}
		return fact;
	}
}