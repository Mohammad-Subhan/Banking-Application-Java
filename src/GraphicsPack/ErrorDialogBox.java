package GraphicsPack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialogBox {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel textLabel1 = new JLabel();
    private RoundedButton button = new RoundedButton();
    private ImageIcon error = new ImageIcon(UIUtils.IMAGES_PATH + "cancel.png");
    private JLabel errorLabel = new JLabel();

    public ErrorDialogBox(JFrame extFrame, String text) {

        errorLabel.setIcon(error);
        errorLabel.setBounds(180, 55, 64, 64);
        panel.add(errorLabel);

        // ------------------- confirmation message -------------------------------
        textLabel1.setText(text);
        textLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textLabel1.setBounds(135, 95, 1000, 100);
        textLabel1.setForeground(UIUtils.TXT_COLOR);
        panel.add(textLabel1);

        // --------------------- OK button ----------------------
        button.setBounds(172, 180, 80, 40);
        button.setText("OK");
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                extFrame.setEnabled(true);
                frame.setVisible(false);
            }

        });
        button.setButtonColor(UIUtils.SC_COLOR);
        panel.add(button);

        // -------------------- Login Panel for the frame ---------------------
        panel.setBackground(UIUtils.BG_COLOR);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(UIUtils.SC_COLOR, 2));
        panel.setBounds(0, 0, 425, 250);
        MouseAdapter ma = new MouseAdapter() {
            int lastX, lastY;

            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                frame.setLocation(frame.getLocationOnScreen().x + x - lastX, frame.getLocationOnScreen().y + y - lastY);
                lastX = x;
                lastY = y;
            }
        };
        panel.addMouseListener(ma);
        panel.addMouseMotionListener(ma);

        frame.add(panel);

        // -------------------- Settings for the frame ------------------------
        frame.setUndecorated(true);
        frame.setSize(425, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
