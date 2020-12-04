package common.commands.adminCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;

public class RemoveItemCommand extends Command {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  public RemoveItemCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  }

  public String execute() {
    boolean deleteCheck = true;
    while(deleteCheck) {
      try {
        System.out.print("Input item ID to delete it (Type 'Cancel' if you wish to go to the main screen): ");
        String id = readUserInput();
        if (id.toLowerCase().equals("cancel")) {
          break;
        }

        UUID.fromString(this.id);
        boolean responseCheck = this.stub.removeItem(id);
        
        if (responseCheck) {
          deleteCheck = !responseCheck;
          System.out.println("\nItem has been deleted.");
        } else {
          System.out.println("\nItem with that ID does not exist, please try again.\n");
        }
      } catch (Exception e) {
        System.out.println("\nInvaild type, please try again\n");
      }
    }

    return null;
  };

  public String menuValue() {
    return "Delete Item";
  };

  private String readUserInput() {
    String input = null;
    try {
      input = this.reader.readLine();
    } catch(Exception e) {
      System.out.println("Please input correct choice");
    }

    return input;
  }
}
