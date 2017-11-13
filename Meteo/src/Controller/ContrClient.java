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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import VIEW.FinestraMeteo;
public class ContrClient implements ActionListener,ChangeListener{
	private FinestraMeteo f;
	//Socket socket;
	PrintWriter out;
	InetAddress IP;
	final int PORT = 1234;
	//String MSG;
	//final InetAddress IP = InetAddress.getByName((args.length > 0) ? args[0] : "localhost");
	//final int PORT = (args.length > 1) ? Integer.parseInt(args[1]) : 1234;
	//final String MSG = (args.length > 2) ? args[2] : "GodAbenFitz";
	public ContrClient(FinestraMeteo f){
		this.f=f;
		try {
			IP=InetAddress.getByName(/*"192.168.4.22"*/"192.168.43.78");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR] IP not valid !");
			IP=null;
		}
		f.getBtnInvia().addActionListener(this);
		f.getTabbedPane().addChangeListener(this);
	}
	private void inviaDati(String MSG){
		//Bortot
		try {
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
	}
	@Override
	public void actionPerformed(ActionEvent evt){		//invio
		if(evt.getSource()==f.getBtnInvia()){
			String s=f.getTextField().getText();
			//System.out.println("Ho letto: "+s);
			this.inviaDati(s);
			f.getTextField().setText("");
		}
		else{
		}
	}
	@Override
	public void stateChanged(ChangeEvent evt){			//cambio tab
		switch(f.getTabbedPane().getSelectedIndex()){
			case 0: f.getTextField().setText("");
			break;
			case 1:
		}
	}
}