package common.commands.adminCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.ConnectionRequests;
import common.commands.Command;

public class NewCustomerCommand extends Command {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public NewCustomerCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    ArrayList<String> newUser = new ArrayList<String>();
    String[] attributes = {"First name", "Last name", "Username", "Password"};
    String input = "";

    for (int i = 0; i < attributes.length; i++) {
      System.out.print(attributes[i] + ": ");
      input = readUserInput();
      newUser.add(input);
    }

    try {
      boolean createUserBool = this.stub.addUser(newUser, false);
      
      if (createUserBool) {
        System.out.println("\nCustomer has been created.");
      } else {
        System.out.println("\n User with that username already exists, please try again.");
      }

    } catch(Exception e) {
      System.out.println("Please input correct choice");
    }

    return null;
  };

  public String menuValue() {
    if (this.id != null) {
      return "Add New Customer";
    } else{
      return "Register";
    }
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
