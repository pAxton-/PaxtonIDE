package pax.view;

import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Lance on 6/26/2016.
 */
public class EditorTabScrollPane extends RTextScrollPane {


    private int id = 0;
    private static int counter = 0;

    public EditorTabScrollPane(EditorFile file) {
        super(file);
        this.id = counter++;

        addCloseBtn();
    }

    public int getId() {
        return id;
    }


    public void addCloseBtn() {
        JPanel tabSurface = new JPanel(new GridLayout(1, 3));
        tabSurface.add(new JLabel("Title    "));
        JLabel closeBtn = new JLabel("x");
        tabSurface.add(closeBtn);

        addListener(closeBtn);

        super.add(tabSurface);


    }


    private void addListener(final JLabel closeBtn) {
        closeBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                MouseListener[] ml = closeBtn.getMouseListeners();


                for (MouseListener m : ml) {
                    closeBtn.removeMouseListener(m);
                }
                removeNotify();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                closeBtn.setForeground(Color.MAGENTA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeBtn.setForeground(Color.BLACK);
            }
        });

    }

}
