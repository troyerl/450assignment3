package common.commands.customerCommands;

import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;

public class CheckoutCommand extends Command {
  public CheckoutCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    try {
      String receipt = this.stub.checkout(UUID.fromString(this.id));
      System.out.print(receipt);
    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  };

  public String menuValue() {
    return "Checkout";
  };
}
