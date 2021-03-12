import java.io.IOException;

public class RunServer {
  public static void main(String args[]) throws IOException { 
    int serverPort = 8080;
    new Server(serverPort);
  }
}
