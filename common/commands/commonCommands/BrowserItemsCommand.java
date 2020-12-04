package common.commands.commonCommands;

import java.rmi.RemoteException;
import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;

public class BrowserItemsCommand extends Command {
  public BrowserItemsCommand(ConnectionRequests stub, String id) {
    super(stub, id);
  };

  public String execute() {
    try {
      System.out.println(stub.browseItems(this.id != null ? UUID.fromString(id) : null));
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return null;
  };

  public String menuValue() {
    return "Browse Items";
  };
}
