package Main;
import Controller.ContrStazione;
import VIEW.FrameStazioneMeteo;

public class EseguiStazione{
	public static void main(String[] args){
		System.out.println("[INFO]-----------STAZIONE-----------");
			FrameStazioneMeteo fm=new FrameStazioneMeteo();
			ContrStazione ctr=new ContrStazione(fm);
			System.out.println("[INFO]Controller e Frame Stazione lanciati");
	}
}