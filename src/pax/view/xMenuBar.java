package pax.view;

import javax.swing.*;

/**
 * This is the Singleton Class for the menubar of the main window(RootFrame). It extends the JMenuBar class is Swing
 * @see javax.swing.JMenuBar
 * @author pAxton
 */
public class xMenuBar extends JMenuBar {
    /**
     * MenuItem to be added to MenuBar
     */
    private JMenuItem file = new JMenuItem("File");

    /**
     * MenuItem to be added to MenuBar
     */
    private JMenuItem window = new JMenuItem("Window");

    /**
     * MenuItem to be added to MenuBar
     */
    private JMenuItem help = new JMenuItem("Help");

    /**
     * This is the array to hold all the Menu Items
     */
    private JMenuItem[] menuItems = {file, window, help};

    /**
     * Create the instance of the class
     */
    private static xMenuBar ourInstance = new xMenuBar();

    /**
     * Getter for the instance of this class
     * @return xMenuBar
     */
    public static xMenuBar getInstance() {
        return ourInstance;
    }

    /**
     * Private constructor
     */
    private xMenuBar() {
        createMenuItems();
    }

    /**
     * This method is called by the private constructor to add the menuitems to the MenuBar. It uses an array of MenuItems intialized by the class.
     */
    private void createMenuItems() {
        for (JMenuItem items : menuItems) {
            add(items);
        }
    }
}
