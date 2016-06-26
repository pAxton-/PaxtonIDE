package pax.view;

import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * This is the frame that holds the tabbedpane for the open files.
 * @author pAxton
 */
public class EditorFrame extends JInternalFrame {
    /**
     * Fields for the JTabbedPane
     */
    private RTextScrollPane pane = new RTextScrollPane();
    private JTabbedPane tabbedPane = new JTabbedPane();


    /**
     * Create the instance of the class
     */
    private static EditorFrame ourInstance = new EditorFrame();
    private File missionDir;

    /**
     * Get the Instance of the class
     *
     * @return EditorFrame
     * @see javax.swing.JInternalFrame
     */
    public static EditorFrame getInstance() {
        if (ourInstance == null) {
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
        setClosable(false);
        setTitle("Editor");
        setMinimumSize(new Dimension(200, 200));
        setPreferredSize(new Dimension(800, 600));
        setLocation(200, 0);

        addFile("default");

        add(tabbedPane);
        pack();
    }

    /**
     * Add files to this EditorFrame
     *
     * @param filename
     */
    public void addFile(String filename) {
        tabbedPane.add(new RTextScrollPane(new EditorFile()));
    }


    public JTextArea getCurrentTextArea() {
        int t = tabbedPane.getTabCount();
        RTextScrollPane p = (RTextScrollPane) tabbedPane.getComponentAt(t-1);
        return p.getTextArea();
    }

    public void setMissionDirectory(File missionDir) {
        this.missionDir = missionDir;
    }

    public String getMissionDir() {
        return missionDir.toString();
    }
}