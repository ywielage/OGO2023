import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; //The frame, only used as parent for the Dialogs
	private Presentation presentation; //Commands are given to the presentation
	
	private static final long serialVersionUID = 227L;
	protected static final String FILE = "File";
	protected static final String HELP = "Help";
	protected static final String VIEW = "View";
	protected static final String TESTFILE = "testPresentation.xml";
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";


	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		MenuItem menuItem;

		// loads file menu
		Menu fileMenu = new Menu(FILE);
		new FileMenu(presentation, parent, fileMenu);
		add(fileMenu);

		//Loads view menu
		Menu viewMenu = new Menu(VIEW);
		new ViewMenu(presentation, parent, viewMenu);
		add(viewMenu);

		//Loads help menu
		Menu helpMenu = new Menu(HELP);
		new HelpMenu(presentation, parent, helpMenu);
		setHelpMenu(helpMenu);		//Needed for portability (Motif, etc.).
	}
}
