package Main;

import Server.Server;

public class EseguiServer {

	public static void main(String[] args) {
		System.out.println("[INFO]-----------SERVER-----------");
		try {
			Server S=new Server(1234);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
