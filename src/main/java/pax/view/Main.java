package pax.view;

import javax.swing.*;

/**
 * Created by pAxton on 6/19/2016.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RootFrame().setVisible(true);
            }
        });
    }
}
