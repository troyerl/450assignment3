package common.factory;

import common.ConnectionRequests;
import common.commands.Command;
import common.commands.commonCommands.BrowserItemsCommand;
import common.commands.commonCommands.ExitCommand;
import common.commands.customerCommands.AddItemToCartCommand;
import common.commands.customerCommands.CheckoutCommand;

public class CustomerMenuFactory extends CommandFactory {
  public Command[] getCommands(ConnectionRequests stub, String id) {
    Command[] commands = {
      new BrowserItemsCommand(stub, id),
      new AddItemToCartCommand(stub, id),
      new CheckoutCommand(stub, id),
      new ExitCommand(stub, id)
    };

    return commands;
  };
}