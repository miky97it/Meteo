package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.Messaggio;
import VIEW.FinestraMeteo;
import VIEW.FrameStazioneMeteo;
public class ContrStazione implements ActionListener{
	private FrameStazioneMeteo fm;
	public ContrStazione(FrameStazioneMeteo fm){
		this.fm=fm;
		fm.getBtnInvia().addActionListener(this);
		//fm.getComboBox().addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==fm.getBtnInvia()){
			
			String localita=fm.getTextFieldLocalit�().getText();
			String supp=fm.getComboBoxTempo().getSelectedItem().toString();
			int tempo;
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
			int vento=Integer.parseInt(fm.getTextField_vento().getText());
			Messaggio m=new Messaggio(localita,tempo,temperatura,vento,cmpioggia);
			InviaDati.inviaDati(m,"192.168.4.22",1234);

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
}