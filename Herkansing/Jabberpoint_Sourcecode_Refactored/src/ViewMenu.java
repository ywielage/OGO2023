import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenu extends MenuOption{
    Presentation presentation;
    Frame parent;
    Menu viewMenu;
    MenuItem menuItem;
    protected static final String GOTO = "Go to";
    protected static final String NEXT = "Next";
    protected static final String PAGENR = "Page number?";
    protected static final String PREV = "Prev";


    public ViewMenu(Presentation presentation, Frame parent, Menu menu){
        super(presentation, parent, menu);

        this.presentation = presentation;
        this.parent = parent;
        this.viewMenu = menu;

        loadNextItem();
        loadPrevItem();
        loadGoToItem();
    }

    public void loadNextItem() {
        		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.nextSlide();
			}
		});
    }

    public void loadPrevItem() {
        		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.prevSlide();
			}
		});
    }

    public void loadGoToItem() {
        		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				presentation.setSlideNumber(pageNumber - 1);
			}
		});
    }

    //Creating a menu-item
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
