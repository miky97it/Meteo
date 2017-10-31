package Main;
import Controller.ContrClient;
import VIEW.FinestraMeteo;

public class Main{
	public static void main(String[] args){
			FinestraMeteo f=new FinestraMeteo();
			ContrClient c=new ContrClient(f);
	}
}