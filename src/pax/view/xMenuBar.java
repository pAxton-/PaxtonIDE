package pax.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This is the Singleton Class for the menubar of the main window(RootFrame). It extends the JMenuBar class is Swing
 * @see javax.swing.JMenuBar
 * @author pAxton
 */
public class xMenuBar extends JMenuBar {
    /**
     * Menu to be added to MenuBar
     */
    private JMenu file = new JMenu("File");

    /**
     * Menu to be added to MenuBar
     */
    private JMenu window = new JMenu("Window");

    /**
     * Menu to be added to MenuBar
     */
    private JMenu help = new JMenu("Help");

    /**
     * This is the array to hold all the Menu Items
     */
    private JMenu[] menus = {file, window, help};

    /**
     * MenuItem for window menu to show project tree
     */
    JCheckBoxMenuItem showFileTree = new JCheckBoxMenuItem("Project Tree");

    /**
     * MenuItem for window menu to show Editor window
     */
    JCheckBoxMenuItem showEditor = new JCheckBoxMenuItem("Editor Window");

    /**
     * Create be sqf file
     */
    JMenuItem newSqf = new JMenuItem("New SQF file");

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
        initMenu();
        createMenuItems();
    }

    /**
     * This method is called by the private constructor to add the menuitems to the MenuBar. It uses an array of MenuItems intialized by the class.
     */
    private void createMenuItems() {
        for (JMenu items : menus) {
            add(items);
        }
    }

    /**
     * Initialize Menu selections and add listeners
     */
    private void initMenu() {
        /* init show File tree check box in window menu and add listeners */
        showFileTree.setSelected(true);
        window.add(showFileTree);
        showFileTree.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    ProjectTreeFrame.getInstance().setVisible(false);
                }
                if (e.getStateChange() == ItemEvent.SELECTED){
                    ProjectTreeFrame.getInstance().setVisible(true);
                }
            }
        });
        /* init show Editor check box in window menu and add listeners */
        showEditor.setSelected(true);
        window.add(showEditor);
        showEditor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    EditorFrame.getInstance().setVisible(false);
                }
                if (e.getStateChange() == ItemEvent.SELECTED){
                    EditorFrame.getInstance().setVisible(true);
                }
            }
        });

        file.add(newSqf);
        newSqf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorFrame.getInstance().addFile("new");
            }
        });
    }
}
