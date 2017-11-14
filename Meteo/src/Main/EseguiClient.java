package Main;
import Controller.ContrClient;
import VIEW.FinestraMeteo;
import VIEW.FrameStazioneMeteo;

public class EseguiClient{
	public static void main(String[] args){
			System.out.println("[INFO]-----------CLIENT-----------");
			FinestraMeteo f=new FinestraMeteo();
			ContrClient c=new ContrClient(f);
			System.out.println("[INFO]Finestra client lanciata");

	}
}