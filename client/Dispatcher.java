package client;

import java.rmi.RemoteException;
import java.util.UUID;

import common.ConnectionRequests;
import common.commands.Command;
import common.factory.AdminMenuFactory;
import common.factory.CustomerMenuFactory;

public class Dispatcher {
  protected View view;
  protected ConnectionRequests stub;
  protected String id;

  public Dispatcher(ConnectionRequests stub, String id) {
    this.stub = stub;
    this.id = id;
  };

  public void dispatch() {
    if (checkIfAdmin(this.id)) {
      AdminMenuFactory adminMenuFactory = new AdminMenuFactory();
      Command[] adminMenu = adminMenuFactory.getCommands(stub, id);
      this.view = new AdminView(adminMenu);
    } else {
      CustomerMenuFactory customerMenuFactory = new CustomerMenuFactory();
      Command[] customerMenu = customerMenuFactory.getCommands(stub, id);
      this.view = new AdminView(customerMenu);
    }

    this.view.show();

  };

  public boolean checkIfAdmin(String id) {

    boolean isAdmin = false;
    try {
      isAdmin = this.stub.checkIfAdmin(UUID.fromString(id));

    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return isAdmin;
  }
}
