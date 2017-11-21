package Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import Model.Messaggio;

public class InterfacciaDati implements Serializable{
	static InetAddress IP;
	static ByteArrayInputStream byteStream ;

	/*static void inviaDati(String whatMSG,String toWhatIP,int throwWhatPort){
		//Bortot
		try {
			IP=InetAddress.getByName(/*"192.168.4.22"*//*"192.168.43.78"toWhatIP);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] IP not valid !");
			IP=null;
		}
		try {
			System.out.printf("[INFO]Invio di <\'%s\'> STRINGA ! a [%s:%d]..\n", whatMSG, IP, throwWhatPort);
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
	}*/

	
	static Messaggio inviaDati(String str,String toWhatIP,int throwWhatPort){
		//Bortot
		Messaggio m = null;
		try {
			IP=InetAddress.getByName(/*"192.168.4.22"*//*"192.168.43.78"*/toWhatIP);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] IP not valid !");
			IP=null;
		}
		try {
			  DatagramSocket s = new DatagramSocket();
			  /*
			 byte[] IMMACoolSerializedMessage=fromMessaggioToDataArray(MSG);
				System.out.println("[DATA]---Invio di un pacchetto---");
					System.out.println("\t Lunghezza: \t"+IMMACoolSerializedMessage.length);
					System.out.println("\t A: \t\t"+IP+":"+throwWhatPort);
			 //System.out.println("[INFO]Invio di \'%s\'> a [%s:%d]..\n", IMMACoolSerializedMessage, IP, throwWhatPort);
			  */
			  
			System.out.print("\n[DATA]---Invio di un pacchetto---\n\t Contenuto ");
			System.out.println(str);
				System.out.print("\n\t Lunghezza: \t"+str.length());
				System.out.println("\t A: \t\t"+IP+":"+throwWhatPort);

			  try {
				s.send(new DatagramPacket(str.getBytes(),str.length(), IP, throwWhatPort));
				System.out.println("[INFO]\t Invio di\t"+str+", effettuato");
				 
				 

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("[ERROR] invio fallito");
				e.printStackTrace();
			}
			System.out.println("[INFO]timeout settato a un secondo");
			s.setSoTimeout(1000);   // set the timeout in millisecounds.
			int retry=0;
			boolean running=true;
			while(running){        // recieve data until timeout
	            retry++;
				try {
	                byte[] buf = new byte[1000];
	                DatagramPacket dp = new DatagramPacket(buf, buf.length);
	                s.receive(dp);
	                running=false;
	                System.out.print("[DATA]---Risposta ricevuta---\n\t Contenuto ");
	    			System.out.println(dp.getData());
	    				System.out.print("\n\t Lunghezza: \t"+dp.getLength());
	    				System.out.println("\t A: \t\t"+IP+":"+throwWhatPort);
	               // String rcvd = "rcvd from " + dp.getAddress() + ", " + dp.getPort() + ": "+ new String(dp.getData(), 0, dp.getLength());
	                //System.out.println(rcvd);
	    			 m=InterfacciaDati.JsonToMessaggio(new String(dp.getData()));
	    			//m=InterfacciaDati.fromDataArrayToMessaggio(dp.getData());
				}
	            catch (SocketTimeoutException e) {
	                // timeout exception.
	                //System.out.println("Timeout reached!!! " + e);
	                if(retry>7){
		            	m=new Messaggio();
		            	running=false;
		    			m.setTempo(0);// non ho il dato
	    			}else{
	    				System.out.println("[ERROR] Il server non risponde,timeout "+retry);
	    			}
	    		}
	        }
			//s.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	public static void inviaDati(Messaggio MSG,String toWhatIP,int throwWhatPort){
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
			  DatagramSocket s = new DatagramSocket();
			  /*
			 byte[] IMMACoolSerializedMessage=fromMessaggioToDataArray(MSG);
				System.out.println("[DATA]---Invio di un pacchetto---");
					System.out.println("\t Lunghezza: \t"+IMMACoolSerializedMessage.length);
					System.out.println("\t A: \t\t"+IP+":"+throwWhatPort);
			 //System.out.println("[INFO]Invio di \'%s\'> a [%s:%d]..\n", IMMACoolSerializedMessage, IP, throwWhatPort);
			  */
			  
			System.out.print("[DATA]---Invio di un pacchetto---\n\t Contenuto ");
			byte[] jsonChar = MessageToJson(MSG).getBytes();
			//byte[] jsonChar = InterfacciaDati.fromMessaggioToDataArray(MSG);
				System.out.println("\n\t Lunghezza: \t"+jsonChar.length);
				System.out.println("\t A: \t\t"+IP+":"+throwWhatPort);
			  try {
				s.send(new DatagramPacket(jsonChar,jsonChar.length, IP, throwWhatPort));
				System.out.println("[INFO]\t Invio di\t"+jsonChar+", effettuato.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("[ERROR] invio fallito");
				e.printStackTrace();
			}
			  s.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String MessageToJson(Messaggio m){
		Gson gson = new Gson();
		System.out.print("JSON :"+gson.toJson(m));
		return gson.toJson(m);
	}
	public static Messaggio JsonToMessaggio(String json){
		Gson gson = new Gson();
		System.out.print("JSON :"+json);
		JsonReader reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		return gson.fromJson(reader , Messaggio.class );
	}
	
	/** Serializzazione
	 * @deprecated */
	public static byte[] fromMessaggioToDataArray(Messaggio m) throws IOException{
		  ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
		  ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
		  System.out.println("[INFO]Serializzazione dell'oggetto:\n\t"+m.toString());
		  os.flush();
		  os.writeObject(m);
		  os.flush();
		  os.close();
		  System.out.println("[INFO]Risultato serializzato in Stringa:\n\t"+byteStream.toByteArray());
		  return byteStream.toByteArray();
	}

	/**Deserializzazione
	* @deprecated */
	public static Messaggio fromDataArrayToMessaggio(byte[] recvBuf) throws IOException, ClassNotFoundException{
			byteStream = new ByteArrayInputStream(recvBuf);
	      ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
	      
		  System.out.println("[INFO]DESerializzazione della Stringa:\n\t"+recvBuf);
	      System.out.println("[INFO]DESerializzazione ha dato:\n\t"+is.readObject().toString());
	      //System.out.println("[INFO]DESerializzazione ha dato:\n\t"+is.readObject());
	      Model.Messaggio m = null;
	      try {
			  m = (Model.Messaggio) (Object) is.readObject();
		} catch ( StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
	      
	      is.close();

		//System.out.println("[INFO]DESerializzazione Castato in messaggio:"+o.toString());
	      return m;

	    }

}
