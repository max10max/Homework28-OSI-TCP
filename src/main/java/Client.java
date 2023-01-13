import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client  {
    public static void main(String[] args)  {

        try (Socket socket = new Socket("127.0.0.1",8080);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println(reader.readLine());

            Scanner scanner = new Scanner(System.in);

            writer.println(scanner.nextLine());
            System.out.println("Message send");

            System.out.println(reader.readLine());

        }   catch (IOException e)   {
            e.printStackTrace();
        }
    }
}
