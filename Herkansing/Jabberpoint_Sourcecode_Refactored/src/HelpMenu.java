import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends MenuOption {
    Presentation presentation;
    Frame parent;
    Menu helpMenu;

    MenuItem menuItem;
    protected static final String ABOUT = "About";

    public HelpMenu(Presentation presentation, Frame parent, Menu menu){
        super(presentation, parent, menu);

        this.presentation = presentation;
        this.parent = parent;
        this.helpMenu = menu;

        loadAboutItem();
    }

    public void loadAboutItem(){
        		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
    }

    //Creating a menu-item
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
