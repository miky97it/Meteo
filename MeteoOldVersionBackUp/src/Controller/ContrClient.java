package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Messaggio;
import VIEW.FinestraMeteo;
public class ContrClient implements ActionListener{
	private FinestraMeteo f;
	//Socket socket;
	PrintWriter out;
//	String IP="128728937";

	//String MSG;
	//final InetAddress IP = InetAddress.getByName((args.length > 0) ? args[0] : "localhost");
	//final int PORT = (args.length > 1) ? Integer.parseInt(args[1]) : 1234;
	//final String MSG = (args.length > 2) ? args[2] : "GodAbenFitz";
	public ContrClient(FinestraMeteo f){
		this.f=f;
		resetframe();
		f.getBtnInvia().addActionListener(this);
	}
	private void resetframe() {
		f.lblIcona.setVisible(false);
		f.lblTemperatura.setVisible(false);
		f.lblIlMeteoDi.setVisible(false);
		f.lblNonHoQuesto.setVisible(false);
		f.lblPioggia.setVisible(false);
		f.lblVento.setVisible(false);
	
}
	//private void inviaDati(String MSG){
		//Bortot
		/*try {
			System.out.printf("[INFO]Invio di <\'%s\'> a [%s:%d]..\n", MSG, IP, PORT);
		//	out = new PrintWriter(socket.getOutputStream(), true);		
			
				//for (String MSG: args) {
					//System.out.printf("* Send \'%s\' message to [%s:%d]..\n", MSG, IP, PORT);
					DatagramSocket s = new DatagramSocket();
					s.send(new DatagramPacket(MSG.getBytes(), MSG.getBytes().length, IP, PORT));
					s.close();
				//}
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//----
	}*/
	@Override
	public void actionPerformed(ActionEvent evt){		//invio
		if(evt.getSource()==f.getBtnInvia()){
			resetframe();
			String s=f.getTextField().getText();
			//System.out.println("Ho letto: "+s);
			//this.inviaDati(s);
			Messaggio risposta=InterfacciaDati.inviaDati("#"+s,"localhost",1234);//Nessun json inizia per #
			if(risposta.getTempo()==0){
				f.lblNonHoQuesto.setVisible(true);
			}else{
				f.lblTemperatura.setText("Temperatura:"+risposta.getTemperatura()+"\u02DAc");
				f.lblTemperatura.setVisible(true);
				f.lblIlMeteoDi.setText("il meteo di "+risposta.getLocalita());//voltamente la ho preso da qui e non dalla domanda perché cosí faccio anche debug
				f.lblIlMeteoDi.setVisible(true);
				f.lblPioggia.setText("Pioggia: "+risposta.getCmpioggia()+" l/m\u00B2");
				f.lblPioggia.setVisible(true);
				f.lblVento.setText("Vento: "+risposta.getVento()+" km/h");
				f.lblVento.setVisible(true);
				f.lblIcona.setIcon(new ImageIcon(FinestraMeteo.class.getResource(getIcona(risposta.getTempo()))));//setta l'icona
				f.lblIcona.setVisible(true);
			}
			//f.getTextField().setText("");
						
		}else{
			System.out.println("[ERROR] action non implementata");
		}
	}
	private String getIcona(int caso){
		switch(caso){
			case 1:return "/media/1sole.png";
			case 2:return "/media/2nubi.png";
			case 3:return "/media/3coperto.png";
			case 4:return "/media/4pioggia.png";
			case 5:return "/media/5temporale.png";
			case 6:return "/media/6neve.png";
		}
		return null;
	}
}