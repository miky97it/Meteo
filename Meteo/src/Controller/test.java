package Controller;

import java.io.*;
import java.net.*;

import Model.Messaggio;

public class test {
	public void sendTo(Object o, String hostName, int desPort) {
		try {
			InetAddress address = InetAddress.getByName(hostName);
			DatagramSocket dSock = new DatagramSocket();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
			os.flush();
			os.writeObject(o);
			os.flush();
			// retrieves byte array
			byte[] sendBuf = byteStream.toByteArray();
			DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, desPort);
			int byteCount = packet.getLength();
			dSock.send(packet);
			os.close();
		} catch (UnknownHostException e) {
			System.err.println("Exception:  " + e);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test cb = new test();
		//cb.sendTo(new String("ciao"), "localhost", 9999);
		Messaggio p = new Messaggio("",1, 1,1,1);
		cb.sendTo(p, "192.168.43.78", 1234);
		}
		
	}

