package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

import Model.Messaggio;
import VIEW.FinestraClientMeteo;
import VIEW.FrameStazioneMeteo;
public class ContrStazione implements ActionListener{
	private FrameStazioneMeteo fm;
	String IP="127.0.0.1";
	public ContrStazione(FrameStazioneMeteo fm){
		this.fm=fm;
	    JList ip=fm.getListIP(); //mette GLi IP della scheda grafica nella lista
	    ip.setModel(new AbstractListModel() {
			String[] values = getIp();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	    fm.setListIP(ip);
		fm.getBtnInvia().addActionListener(this);
		//fm.getComboBox().addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==fm.getBtnInvia()){
			
			String localita=fm.getTextFieldLocalitá().getText();
			String supp=fm.getComboBoxTempo().getSelectedItem().toString();
			int tempo=0;
				switch (supp){
					case "soleggiato": tempo=1;break;
					case "nubi sparse": tempo=2;break;
					case "cielo coperto di nuvole": tempo=3;break;
					case "pioggia": tempo=4;break;
					case "temporale con fulmini": tempo=5;break;
					case "neve": tempo=6;break;
				}
			float temperatura=Float.valueOf(fm.getSpinnerTemperatura().getValue().toString());
			//this.inviaDati(fm.getTextField().getText());
			//fm.getTextField().getText();
			int vento= (int) fm.getSpinner_vento().getValue();
			int cmpioggia=(Integer) fm.getSpinner().getValue();
			Messaggio m=new Messaggio(localita,tempo,temperatura,vento,cmpioggia);
			InterfacciaDati.inviaDati(m,IP,1234);
		}
		if(evt.getSource()==fm.getBtnip()){
			IP=fm.getIp().getSelectedText();
			System.out.println("[INFO]inserito un nuovo IP"+fm.getIp().getSelectedText());
		}
		/*else{
			String combo=(String) fm.getComboBox().getSelectedItem();
			switch(combo){
				case "vento":
				break;
				case "":
			}
		}*/
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