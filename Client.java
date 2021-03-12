import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
  private Socket socket;
  private int serverPort;
  private String serverIp;

  public Client(int serverPort, String serverIp) {
    this.serverPort = serverPort;
    this.serverIp = serverIp;
  }

  public void run() throws IOException {
    String string = getInputString();
    String reversedString = getReversedStringFromServer(string);
    System.out.println("String revertida é "+reversedString+'\n');
  }

  private String getReversedStringFromServer(String string) throws IOException {
    this.socket = new Socket(this.serverIp, this.serverPort);
    OutputStream outputStream = this.socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    dataOutputStream.writeUTF(string);
    dataOutputStream.close();
    outputStream.close();
    return readResponseFromServer();
  }

  private String readResponseFromServer() throws IOException {
    InputStream inputStream = this.socket.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(inputStream);
    String receivedString = new String(dataInputStream.readUTF());
    return receivedString;
  }

  private String getInputString() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite uma string para obtê-la revertida");
    String inpuString =  scanner.nextLine();
    scanner.close();
    return inpuString;
  }
}
