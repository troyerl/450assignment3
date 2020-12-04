package common.commands.adminCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.ConnectionRequests;
import common.commands.Command;

public class RemoveCustomerCommand extends Command {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public RemoveCustomerCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    System.out.print("Input customer username that you would like to remove (Type 'Cancel' if you wish to go to the main screen): ");
    String input = "";
    input = readUserInput();

    if (!input.trim().toLowerCase().equals("cancel")) {
      try {
        boolean deletionCheck = this.stub.removeCustomer(input.trim());

        if (deletionCheck) {
          System.out.println("\nCustomer has been deleted.");
        } else {
          System.out.println("\nError when trying to delete user, please try again.");
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    return null;
  };

  public String menuValue() {
    return "Remove User";
  };

  private String readUserInput() {
    String input = null;
    try {
      input = this.reader.readLine();
    } catch(Exception e) {
      System.out.println("Please input correct choice");
    }

    return input;
  };
}
