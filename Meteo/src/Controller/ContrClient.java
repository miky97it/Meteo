package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Messaggio;
import VIEW.FinestraClientMeteo;
public class ContrClient implements ActionListener{
	private FinestraClientMeteo f;
	String IP="127.0.0.1";
	public ContrClient(FinestraClientMeteo f){
		this.f=f;
		resetframe();
	    JList ip=f.getListIP(); //mette GLi IP della scheda grafica nella lista
	    ip.setModel(new AbstractListModel() {
			String[] values = getIp();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	    f.setListIP(ip);
	    f.getBtnip().addActionListener(this);
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
	public void actionPerformed(ActionEvent evt){		//invio
		if(evt.getSource()==f.getBtnInvia()){
			resetframe();
			String s=f.getTextField().getText();
			//System.out.println("Ho letto: "+s);
			//this.inviaDati(s);
			Messaggio risposta=InterfacciaDati.inviaDati("#"+s,IP,1234);//Nessun json inizia per #
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
				f.lblIcona.setIcon(new ImageIcon(FinestraClientMeteo.class.getResource(getIcona(risposta.getTempo()))));//setta l'icona
				f.lblIcona.setVisible(true);
			}		
		}
		if(evt.getSource()==f.getBtnip()){
			IP=f.getIp().getText();
			System.out.println("[INFO]inserito un nuovo IP "+f.getIp().getText());
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
	private String[] getIp(){
	    ArrayList<String> lip = new ArrayList<String>();
	    try {
	        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
	        for(int i=0;interfaces.hasMoreElements();i++) {
	            NetworkInterface iface = interfaces.nextElement();
	            // filters out 127.0.0.1 and inactive interfaces
	            if (iface.isLoopback() || !iface.isUp())
	                continue;

	            Enumeration<InetAddress> addresses = iface.getInetAddresses();
	            while(addresses.hasMoreElements()) {
	                InetAddress addr = addresses.nextElement();
	                if (addr.getHostAddress().substring(0, 1).compareTo("f")!=0) { //non e' ipv6 ?
	                	//System.out.println(addr.getHostAddress().substring(1, 2)+" e   "+addr.getHostAddress());
	                	lip.add(addr.getHostAddress());
	                	System.out.println("[DEBUG] "+iface.getDisplayName() + " " + lip.get(lip.size()-1));
					}
	            }
	        }
	    } catch (SocketException e) {
	        throw new RuntimeException(e);
	    }
	    return lip.toArray(new String[lip.size()]);
	}
}