package by.pavka.task.task3;

import java.io.*;
import java.net.Socket;

public class ArchiveClient {

    private Socket socket; //сокет для общения
    private BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {
        ArchiveClient client = new ArchiveClient();;
        client.communicate();
    }

    public ArchiveClient() throws IOException {
        socket = new Socket("localhost", 4004);
        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void communicate() throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (!socket.isClosed()) {

            if (in.ready()) {
                String prompt = in.readLine();
                System.out.println(prompt);
            }
            if(reader.ready()) {
                String reply = reader.readLine();
                out.write(reply + '\n');
                out.flush();
                if(reply.equalsIgnoreCase("QUIT")) {
                    socket.close();
                }
            }
        }
        System.out.println("Communication finished");
    }

}
