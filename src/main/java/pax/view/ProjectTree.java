package pax.view;

import pax.controller.ProjectTreeMouseListener;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Created by pAxton on 6/19/2016.
 */
public class ProjectTree extends JTree {

    /**
     * Root Node for the Tree
     */
    private TreeNode missionRoot;

    /**
     * Constructor for this Tree that populates the ProjectTreeFrame
     * @param missionDir
     */
    public ProjectTree(File missionDir) {
        super();
        Path dir = missionDir.toPath();
        missionRoot = createNodes(dir);
        DefaultTreeModel dtm = new DefaultTreeModel(missionRoot);
        setModel(dtm);
        setVisible(true);
        addMouseListener(new ProjectTreeMouseListener(this));

    }

    /**
     * Create the project tree with the mission directory
     * @param missionDir
     */
    private TreeNode createNodes(Path missionDir) {
        DefaultMutableTreeNode root = null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        Path dir = missionDir;
       // File dir = missionDir;


        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {


            int i = 0;
            for (Path file: stream) {

                if (i == 0) {
                    root = new DefaultMutableTreeNode(file.getParent().getFileName());
                }
                File f = file.toFile();


                if(f.isDirectory()) {
                    TreeNode nextDir = createNodes(f.toPath());
                   nodes.add(nextDir);
                } else {
                    nodes.add(new DefaultMutableTreeNode(f.getName()));
                }
               i++;
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

        for (TreeNode nd : nodes) {

            root.add((DefaultMutableTreeNode)nd);
        }

        return root;
    }
}
