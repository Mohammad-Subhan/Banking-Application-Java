package GraphicsPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class DepositFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel confirmatioPanel = new JPanel();
    private JButton closeButton = new JButton();
    private JSeparator closeSeparator = new JSeparator();
    private JLabel mainLabel = new JLabel();
    private JSeparator mainSeparator = new JSeparator();
    private JLabel textLabel1 = new JLabel();
    private TextField textField1 = new TextField();
    private RoundedButton depositButton = new RoundedButton();
    private RoundedButton okButton = new RoundedButton();
    private RoundedButton cancelButton = new RoundedButton();
    private JLabel iconLabel = new JLabel();
    private ImageIcon icon = new ImageIcon(".\\Images\\confirm.png");

    // input variable
    private String amount;

    public DepositFrame() {

        // ------------------ Main Label -----------------------
        mainLabel.setText("Deposit Amount");
        mainLabel.setBounds(45, 31, 500, 30);
        mainLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mainLabel.setForeground(UIUtils.SC_COLOR);
        panel.add(mainLabel);

        // ======================== Account Detail Seperator =======================
        mainSeparator.setOrientation(SwingConstants.HORIZONTAL);
        mainSeparator.setForeground(UIUtils.SP_COLOR);
        mainSeparator.setBounds(200, 49, 305, 1);
        panel.add(mainSeparator);

        // ------------------- Amount Label ------------------------
        textLabel1.setText("Amount:");
        textLabel1.setBounds(100, 95, 100, 100);
        textLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textLabel1.setForeground(UIUtils.TXT_COLOR);
        panel.add(textLabel1);

        // -------------------- Amount input Field ------------------------
        textField1.setBounds(200, 131, 250, 30);
        textField1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField1.getText().equals("Amount")) {
                    textField1.setText("");
                }
                textField1.setForeground(Color.white);
                textField1.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField1.getText().isEmpty()) {
                    textField1.setText("Amount");
                }
                textField1.setForeground(UIUtils.RG_COLOR);
                textField1.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        panel.add(textField1);

        // --------------------- Deposit button ----------------------
        depositButton.setBounds(160, 240, 100, 44);
        depositButton.setText("Deposit");
        depositButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        depositButton.setButtonColor(UIUtils.SC_COLOR);
        panel.add(depositButton);

        // --------------------- Cancel button ----------------------
        cancelButton.setBounds(290, 240, 100, 44);
        cancelButton.setText("Cancel");
        cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        cancelButton.setButtonColor(UIUtils.SC_COLOR);
        panel.add(cancelButton);

        // ==================== close button for the frame =========================
        closeButton.setText(null);
        closeButton.setBounds(525, 0, 25, 25);
        closeButton.setBackground(UIUtils.BG_COLOR);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(".\\Images\\close.png");
        closeButton.setIcon(imageIcon);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(UIUtils.BG_COLOR);
            }

        });
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        panel.add(closeButton);

        // ======================= Close Seperator ===========================
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(524, 2, 1, 21);
        panel.add(closeSeparator);

        // -------------------- Login Panel for the frame ---------------------
        panel.setBackground(UIUtils.BG_COLOR);
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
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
        frame.setSize(550, 320);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void ConfirmationDialog(String text) {

        panel.setVisible(false);
        iconLabel.setIcon(icon);
        iconLabel.setBounds(243, 80, 64, 64);
        confirmatioPanel.add(iconLabel);

        // ------------------- confirmation message -------------------------------
        textLabel1.setText(text);
        textLabel1.setBounds(165, 120, 1000, 100);
        confirmatioPanel.add(textLabel1);

        // --------------------- OK button ----------------------
        okButton.setBounds(225, 240, 100, 44);
        okButton.setText("OK");
        okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        okButton.setFocusable(false);
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                confirmatioPanel.setVisible(false);
                frame.setVisible(false);
                new HomePageFrame();
            }

        });
        okButton.setButtonColor(UIUtils.SC_COLOR);
        confirmatioPanel.add(okButton);

        // ==================== close button for the frame =========================
        closeButton.setText(null);
        closeButton.setBounds(525, 0, 25, 25);
        closeButton.setBackground(UIUtils.BG_COLOR);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(".\\Images\\close.png");
        closeButton.setIcon(imageIcon);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(UIUtils.BG_COLOR);
            }

        });
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        confirmatioPanel.add(closeButton);

        // ======================= Close Seperator ===========================
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(524, 2, 1, 21);
        confirmatioPanel.add(closeSeparator);

        // -------------------- Login Panel for the frame ---------------------
        confirmatioPanel.setBackground(UIUtils.BG_COLOR);
        confirmatioPanel.setLayout(null);
        confirmatioPanel.setBounds(0, 0, 800, 600);
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
        confirmatioPanel.addMouseListener(ma);
        confirmatioPanel.addMouseMotionListener(ma);
        frame.add(confirmatioPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == depositButton) {

            amount = textField1.getText();

            if (amount.equals("") || amount.equals("Amount")) {

                frame.setEnabled(false);
                new ErrorDialogBox(frame, "No Amount Entered");

            } else {

                AccountClass.account.CashDeposit(Double.parseDouble(amount));
                ConfirmationDialog("Amount Deposited Successfully");

            }

        } else if (e.getSource() == cancelButton) {

            frame.setVisible(false);
            new HomePageFrame();

        } else if (e.getSource() == okButton) {

            confirmatioPanel.setVisible(false);
            frame.setVisible(false);
            new HomePageFrame();

        }
    }

}
