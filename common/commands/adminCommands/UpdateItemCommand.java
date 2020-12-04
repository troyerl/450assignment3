package common.commands.adminCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import common.ConnectionRequests;
import common.commands.Command;

public class UpdateItemCommand extends Command {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public UpdateItemCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    String itemName = null;
    String id = null;
    ArrayList<String> item = null;
    while(item == null) {
      System.out.print("Input Item Name to Upate it (Type 'Cancel' if you wish to go to the main screen): ");
      itemName = readUserInput();
      if (itemName.toLowerCase().trim().equals("cancel")) {
        return null;
      } else {
        try {
          HashMap<String, ArrayList<String>> items = this.stub.requestItem(itemName);
          if (items.size() == 0) {
            System.out.println("");
            System.out.println("No items found with that name, please try again.");
            System.out.println("");
            continue;
          } else if (items.size() > 1) {
            listItems(items);
            boolean getId = true;
            while(getId) {
              System.out.print("\nTwo items with this name have been found, please input the items ID you would like to update (Type 'Cancel' if you wish to go to the main screen): ");
              id = readUserInput();
              if (id.toLowerCase().equals("cancel")){
                return null;
              } else {
                item = items.get(id.trim());
                if (item == null) {
                  System.out.println("\nItem with that ID does not exist, please try again.\n");
                } else {
                  getId = false;
                }
              }
            }
          } else {
            listItems(items);
            id = items.keySet().stream().findFirst().get();;
            item = items.get(id);
          }
        } catch(Exception e) {
          System.err.println("Client exception: " + e.toString()); 
          e.printStackTrace();
        }
      }
    }

    System.out.println("\nTo update please type in the new value, if you don't wish to update then leave blank\n");
    System.out.print("Name: ");
    String name = readUserInput();
    
    boolean amountCheck = true;
    String amount = "";
    while(amountCheck) {
      try {
        System.out.print("Amount: ");
        amount = readUserInput();
        if (amount != "") {
          Double.parseDouble(amount);
        }
        amountCheck = false;
      } catch(Exception e) {
        System.out.println("Incorrect input type");
      }
    }

    System.out.print("Type: ");
    String type = readUserInput();
    System.out.print("Description: ");
    String description = readUserInput();
    

    boolean priceCheck = true;
    String price = "";
    while(priceCheck) {
      try {
        System.out.print("Price: ");
        price = readUserInput();
        if (price != "") {
          Double.parseDouble(amount);
        }
        priceCheck = false;
      } catch(Exception e) {
        System.out.println("Incorrect input type");
      }
    }

    if (name != "") {
      item.set(0, name);
    }
    if (amount != "") {
      item.set(1, amount);
    }
    if (type != "") {
      item.set(2, type);
    }
    if (description != "") {
      item.set(3, description);
    }
    if (price != "") {
      item.set(4, price);
    }

    try {
      this.stub.updateItem(item, id);
      System.out.println("\nItem has been updated!");
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString()); 
      e.printStackTrace();
    }
    
    return null;
  };

  private void listItems(HashMap<String, ArrayList<String>> items) {
    ArrayList<String> item = null;
    for (String i : items.keySet()) {
      item = items.get(i);
      System.out.println("_______________________________________");
      System.out.println("ID: "+ i);
      System.out.println("Name: " + item.get(0));
      System.out.println("Amount: " + item.get(1));
      System.out.println("Type: " + item.get(2));
      System.out.println("Description: " + item.get(3));
      System.out.println("Price: " + item.get(4));
    }
  } 

  public String menuValue() {
    return "Update Item";
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
