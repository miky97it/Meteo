package Model;

public class Messaggio {
	/**
	 * É una citta' o provincia*/
	private String localita;
	/**
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
	public Messaggio(){}
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
	private int cmpioggia;
}
