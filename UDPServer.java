import java.net.*;

import javax.print.DocFlavor.BYTE_ARRAY;

import java.io.*;

public class UDPServer{

	public static byte []numeroDeVocales(byte []frase) {
		String oracion = new String(frase);
		int res = 0;
		String fraseMin = oracion.toLowerCase();

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
		String aux = String.valueOf(res);
		byte []auxi = aux.getBytes();
		return auxi;
	}
    public static void main(String args[]){ 
    	DatagramSocket aSocket = null;
		try{
	    	aSocket = new DatagramSocket(6789);
					// create socket at agreed port
			byte[] buffer = new byte[1000];
 			while(true){
 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  				aSocket.receive(request);  
				byte []v = numeroDeVocales(request.getData());
				String aux = new String(v);
    			DatagramPacket reply = new DatagramPacket(v, aux.length(), 
    				request.getAddress(), request.getPort());
    			aSocket.send(reply);
    		}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
    }
}