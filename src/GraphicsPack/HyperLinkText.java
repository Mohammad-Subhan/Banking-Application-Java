package GraphicsPack;

import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Cursor.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HyperLinkText extends JLabel {

    public HyperLinkText(String hyperlinkText, int xPos, int yPos, JFrame frame) {

        super(hyperlinkText);
        setForeground(UIUtils.RG_COLOR);
        setFont(new Font("Segoe UI", Font.PLAIN, 12));
        setCursor(getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                frame.setVisible(false);
                new RegisterFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(UIUtils.RG_COLOR.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(UIUtils.RG_COLOR);
            }
        });

        Dimension prefSize = getPreferredSize();
        setBounds(xPos, yPos, prefSize.width, prefSize.height);
    }
}