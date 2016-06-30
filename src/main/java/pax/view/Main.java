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
                try {
                    // Set System L&F
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                }
                catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                }
                catch (ClassNotFoundException e) {
                    // handle exception
                }
                catch (InstantiationException e) {
                    // handle exception
                }
                catch (IllegalAccessException e) {
                    // handle exception
                }
                new RootFrame().setVisible(true);
            }
        });
    }
}
