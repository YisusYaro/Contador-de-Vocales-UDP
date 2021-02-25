import java.net.*;

import javax.print.DocFlavor.BYTE_ARRAY;

import java.io.*;

public class UDPServer {

	private static int numeroDeVocales(String frase) {
		int res = 0;
		String fraseMin = frase.toLowerCase();

		for (int i = 0; i < fraseMin.length(); ++i) {
			switch (fraseMin.charAt(i)) {
				case 'a':

				case 'e':

				case 'i':

				case 'o':

				case 'u':

					res++;
					break;
				default:
					// se ignoran las dem�s letras
			}
		}
		return res;
	}

	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(6789);
			// create socket at agreed port
			
			while (true) {
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				String frase = new String(request.getData());
				System.out.println("frase:"+ frase);
				String aux = new String( numeroDeVocales(frase) +"");
				System.out.println("numero:"+ aux);
				byte [] v = aux.getBytes();
				DatagramPacket reply = new DatagramPacket(v, aux.length(), request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}