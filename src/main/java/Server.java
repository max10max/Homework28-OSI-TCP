import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        String nameCity = "???";
        try (ServerSocket serverSocket = new ServerSocket(8080);) {

            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

                    System.out.println("New connection accepted");

                    out.println(nameCity + " - последнее имя. Введите свой вариант.");


                    String name = in.readLine();
                    System.out.println("Введенный город игроком: " + name);

                    if(nameCity.startsWith("???")){
                        out.println("Ok");
                        nameCity = name;
                        System.out.println("Текущий город: " + nameCity);
                    } else {

                        boolean result = Character.toString(nameCity.charAt(nameCity.length()-1)).equals(Character.toString(name.charAt(0)));
                        if (result) {
                            out.println("OK");
                            nameCity = name;
                            System.out.println("Текущий город: " + nameCity);
                        } else {
                            out.println("NOT OK");
                            System.out.println("Текущий город: " + nameCity);
                        }
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();

        }

    }
}
