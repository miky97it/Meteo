package Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Messaggio implements Serializable{
	/**
	 * É una citta' o provincia*/
	private String localita;
	/**
	 *0 RISERVATO PER LA MANCANZA DATO DA PARTE DEL SERVER
	 *1 soleggiato
	 *2 nubi sparse
	 *3 cielo coperto di nuve
	 *4 pioggia
	 *5 temporale con fulmini
	 *6 neve
	 **/
	private int tempo;
	private float temperatura;
	private int vento;
	private int cmpioggia;
	/**Solo per il ricevente*/
	public Messaggio(){}
	
	//**SOLO PER IL MITTENTE*/
	public Messaggio(String localita, int tempo, float temperatura, int vento, int cmpioggia) {
		super();
		this.localita = localita;
		this.tempo = tempo;
		this.temperatura = temperatura;
		this.vento = vento;
		this.cmpioggia = cmpioggia;
	}
	
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	public int getVento() {
		return vento;
	}
	public void setVento(int vento) {
		this.vento = vento;
	}
	public int getCmpioggia() {
		return cmpioggia;
	}
	public void setCmpioggia(int cmpioggia) {
		this.cmpioggia = cmpioggia;
	}
	private void writeObject(ObjectOutputStream out) throws IOException { 
		out.defaultWriteObject();  
		}
	private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException  {
		in.defaultReadObject();  
		}
	@Override
	public String toString() {
		return "Messaggio [localita=" + localita + ", tempo=" + tempo + ", temperatura=" + temperatura + ", vento="
				+ vento + ", cmpioggia=" + cmpioggia + "]";
	}
}