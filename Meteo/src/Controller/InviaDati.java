package Controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import Model.Messaggio;

public class InviaDati {
	static InetAddress IP;
	static void inviaDati(String whatMSG,String toWhatIP,int throwWhatPort){
		//Bortot
		try {
			IP=InetAddress.getByName(/*"192.168.4.22"*//*"192.168.43.78"*/toWhatIP);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] IP not valid !");
			IP=null;
		}
		try {
			System.out.printf("[INFO]Invio di <\'%s\'> a [%s:%d]..\n", whatMSG, IP, throwWhatPort);
		//	out = new PrintWriter(socket.getOutputStream(), true);		
			
				//for (String MSG: args) {
					//System.out.printf("* Send \'%s\' message to [%s:%d]..\n", MSG, IP, PORT);
					DatagramSocket s = new DatagramSocket();
					s.send(new DatagramPacket(whatMSG.getBytes(), whatMSG.getBytes().length, IP, throwWhatPort));
					s.close();
				//}
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//----
	}
	static void inviaDati(Messaggio MSG,String toWhatIP,int throwWhatPort){
		//Bortot
		try {
			IP=InetAddress.getByName(/*"192.168.4.22"*//*"192.168.43.78"*/toWhatIP);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] IP not valid !");
			IP=null;
		}
		try {
			System.out.printf("[INFO]Invio di <\'%s\'> a [%s:%d]..\n", MSG.toString(), IP, throwWhatPort);
		//	out = new PrintWriter(socket.getOutputStream(), true);		
			
				//for (String MSG: args) {
					//System.out.printf("* Send \'%s\' message to [%s:%d]..\n", MSG, IP, PORT);
					DatagramSocket s = new DatagramSocket();
					s.send(new DatagramPacket(MSG.toString().getBytes(), MSG.toString().getBytes().length, IP, throwWhatPort));
					s.close();
				//}
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//----
	}
}
