package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.commands.Command;

public abstract class View {
  protected BufferedReader reader;
  protected Command[] menu;

  public View(Command[] menu) {
    this.menu = menu;
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }
  public abstract void show();
}
