import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Task1 {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int port = 12000;
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The WebServer is listening on port "+server.getLocalPort());
			while(true){
                client = server.accept();
                String sentense = client.toString();
                System.out.println(sentense);
            }
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("Hello world!");
	}

}
