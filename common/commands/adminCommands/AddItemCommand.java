package common.commands.adminCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.ConnectionRequests;
import common.commands.Command;

public class AddItemCommand extends Command {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  public AddItemCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  }
  public String execute() {
    System.out.println("\nAdd New Item\n___________________\n");
    String name = "", amount = "", type = "", description = "", price = "";
    ArrayList<String> newItem = new ArrayList<String>();
    
    while(name == "") {
      System.out.print("Name (Required): ");
      name = readUserInput();
    }
    newItem.add(name);

    while(amount == "") {
      try {
        System.out.print("Amount (Required): ");
        amount = readUserInput();
        Double.parseDouble(amount);
      } catch(Exception e) {
        System.out.println("Incorrect input type");
        amount = "";
      }
    }
    newItem.add(amount);

    while(type == "") {
      System.out.print("Type (Required): ");
      type = readUserInput();
    }
    newItem.add(type);

    while(description == "") {
      System.out.print("Description (Required): ");
      description = readUserInput();
    }
    newItem.add(description);

    while(price == "") {
      try {
        System.out.print("Price (Required): ");
        price = readUserInput();
        Double.parseDouble(price);
      } catch(Exception e) {
        System.out.println("Incorrect input type");
        price = "";
      }
    }
    newItem.add(price);

    try {
      this.stub.addItem(newItem);
      System.out.println("\nItem has been added!\n");
    } catch(Exception e) {
      System.out.println("Error");
    }

    return null;

  }

  public String menuValue() {
    return "Add New Item";
  }

  private String readUserInput() {
    String input = null;
    try {
      input = reader.readLine();
    } catch(Exception e) {
      System.out.println("Please input correct choice");
    }

    return input;
  }
}
