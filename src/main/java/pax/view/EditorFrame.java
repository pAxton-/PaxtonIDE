package pax.view;

import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * This is the frame that holds the tabbedpane for the open files.
 * @author pAxton
 */
public class EditorFrame extends JInternalFrame {
    /**
     * Fields for the JTabbedPane
     */

    private EditorTabbedPane tabbedPane;



    /**
     * Create the instance of the class
     */
    private static EditorFrame ourInstance = new EditorFrame();
    private File missionDir;
    private ArrayList<EditorTabScrollPane> scrollPanes = new ArrayList<>();

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
        tabbedPane = new EditorTabbedPane();
        addFile("untitled");


        add(tabbedPane);
        pack();
    }

    /**
     * Add files to this EditorFrame
     *
     * @param filename
     */
    public void addFile(String filename) {
        EditorTabScrollPane p = new EditorTabScrollPane(new EditorFile());
        scrollPanes.add(p);
        p.addCloseBtn();
        int last = scrollPanes.size();

        tabbedPane.add(scrollPanes.get(last - 1));
        int count = tabbedPane.getTabCount();
        tabbedPane.setTitleAt(count - 1, filename);
        tabbedPane.setSelectedIndex(count - 1);
        // tabbedPane.addCloseBtn((JComponent) tabbedPane.getSelectedComponent());


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