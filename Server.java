import java.net.*;
import java.io.*;

public class Server {
  private ServerSocket serverSocket;
  private Socket socket;

  public Server(int portToRun) throws IOException {
    initializeSocketServer(portToRun);
    listen();
  }

  private void initializeSocketServer(int portToRun) throws IOException {
    this.serverSocket = new ServerSocket(portToRun);
  }

  private void listen() throws IOException {
    this.socket = serverSocket.accept();
    InputStream inputStream = this.socket.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(inputStream);
    String receivedString = new String(dataInputStream.readUTF());
    String reversedString = getReversedString(receivedString);
    dispatchResponse(reversedString);
    dataInputStream.close();
    inputStream.close();
    closeConnection();
  }

  private void dispatchResponse(String reversedString) throws IOException {
    OutputStream outputStream = this.socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    dataOutputStream.writeUTF(reversedString);
    dataOutputStream.close();
    outputStream.close();
  }

  private void closeConnection() throws IOException {
    this.socket.close();
  }

  private String getReversedString(String receivedString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(receivedString);
    return stringBuilder.reverse().toString();
  }
}
