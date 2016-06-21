package pax.controller;

import pax.view.RootFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Lance on 6/20/2016.
 */
public class MissionDirectoryChooser {
    /**
     * File Chooser to open at start of application, used to select mission Directory
     */
    private static JFileChooser fileChooser = new JFileChooser();

    /**
     * Path to the working directory
     */
    private static File missionDir;

    /**
     * Show dialog to get the mission from the user
     * @param parent
     */
    public void setWorkingDirectory(RootFrame parent) {
        fileChooser.setDialogTitle("Select Mission/Mod Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setBackground(Color.DARK_GRAY);
        int retVal = fileChooser.showDialog(parent, "Select Mission Folder");
        handleResultOfDialog(parent, retVal);
    }

    /**
     * Handle the return value of the Dialog
     * @param parent
     * @param returnVal
     */
    private void handleResultOfDialog(RootFrame parent, int returnVal) {
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setMissionDir(fileChooser.getSelectedFile());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No Mission/mod Folder Selected!\n              " +
                            "       Goodbye",
                    "Closing application",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon());

            System.exit(0);
        }

    }

    public static File getMissionDir() {
        return missionDir;
    }

    public static void setMissionDir(File missionDir) {
        MissionDirectoryChooser.missionDir = missionDir;
    }
}
