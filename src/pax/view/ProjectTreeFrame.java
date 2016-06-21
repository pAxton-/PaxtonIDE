package pax.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by pAxton on 6/19/2016.
 */
public class ProjectTreeFrame extends JInternalFrame{
    private ProjectTree tree;
    private static ProjectTreeFrame ourInstance = new ProjectTreeFrame();
    private File dir;

    public static ProjectTreeFrame getInstance() {
        return ourInstance;
    }

    private ProjectTreeFrame() {
        super();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setClosable(false);
        setTitle("Project Tree");
        setMinimumSize(new Dimension(200,200));
        setPreferredSize(new Dimension(200, 500));

        pack();
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public void addProjectTree(File dir) {
        tree = new ProjectTree(dir);
        add(tree);
    }
}
