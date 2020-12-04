package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.ConnectionRequests;
import common.commands.Command;
import common.factory.MainMenuFactory;

public class Client {
  public static void main(String[] args) {
    try {
      // Getting the registry 
      Registry registry = LocateRegistry.getRegistry(null); 
      // Looking up the registry for the remote object 
      ConnectionRequests stub = (ConnectionRequests) registry.lookup("ConnectionRequests");

      
      System.out.println("Welcome!");
      String userId = startScreen(stub);

      Dispatcher dispatcher = new Dispatcher(stub, userId);
      dispatcher.dispatch();
       
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public static String startScreen(ConnectionRequests stub) {
    boolean showMenuOptions = true;
    String result = null;
    while(showMenuOptions) {
      try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        Command[] mainMenuOptions = mainMenuFactory.getCommands(stub, null);
        
        System.out.println("");
        for (int i = 0; i < mainMenuOptions.length; i++) {
          System.out.println((i + 1) + ".) " + mainMenuOptions[i].menuValue());
        }
  
        System.out.print("\nEnter your selection: ");
  
        int input = Integer.parseInt(reader.readLine());

        result = mainMenuOptions[input - 1].execute();

        if (result != null) {
          showMenuOptions = false;
        }  
      } catch (Exception e) {
        System.out.println("Please input correct choice");
      }
    }
    return result;
  }
}