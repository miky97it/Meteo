package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import VIEW.FinestraMeteo;
public class ContrClient implements ActionListener,ChangeListener{
	private FinestraMeteo f;
	Socket socket;
	PrintWriter out;
	public ContrClient(FinestraMeteo f){
		this.f=f;
		f.getBtnInvia().addActionListener(this);
		f.getTabbedPane().addChangeListener(this);
	}
	private void inviaDati(String s){
		//Bortot
		try {
			//tastiera = new BufferedReader(new InputStreamReader(System.in));
			socket = new Socket("192.168.4.22"/*PC DI BORTOT*/,1234/*PORTA STANDARD*/);
			out = new PrintWriter(socket.getOutputStream(), true);
			/*
			 * 
			 * 			MANCA 
			 * 
			 * 
			 * 
			 * */
			
			
			
			
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		//----
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==f.getBtnInvia()){
			this.inviaDati(f.getTextField().getText());
			f.getTextField().setText("");
		}
		else{
		}
	}
	@Override
	public void stateChanged(ChangeEvent evt){
		switch(f.getTabbedPane().getSelectedIndex()){
			case 0: f.getTextField().setText("");
			break;
			case 1:
		}
	}
}