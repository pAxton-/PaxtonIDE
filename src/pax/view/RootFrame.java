package pax.view;

import javax.swing.*;
import java.awt.*;

/**
 * A extension of a JFrame that adds the contents of the Application
 * <ul>
 *     <li>MenuBar</li>
 *     <li>Desktop Panel</li>
 *     <li>Internal Frames</li>
 * </ul>
 */
public class RootFrame extends JFrame {
    /**
     * Variable to hold the resolution of the users screen.
     * This variable is initialized in the constructor using java.awt.ToolKit
     * @see java.awt.Toolkit
     */
    private Dimension screenSize;

    /**
     *  a constant for the minimum width of the application's main window
     */
    private final int minX = 200;

    /** a constant for the minimum height of the application's main window
     */
    private final int minY = 200;

    /**
     * The Desktop for the RootFrame.
     */
    private final xDesktop desktop = xDesktop.getInstance();

    /**
     * The MenuBar for the RootPane
     */
    private final xMenuBar menuBar = xMenuBar.getInstance();

    /**
     * Constructor for the Application window
     * @author pAxton
     *
     */
    public RootFrame() {
        super("PaxtonIDE");
        /* Close window on exit.*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /*Set the window to the size of the users screen resolution*/
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        /* Allow users to resize this window.*/
        setResizable(true);

        /* Do not allow users to resize the window below 200 pixels.*/
        setMinimumSize(new Dimension(minX,minY));

        /* Load componets into the frame */
        getUIComponets();

        /* Set the default size of the application window when opened */
        setPreferredSize(screenSize);

        /* pack evertything up!*/
        pack();
        EditorFrame.getInstance().setVisible(true);

    }

    /**
     * <p>Create the layout and all the components for this application.
     * This method is called in the constructor.</p>
     */
    private void getUIComponets() {

        /* Set the MenuBar of the application */
        getRootPane().setJMenuBar(menuBar);

        /* add xDesktop to the rootPane of the RootFrame */
        setContentPane(desktop);


    }
}
