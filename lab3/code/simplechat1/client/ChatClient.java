// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import java.io.*;
/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
	boolean loggedOn = true;

  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param username is the login ID of the user 
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  // **** Changed for E50 AB JY
  public ChatClient(String host, String username, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    clientUI.display(msg.toString());
  }

  
  protected void connectionClosed() {
	  System.out.println("The Server has disconnected");
	}
  
  protected void connectionException(Exception exception) {
	  System.out.println("Warning System has stopped lisening"+"\nServer is Shutting Down");
	  quit();
	  
	}
  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
	  // **** Changed for E50 AB JY

      if(message.charAt(0)=='#'){
      	if(message.equals("#quit")){
      		System.out.println("The pogram is now shutting down");
      		if(loggedOn){
      			try {
					this.closeConnection();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot Close connection");
				}
      			loggedOn=false;
      		}
      		this.quit();
      	}
      	else if(message.equals("#logoff")){
      		System.out.println("Logging Off");
      		try {
	      		loggedOn=false;
				this.closeConnection();
			} catch (IOException e) {
				System.out.println("can't log off");
				// TODO Auto-generated catch block
			}
      	}
      	else if (message.equals("#gethost")){
      		System.out.println("the Host is called " + this.getHost());
      	}
      	else if(message.equals("#getport")) {
               System.out.println("Current port: "+this.getPort());
      	}
      	else if(message.contains("#sethost")){
      		if(!loggedOn){
                  String tempHost = message.substring(message.indexOf(' ')+1);
                  this.setHost(tempHost);
                  System.out.println("Setting host to: "+tempHost);
              } else
                  System.out.println("Need to be logged off to use the #sethost <host> command. Try logging off using #logoff.");
      	}
      	else if(message.contains("#setport")){
               if(loggedOn==false){
                   int tempPort = Integer.parseInt(message.substring(message.indexOf(' ')+1));
                   this.setPort(tempPort);
                   System.out.println("Setting port to: "+tempPort);
               }
               else
                   System.out.println("Need to be logged off of server to use #setport <port> command. Try logging off using #logoff.");
           }
      	else if(message.equals("#login")){
      		System.out.println(loggedOn);
              if(loggedOn==false){
                  try {
					this.openConnection();
				} catch (IOException e) {
				
					System.out.println("Unable to connect to server");
				}
                  System.out.println("Connecting to client at hostname = "+this.getHost()+", port = "+this.getPort());
                  loggedOn = true;
              } 
              else{
                  System.out.println("Need to be logged off of server to use #login command. Try logging off using #logoff.");}
          } 
      	else if(message.equals("#help")){
              System.out.println("Client commands: #quit, #logoff, #gethost, #getport, #sethost <host>, #setport <port>, #login");
          }

      	else {
              System.out.println("Unknown command or command not properly entered. Type \'#help\' for commands.");
          }
      	
      }
      else{
	  try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
      }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
