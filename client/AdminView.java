package client;

import common.commands.Command;
import common.factory.AdminMenuFactory;

public class AdminView extends View {
  AdminMenuFactory adminMenuFactory;
  public AdminView(Command[] menu) {
    super(menu);
  };

  public void show() {
    boolean showMenuOptions = true;
    String result = null;
    while(showMenuOptions) {
      try {
        System.out.println("");

        for (int i = 0; i < this.menu.length; i++) {
          System.out.println((i + 1) + ".) " + this.menu[i].menuValue());
        }
  
        System.out.print("\nEnter your selection: ");
  
        int input = Integer.parseInt(this.reader.readLine());

        result = this.menu[input - 1].execute();

        if (result != null) {
          showMenuOptions = false;
        }  
      } catch (Exception e) {
        System.out.println("Please input correct choice");
      }
    }
  };
}
