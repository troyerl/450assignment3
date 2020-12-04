package common.commands;

import common.ConnectionRequests;

public abstract class Command {
  protected String id;
  protected ConnectionRequests stub;
  
  public Command(ConnectionRequests stub, String id) {
    this.id = id;
    this.stub = stub;
  }

  public abstract String execute();

  public abstract String menuValue();
}
