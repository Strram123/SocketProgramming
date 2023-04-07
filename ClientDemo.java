package socket.factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client Starts...");
			
			Socket socket=new Socket("localhost",9876);
			
			BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter The Number");
			
			int userEnteredValue=Integer.parseInt(userInput.readLine());
			
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			
			out.println(userEnteredValue);
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("server says: "+reader.readLine());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
			
		
	}

}
