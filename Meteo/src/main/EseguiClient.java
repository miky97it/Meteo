package main;
import Controller.ContrClient;
import VIEW.FinestraClientMeteo;
import VIEW.FrameStazioneMeteo;

public class EseguiClient{
	public static void main(String[] args){
			System.out.println("[INFO]-----------CLIENT-----------");
			FinestraClientMeteo f=new FinestraClientMeteo();
			ContrClient c=new ContrClient(f);
			System.out.println("[INFO]Finestra client lanciata");

	}
}