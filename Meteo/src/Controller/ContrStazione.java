package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Model.Messaggio;
import VIEW.FinestraMeteo;
import VIEW.FrameStazioneMeteo;
public class ContrStazione implements ActionListener{
	private FrameStazioneMeteo fm;
	public ContrStazione(FrameStazioneMeteo fm){
		this.fm=fm;
		fm.getBtnInvia().addActionListener(this);
		fm.getComboBox().addActionListener(this);
	}
	private void inviaDati(String s){
		
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==fm.getBtnInvia()){
			String localita=fm.getTextField().getText();
			int tempo=0,vento=0,cmpioggia=0;
			float temperatura=0;
			this.inviaDati(fm.getTextField().getText());
			fm.getTextField().getText();
			Messaggio m=new Messaggio(localita,tempo,temperatura,vento,cmpioggia);
		}
		else{
			String combo=(String) fm.getComboBox().getSelectedItem();
			switch(combo){
				case "vento":
				break;
				case "":
			}
		}
	}
}