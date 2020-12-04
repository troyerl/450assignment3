package common.factory;

import common.ConnectionRequests;
import common.commands.Command;
import common.commands.adminCommands.AddItemCommand;
import common.commands.adminCommands.NewAdminCommand;
import common.commands.adminCommands.RemoveCustomerCommand;
import common.commands.adminCommands.RemoveItemCommand;
import common.commands.adminCommands.UpdateItemCommand;
import common.commands.commonCommands.BrowserItemsCommand;
import common.commands.commonCommands.ExitCommand;
import common.commands.adminCommands.NewCustomerCommand;

public class AdminMenuFactory extends CommandFactory {
  public Command[] getCommands(ConnectionRequests stub, String id) {
    Command[] commands = {
      new BrowserItemsCommand(stub, id), 
      new AddItemCommand(stub, id), 
      new UpdateItemCommand(stub, id), 
      new RemoveItemCommand(stub, id), 
      new NewAdminCommand(stub, id), 
      new NewCustomerCommand(stub, id),
      new RemoveCustomerCommand(stub, id),
      new ExitCommand(stub, id),
    };

    return commands;
  };
}
