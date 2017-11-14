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
	private int cmpioggia;

	/**@deprecated Costruttore vuoto-necessita che tu inserisca tutti i dati con il get **/
	public Messaggio(){}
	
	//**Costruttore essenziale*/
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
}
