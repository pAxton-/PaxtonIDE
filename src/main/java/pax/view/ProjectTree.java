package pax.view;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
        missionRoot = createNodes(missionDir);
        DefaultTreeModel dtm = new DefaultTreeModel(missionRoot);
        setModel(dtm);
        setVisible(true);

    }

    /**
     * Create the project tree with the mission directory
     * @param missionDir
     */
    private TreeNode createNodes(File missionDir) {
        DefaultMutableTreeNode root = null;
        ArrayList<DefaultMutableTreeNode> nodes = new ArrayList<>();
        Path dir = missionDir.toPath();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

            System.out.println(dir.getNameCount());
            int i = 0;
            for (Path file: stream) {
                if (i == 0) {
                    root = new DefaultMutableTreeNode("Mission Folder");
                }

                    nodes.add(new DefaultMutableTreeNode(file.getFileName()));

                i++;
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

        for (DefaultMutableTreeNode nd : nodes) {
            root.add(nd);
        }

        return root;
    }
}
