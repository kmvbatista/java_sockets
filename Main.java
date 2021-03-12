import java.io.IOException;

public class Main {
  public static void main(String args[]) throws IOException { 
    int serverPort = 8080;
    String serverIp = "localhost";
    new Server(serverPort);
    Client client = new Client(serverPort, serverIp);
    client.run();
  }
}
