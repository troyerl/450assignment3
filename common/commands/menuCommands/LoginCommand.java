package common.commands.menuCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;

public class LoginCommand extends Command {
  protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  public LoginCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  }

  public String execute() {
    UUID result = null;
    try {
      System.out.print("\nEnter username: ");
      String username = this.reader.readLine();

      System.out.print("Enter password: ");
      String password = this.reader.readLine();

      result = this.stub.loginUser(username.trim(), password.trim());

      if (result != null) {
        this.id = result.toString();
      } else {
        System.out.println("\nUser not found. Please try again.");
        this.id = null;
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return this.id;
  }

  public String menuValue() {
    return "Login";
  };
}
