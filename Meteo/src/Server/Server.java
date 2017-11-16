package Server;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import Controller.InterfacciaDati;
import Model.Messaggio;
public class Server {
	private DatagramSocket s;
	private DatagramPacket pkt;
	private byte[] buf = new byte[256];
	private ArrayList<Messaggio> messaggi=new ArrayList<Messaggio>();
	public static void main(String[] args) throws Exception {
		Server s=new Server((args.length > 0) ? Integer.parseInt(args[0]) : 1234);
		//istanzia un thread e lo fa partire con il primo parametro o 1234
	}
	
		public Server(int PORT) throws Exception{
			System.out.printf("[INFO]Server ready to recive on[%s:%d]..\n",InetAddress.getLocalHost().toString(),PORT);
			try {
				s = new DatagramSocket(PORT);
			} catch (Exception e1) {
				System.out.printf("[ERROR]Porta occupata, tento PORT++\n");
				s = new DatagramSocket(PORT++);
				e1.printStackTrace();
			}
			boolean running=true;
			System.out.println("[INFO]Server avviato");
			for (;running;) {
				pkt = new DatagramPacket(buf, buf.length);
				try {
					s.receive(pkt);
					//s.close();
				} catch (Exception e) {}
				byte[] CMD =new byte[256];
				CMD=pkt.getData();
				System.out.println("\n[DATA]---Recevuto un pacchetto---");
				System.out.println("\t Lunghezza: \t"+pkt.getLength());
				System.out.print("\t Da: \t\t"+pkt.getAddress()+":"+pkt.getPort());
				//System.out.println("CMD "+new String(CMD));
				if(new String(CMD).startsWith("#")){
					//stringa del luogo da client
					String luogoRichiesto=new String(CMD,1,pkt.getLength()-1);
					System.out.println("\n[DATA]Ho ricevuto una richiesta da un client per il luogo: "+luogoRichiesto);
					Messaggio risposta=getRisposta(luogoRichiesto);
					System.out.println("[INFO] Rispondo");
					InterfacciaDati.inviaDati(risposta,""+pkt.getAddress().toString().substring(1),pkt.getPort());
				}else{
					//messaggio della stazione
					System.out.println("\n\t ");
					Messaggio m=InterfacciaDati.JsonToMessaggio(new String(CMD));
					System.out.println("\n[INFO]Ricevuto oggetto: "+m.toString());
				/*
					ByteArrayInputStream byteStream = new ByteArrayInputStream(CMD);
				      ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
				      
					  System.out.println("[INFO]DESerializzazione della Stringa:\n\t"+CMD);
				      System.out.println("[INFO]DESerializzazione ha dato:\n\t"+is.readObject().toString());
				      //System.out.println("[INFO]DESerializzazione ha dato:\n\t"+is.readObject());
				      Model.Messaggio m =(Messaggio) is.readObject();
				      try {
						  m = (Model.Messaggio) is.readObject();
					} catch ( StreamCorruptedException e) {
						// TODO Auto-generated catch block
						e.getMessage();
						e.printStackTrace();
					}  
				      is.close();
				 */
				//Messaggio m= InterfacciaDati.fromDataArrayToMessaggio(CMD);
					addMessaggio(m);
				}
			}
			System.out.println("[INFO]Remote Command! Server Closed..");
			s.close();
		}

		private Messaggio getRisposta(String luogoRichiesto) {
			int i=0;
			//if(!messaggi.isEmpty())
			boolean flag=true;
			for ( i = 0; i < messaggi.size()&&flag; i++) {
				if(messaggi.get(i).getLocalita().toUpperCase().equals(luogoRichiesto.toUpperCase())){
					System.out.println("[INFO]Ho trovato la localitá richiesta dall'itente(indice: "+i+")");
					return messaggi.get(i);
				}
			}
			Messaggio m=new Messaggio();
			m.setTempo(0);// non ho il dato
			System.out.println("[INFO]NON Ho trovato la localitá richiesta dall'utente in memoria");
			return m; 
		}

		private void addMessaggio(Messaggio m) {
			int i=0;
			//if(!messaggi.isEmpty())
			boolean flag=true;
			for ( i = 0; i < messaggi.size()&&flag; i++) {//se non c'e' una dato per la localitá o l'indice non ha terminato l'array, itero
				if(messaggi.get(i).getLocalita().toUpperCase().equals(m.getLocalita().toUpperCase())){
					messaggi.set(i, m); flag=false;
					System.out.println("[INFO]la localitá é stata aggiornata(indice: "+i+")");
				}
			}
			if(flag){
				messaggi.add(m);
				System.out.println("[INFO]Aggiunto il messaggio con successo all'elenco(indice "+i+")");
			}
			for (int j = 0; j < messaggi.size(); j++) {
				System.out.println("[DEBUG]"+messaggi.get(j));
			}
		}
}