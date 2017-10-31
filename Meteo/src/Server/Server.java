package Server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Server {
	private final DatagramSocket s;
	private DatagramPacket pkt;
	private byte[] buf = new byte[256];
	public static void main(String[] args) throws Exception {
		Server s=new Server((args.length > 0) ? Integer.parseInt(args[0]) : 1234);
		//istanzia un thread e lo fa partire con il primo parametro o 1234
	}
	
		public Server(int PORT) throws Exception{
			System.out.printf("[INFO]Server ready to recive on port: %d..\n", PORT);
			s = new DatagramSocket(PORT);
			String CMD;
			boolean running=true;
			System.out.println("[INFO]Frame Server avviato");
			for (;running;) {
				
			}
			pkt = new DatagramPacket(buf, buf.length);
			try {
				s.receive(pkt);
			} catch (Exception e) {}
			CMD = new String(pkt.getData(), 0, pkt.getLength());	
			System.out.printf("[DATA]> recive %d Byte message  \'%s\' from [%s:%s]..\n", pkt.getLength(), CMD, pkt.getAddress(), pkt.getPort());
			running = !CMD.equals("END");
			System.out.println("[INFO]Remote Command! Server Closed..");
			s.close();
		}
}