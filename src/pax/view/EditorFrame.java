package pax.view;

import javax.swing.*;
import java.awt.*;

/**
 * This is the frame that holds the tabbedpane for the open files.
 * @author pAxton
 */
public class EditorFrame extends JInternalFrame {
    /**
     * Fields for the JTabbedPane
     */
    private JTabbedPane pane = new JTabbedPane();
    /**
     * Create the instance of the class
     */
    private static EditorFrame ourInstance = new EditorFrame();

    /**
     * Get the Instance of the class
     * @return EditorFrame
     * @see javax.swing.JInternalFrame
     */
    public static EditorFrame getInstance() {
        if(ourInstance == null) {
            ourInstance = new EditorFrame();
        }
        return ourInstance;
    }

    /**
     * Private constructor
     */
    private EditorFrame() {
        super();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        setName("Editor");
        setMinimumSize(new Dimension(200,200));
        setPreferredSize(new Dimension(800, 600));
        addFile("default");
        add(pane);
        pack();
    }

    /**
     * Add files to this EditorFrame
     * @param filename
     */
    public void addFile(String filename) {
        pane.addTab(filename, new EditorFile());
    }
}
