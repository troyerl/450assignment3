package common.factory;

import common.ConnectionRequests;
import common.commands.Command;
import common.commands.commonCommands.BrowserItemsCommand;
import common.commands.commonCommands.ExitCommand;
import common.commands.menuCommands.LoginCommand;
import common.commands.menuCommands.RegisterCommand;

public class MainMenuFactory extends CommandFactory {
  public Command[] getCommands(ConnectionRequests stub, String id) {
    Command[] commands = {
      new BrowserItemsCommand(stub, id), 
      new LoginCommand(stub, id),
      new RegisterCommand(stub, id),
      new ExitCommand(stub, id)
    };

    return commands;
  };
}
