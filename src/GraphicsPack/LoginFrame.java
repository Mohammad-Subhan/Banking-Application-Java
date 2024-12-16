package GraphicsPack;

// ------------------- Necessary imports ------------------------
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import pack.AccountLogin;
import pack.Database;

// ------------------- LoginFrame Class -------------------------
public class LoginFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel logoLabel;
    private RoundedButton loginButton;
    private JButton closeButton;
    private TextField accountNumField;
    private PasswordField passwordField;
    private JSeparator separator;
    private JSeparator closeSeparator;
    private HyperLinkText registerText;
    private JLabel accountNumLabel;
    private JLabel pinLabel;

    // input variables
    private String accountNum;
    private String password;

    public LoginFrame() {

        frame = new JFrame();
        logoLabel = new JLabel();
        panel = new JPanel();
        loginButton = new RoundedButton();
        closeButton = new JButton();
        accountNumField = new TextField();
        passwordField = new PasswordField();
        separator = new JSeparator();
        closeSeparator = new JSeparator();
        accountNumLabel = new JLabel();
        pinLabel = new JLabel();

        // -------------------- close button for the frame --------------------
        closeButton.setText(null);
        closeButton.setBounds(775, 0, 25, 25);
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

        // -------------------- Seperator -------------------------------------
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(UIUtils.SP_COLOR);
        separator.setBounds(310, 80, 1, 240);
        panel.add(separator);

        // -------------------- Close Seperator -------------------------------
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(774, 2, 1, 21);
        panel.add(closeSeparator);

        // -------------------- Account Number Label -------------------------
        accountNumLabel.setText("Account Number");
        accountNumLabel.setBounds(425, 48, 1000, 100);
        accountNumLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        accountNumLabel.setForeground(UIUtils.RG_COLOR.brighter());
        panel.add(accountNumLabel);

        // -------------------- AccountNum input Field ------------------------
        accountNumField.setBounds(423, 109, 250, 44);
        accountNumField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (accountNumField.getText().equals("Account Number")) {
                    accountNumField.setText("");
                }
                accountNumField.setForeground(Color.white);
                accountNumField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (accountNumField.getText().isEmpty()) {
                    accountNumField.setText("Account Number");
                }
                accountNumField.setForeground(UIUtils.RG_COLOR);
                accountNumField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        panel.add(accountNumField);

        // -------------------- Account PIN Label -------------------------
        pinLabel.setText("Account PIN");
        pinLabel.setBounds(425, 119, 1000, 100);
        pinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        pinLabel.setForeground(UIUtils.RG_COLOR.brighter());
        panel.add(pinLabel);

        // -------------------- Password input Field --------------------------
        passwordField.setBounds(423, 180, 250, 44);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setForeground(Color.white);
                passwordField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                passwordField.setForeground(UIUtils.RG_COLOR);
                passwordField.setBorderColor(UIUtils.RG_COLOR);
            }
        });

        panel.add(passwordField);

        // -------------------- Login Button ----------------------------------
        loginButton.setBounds(423, 260, 250, 44);
        loginButton.setText("LOGIN");
        loginButton.setButtonColor(UIUtils.SC_COLOR);
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // -------------------- Register HyperLink Text -----------------------
        registerText = new HyperLinkText("Register", 629, 310, frame);
        registerText.setBounds(629, 310, 100, 20);
        panel.add(registerText);

        // -------------------- Logo Image ------------------------------------
        ImageIcon logo = new ImageIcon(".\\Images\\logo.png");
        logoLabel.setIcon(logo);
        logoLabel.setBounds(-110, -55, 500, 500);
        panel.add(logoLabel);
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
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            char[] passwordChars = passwordField.getPassword();
            password = new String(passwordChars);
            accountNum = accountNumField.getText();

            if (accountNum.equals("") || accountNum.equals("Account Number") || password.equals("")) {

                frame.setEnabled(false);
                new ErrorDialogBox(frame, "All Fields are required");

            } else {

                if (Database.CheckAccount(accountNum)) {

                    if (Database.CheckPin(accountNum, password)) {

                        AccountClass.account = AccountLogin.GetUser(accountNum);
                        frame.setVisible(false);
                        new HomePageFrame();

                    } else {
                        frame.setEnabled(false);
                        new ErrorDialogBox(frame, "Incorrect Password");
                    }

                } else {

                    frame.setEnabled(false);
                    new ErrorDialogBox(frame, "Incorrect Account Number");
                }
            }
        }

    }

}