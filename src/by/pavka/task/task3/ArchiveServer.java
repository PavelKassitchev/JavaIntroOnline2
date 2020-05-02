package by.pavka.task.task3;

import by.pavka.task.task3.user.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArchiveServer {

    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        server = new ServerSocket(4004);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server Socket and Command Console created");

        while(!server.isClosed()) {

            Socket socket = server.accept();
            executorService.execute(new ClientDialog(socket));
            System.out.println("Connection accepted");

        }

        executorService.shutdown();

    }


    private static class ClientDialog implements Runnable {

        private Socket socket;

        public ClientDialog(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            User user = null;
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
                String reply = authen(in, out);
                if(reply.equalsIgnoreCase("QUIT")) {
                    System.out.println("The client has gone");
                    return;
                }
                String userString = null;
                if(reply.equalsIgnoreCase("IN")) {
                    userString = signIn(in, out);
                }

                if(reply.equalsIgnoreCase("UP")) {
                    userString = signUp(in, out);
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String signUp(BufferedReader in, BufferedWriter out) {
            //TODO
            return null;
        }

        private String signIn(BufferedReader in, BufferedWriter out) {
            //TODO
            return null;
        }

        private String authen(BufferedReader in, BufferedWriter out) throws IOException {
            String error = "";
            String reply = "";
            do {
                out.write(error + '\n' + "To finish this session print QUIT" + '\n' +
                        "To Sign In print IN" + '\n' + "To Sign Up print UP" + '\n');
                out.flush();
                reply = in.readLine();
                error = "Wrong input";
            }
            while(!reply.equalsIgnoreCase("QUIT") && !reply.equalsIgnoreCase("IN") && !reply.equalsIgnoreCase("UP"));
            return reply;
        }
    }
}
