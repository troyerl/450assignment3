package common.commands.commonCommands;

import common.ConnectionRequests;
import common.commands.Command;

public class ExitCommand extends Command {
  public ExitCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    System.exit(0);
    return null;
  };

  public String menuValue() {
    return "Exit";
  };
}
