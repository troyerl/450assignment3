package common.factory;

import common.ConnectionRequests;
import common.commands.Command;

public abstract class CommandFactory {
  public abstract Command[] getCommands(ConnectionRequests stub, String id);
}
