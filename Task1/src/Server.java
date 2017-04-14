import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Task1 {
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int port = 12000;
		ServerSocket server = null;
		Socket socket = null;
		InputStream  input = null;
		OutputStream output = null;
		String uri = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The WebServer is listening on port "+server.getLocalPort());
			while(true){
				socket = server.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
		        uri = parseUri(parse(input).toString());
//		        sendStaticResource(uri);
				int BUFFER_SIZE =1024;
				byte[] bytes = new byte[BUFFER_SIZE];
				FileInputStream fis = null;
				File file = new File(WEB_ROOT, uri);
				if (file.exists()) {
		            fis = new FileInputStream(file);
		            int ch = fis.read(bytes, 0, BUFFER_SIZE);
		            while (ch != -1) {
		                output.write(bytes, 0, ch);
		                ch = fis.read(bytes, 0, BUFFER_SIZE);
		            }
		        } else {
		            // file not found
		            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n"
		                    + "Content-Length: 23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
		            output.write(errorMessage.getBytes());
		        }
				socket.close();
//				System.out.println(input.toString());
            }
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("Hello world!");
	}

	private static String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
	}
	
	public static StringBuffer parse(InputStream input) {
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        return request;
    }
	
}
