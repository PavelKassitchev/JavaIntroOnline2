package by.pavka.task.task3;

import by.pavka.task.task3.person.Student;
import by.pavka.task.task3.person.User;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArchiveServer {

    private static ServerSocket server;

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        server = new ServerSocket(4004);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server Socket and Command Console created");

        while(!server.isClosed()) {

            //Shutting down the server from server console
            if(br.ready()) {
                String serverCommand = br.readLine();
                if(serverCommand.equalsIgnoreCase("EXIT")) {
                    System.out.println("Server is shutting down...");
                    Archive.INSTANCE.close();
                    server.close();
                    break;
                }
            }

            Socket socket = server.accept();
            executorService.execute(new ClientDialog(socket));
            System.out.println("Connection accepted");
        }

        executorService.shutdown();
        System.out.println("Server is stopped");

    }


    //Main dialog thread
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

                    if(userString.equalsIgnoreCase("QUIT")) {
                        return;
                    }
                    String[] input = userString.split("#");
                    user = Archive.INSTANCE.getByLogin(input[0]);
                }

                if(reply.equalsIgnoreCase("UP")) {
                    userString = signUp(in, out);

                    if(userString.equalsIgnoreCase("QUIT")) {
                        return;
                    }
                    String[] input = userString.split("#");
                    user = new User(input[0], input[1]);
                    if(input[0].equals("Admin")) {
                        user.setPermission();
                    }
                    Archive.INSTANCE.addUser(user);
                }

                out.write("You are inside");
                out.flush();

                String exit = "";
                do {
                    exit = workInArchive(in, out, user);
                }
                while(!exit.equalsIgnoreCase("QUIT"));

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("Client disconnecting...");
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //After authorization the client is allowed to read files, modify or add them, give other users' permissions...
        private String workInArchive(BufferedReader in, BufferedWriter out, User user) throws IOException {
            String error = "";
            String reply = "";

            do {
                out.write(error + '\n' + "To finish this session print QUIT" + '\n' +
                        "To grant user with a permission to modify marks print P#<user login>" + '\n' +
                        "To see a student file print S#<student id>" + '\n' +
                        "To modify a student mark, if you are allowed to do it, print M#<student id>#<new mark>" + '\n' +
                        "To add new student file, if you are Admin, print A#<student name>#<student address>#<mark>" + '\n');
                out.flush();
                reply = in.readLine();
                error = "Wrong input";

                if(reply.equalsIgnoreCase("QUIT")) return "QUIT";

                if(reply.startsWith("P")) {
                    String[] input = reply.split("#");
                    if(input.length != 2) continue;
                    out.write(user.grantPermission(Archive.INSTANCE.getByLogin(input[1])));
                    out.flush();

                    return "Permission";
                }

                if(reply.startsWith("S")) {
                    String[] input = reply.split("#");
                    if(input.length != 2) continue;
                    int id = 0;
                    try {
                        id = Integer.parseInt(input[1]);
                    }
                    catch(NumberFormatException e) {
                        continue;
                    }
                    out.write(user.readFile(id));
                    out.flush();
                    return "File";
                }

                if(reply.startsWith("M")) {
                    String[] input = reply.split("#");
                    if(input.length != 3) continue;
                    int id = 0;
                    double mark = 0.0;
                    try {
                        id = Integer.parseInt(input[1]);
                        mark = Double.parseDouble(input[2]);
                    }
                    catch (NumberFormatException e) {
                        continue;
                    }
                    out.write(user.modifyMark(id, mark));
                    out.flush();
                    return "Mark";
                }

                if(reply.startsWith("A")) {
                    String[] input = reply.split("#");
                    if(input.length != 4) continue;
                    double mark = 0.0;
                    try {
                        mark = Double.parseDouble(input[3]);
                    }
                    catch (NumberFormatException e) {
                        continue;
                    }
                    Student student = new Student(input[1], input[2]);

                    out.write(user.addFile(student, mark));
                    out.flush();
                    return "User";
                }
            }
            while (true);

        }

        //Sign Up for new users
        private String signUp(BufferedReader in, BufferedWriter out) throws IOException {
            String error = "";
            String reply = "";
            boolean ok = false;
            do {
                out.write(error + '\n' + "Choose your login and password" + '\n'  +
                        "and print them separated by #, like<login>#<password>" + '\n' +
                        "To finish this session print QUIT" + '\n');
                out.flush();
                reply = in.readLine();

                if(reply.equalsIgnoreCase("QUIT")) {
                    return reply;
                }
                String[] input = reply.split("#");
                if(input.length != 2) {
                    error = "Wrong input";
                    continue;
                }
                if(!input[0].matches("\\w+")) {
                    error = "Login must contain only Latin letters and / or figures and can't be empty";
                    continue;
                }
                if(Archive.INSTANCE.getByLogin(input[0]) != null) {
                    error = "Login already exists";
                    continue;
                }
                if(!input[1].matches("\\w+")) {
                    error = "Password must contain only Latin letters and / or figures and can't be empty";
                    continue;
                }
                ok = true;
            }
            while(!ok);

            return reply;
        }

        //Sign in for existing users
        private String signIn(BufferedReader in, BufferedWriter out) throws IOException {
            String error = "";
            String reply = "";
            boolean ok = false;
            do {
                out.write(error + '\n' + "Print your login and password separated by #" + '\n'  +
                        "To finish this session print QUIT" + '\n');
                out.flush();
                reply = in.readLine();

                if(reply.equalsIgnoreCase("QUIT")) {
                    return reply;
                }

                String[] input = reply.split("#");
                if(input.length != 2) {
                    error = "Wrong input";
                    continue;
                }

                if(Archive.INSTANCE.getByLogin(input[0]) == null) {
                    error = "Wrong login";
                    continue;
                }
                int passHash = Objects.hash(input[0], input[1]);
                if(passHash != Archive.INSTANCE.getByLogin(input[0]).getPassHash()) {
                    error = "Wrong password";
                    continue;
                }
                ok = true;
            }
            while(!ok);

            return reply;
        }

        //First choice: either sign in or sign up
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
