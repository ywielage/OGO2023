import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FileMenu extends MenuOption {

    Presentation presentation;
    Frame parent;
    Menu fileMenu;
    MenuItem menuItem;
    protected static final String EXIT = "Exit";
    protected static final String NEW = "New";
    protected static final String OPEN = "Open";
    protected static final String SAVE = "Save";
    protected static final String SAVEFILE = "savedPresentation.xml";
    protected static final String IOEX = "IO Exception: ";

    protected static final String SAVEERR = "Save Error";

    public FileMenu(Presentation presentation, Frame parent, Menu menu){
        super(presentation, parent, menu);

        this.presentation = presentation;
        this.parent = parent;
        this.fileMenu = menu;

        loadOpenMenuItem();
        loadOpenNewItem();
        loadSaveItem();
        loadExitItem();
    }

    public void loadOpenMenuItem() {
		fileMenu.add(menuItem = mkMenuItem(OPEN));

        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.loadFile(presentation, MenuController.TESTFILE);
                    presentation.setSlideNumber(0);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(parent, MenuController.IOEX + exc,
                            MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                parent.repaint();
            }
        } );
    }

    public void loadOpenNewItem() {
        fileMenu.add(menuItem = mkMenuItem(NEW));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                parent.repaint();
            }
        });
    }

    public void loadSaveItem() {
        		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, SAVEFILE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc,
							SAVEERR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});



		fileMenu.addSeparator();
    }

    public void loadExitItem(){
        		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.exit(0);
			}
		});
    }

    	public MenuItem mkMenuItem(String name) {
		    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
