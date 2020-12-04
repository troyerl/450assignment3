package common.commands.menuCommands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;

public class RegisterCommand extends Command {
  protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public RegisterCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    UUID result = null;
    try {
      System.out.print("Enter first name: ");
      String firstName = this.reader.readLine();

      System.out.print("Enter last name: ");
      String lastName = this.reader.readLine();

      System.out.print("Enter username: ");
      String username = this.reader.readLine();

      System.out.print("Enter password: ");
      String password = this.reader.readLine();

      result = this.stub.registerUser(firstName.trim(), lastName.trim(), username.trim(), password.trim());

    } catch (Exception e) {
      e.printStackTrace();
    }

    return result.toString();
  };

  public String menuValue() {
    return "Register";
  };
}
