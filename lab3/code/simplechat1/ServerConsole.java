import java.io.*;
import client.*;
import common.*;
import ocsf.*;
import ocsf.server.ConnectionToClient;
public class ServerConsole implements ChatIF{
	
	final public static int DEFAULT_PORT = 5555;

    EchoServer server;

    public ServerConsole(int port)
    {
      try
      {
        server= new EchoServer(port);
      }
      catch(Exception exception)
      {
        System.out.println("Error: Can't setup server!"
                  + " Terminating server.");
        System.exit(1);
      }
    }

    public void accept() {
      try {
        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
        String message;
        message = fromConsole.readLine();
      

        /*
         * Implemented for E50 AB JY
         * Server side commands
         */
        if (message.startsWith("#")) {
            String[] parameters = message.split(" ");
            String command = parameters[0];
            switch (command) {
                case "#quit":
                    //closes the server and then exits it
                    try {
                        server.close();
                    } catch (IOException e) {
                        System.exit(1);
                    }
                    System.exit(0);
                    break;
                case "#stop":
                    server.stopListening();
                    break;
                case "#close":
                    try {
                        server.close();
                    } catch (IOException e) {
                    }
                    break;
                case "#setport":
                    if (!server.isListening() && server.getNumberOfClients() < 1) {
                        server.setPort(Integer.parseInt(parameters[1]));
                        System.out.println("Port set to " + Integer.parseInt(parameters[1]));
                    } else {
                        System.out.println("Can't do that now. Server is connected.");
                    }
                    break;
                case "#start":
                    if (!server.isListening()) {
                        try {
                            server.listen();
                        } catch (IOException e) {
                            //error listening for clients
                        }
                    } else {
                        System.out.println("We are already started and listening for clients!.");
                    }
                    break;
                case "#getport":
                    System.out.println("Current port is " + server.getPort());
                    break;
                case "#wait":
                	String wait= parameters[1];
                	int time= Integer.parseInt(wait);
                	server.setTimeout(time);
                	break;
                case "#numbers":
                	System.out.println(server.getNumberOfClients());
                	break;
                case "#all_users":
                	System.out.println(server.getClientConnections());
                	break;
                case "disconnect":
                	long toKick = Long.parseLong(parameters[1]);
                	Thread[] clients =server.getClientConnections();
                	boolean check =false;
                	for(int i=0;i<clients.length;i++){
                		if(clients[i].getId()==toKick){
                				((ConnectionToClient)clients[i]).close();
                				check = true;
                   		}
                	}
                	if (!check)
                		System.out.println("The client does note exist");
                	break;
                default:
                    System.out.println("Invalid command: '" + command+ "'");
                    break;
            }
        }
        else{
	        while(true) {
	          message = fromConsole.readLine();
	          message = "<SERVER MSG> "+message;
	          server.sendToAllClients(message);
	        }
        }
        
      }
      catch (Exception ex) {
        System.out.println
          ("Unexpected error while reading from console!");
      }
    }

    public void display(String message){}

    public static void main(String[] args)
    {
        int port = 0;  //The port number

        try
        {
          port = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
          port = DEFAULT_PORT;
        }
        ServerConsole server= new ServerConsole(port);
        server.accept();  //Wait for console data
    }
}
