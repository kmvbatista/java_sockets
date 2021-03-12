import java.io.IOException;

public class RunClient {
  public static void main(String args[]) throws IOException { 
    int serverPort = 8080;
    String serverIp = "localhost";
    Client client = new Client(serverPort, serverIp);
    client.run();
  }
}
