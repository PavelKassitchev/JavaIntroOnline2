package by.pavka.task.task3;

import java.io.*;
import java.net.Socket;

//Client should be launched after Server
public class ArchiveClient {


    public static void main(String[] args) throws IOException {
        ArchiveClient client = new ArchiveClient();
        client.communicate();
    }


    public void communicate() throws IOException {
        Socket socket = new Socket("localhost", 4004);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //Console reader for the client
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
                    reader.close();
                }
            }
        }
        System.out.println("Communication finished");
    }

}
