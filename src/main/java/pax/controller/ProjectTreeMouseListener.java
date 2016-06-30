package pax.controller;

import pax.view.EditorFrame;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * Created by Lance on 6/25/2016.
 */
public class ProjectTreeMouseListener implements MouseListener {

    private JTree tree;
    private BufferedReader br;
    private String line;
    private JTextArea ta;
    private String file;


    public ProjectTreeMouseListener(JTree tree) {
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int selRow = tree.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if (selRow != -1) {
            if (e.getClickCount() == 1) {

            } else if (e.getClickCount() == 2) {
                doubleClick(selRow, selPath);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Open file if double clicked if not already opened
     *
     * @param row
     * @param path
     */
    private void doubleClick(int row, TreePath path) {
        System.out.println(path.toString());

        try {
            System.out.println(path.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(EditorFrame.getInstance().getMissionDir());
           for(int i = 1;i < path.getPathCount();i++) {
                    sb.append(File.separatorChar).append(path.getPathComponent(i).toString());
            }

            file = sb.toString();

            br = new BufferedReader(new FileReader( file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            EditorFrame.getInstance().addFile(path.getLastPathComponent().toString());
            ta = EditorFrame.getInstance().getCurrentTextArea();
            line = br.readLine();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        while(line != null)
        {
            ta.append(line + "\n");
            try {
                line = br.readLine();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
