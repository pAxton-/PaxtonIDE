package pax.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pAxton on 6/19/2016.
 * This container holds the JInterframes for this application
 * @author pAxton
 */
public class xDesktop extends JDesktopPane {
    /**
     * create the Singleton Instance of this class
     */
    private static xDesktop instance = new xDesktop();

    /**
     * Get the Singleton Instance of this class
     * @return xDesktop
     */
    public static xDesktop getInstance() {
        if(instance == null) {
            instance = new xDesktop();
        }
        return instance;
    }
    /**
     * Private constructor for the xDesktop, call the JDesktopPane constructor for now
     */
    private xDesktop() {
        super();
        setBackground(Color.darkGray);
        setVisible(true);
        addEditorFrame();
        addProjectTree();
    }

    /**
     * This adds the Singleton Class EditorFrame to the desktop
     */
    private void addEditorFrame() {
        add(EditorFrame.getInstance());
        EditorFrame.getInstance().setVisible(true);
    }

    /**
     * This adds the Project Viewer to the desktop
     */
    private void addProjectTree() {
        add(ProjectTreeFrame.getInstance());
        ProjectTreeFrame.getInstance().setVisible(true);
    }

}
