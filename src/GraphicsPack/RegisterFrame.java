package GraphicsPack;

// ====================== Necessary imports ==========================
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;

import pack.AccountRegistration;

// ======================== SignUp Class ===========================
public class RegisterFrame implements ActionListener {

    private JFrame frame;
    private JPanel registerPanel;
    private JPanel accountPanel;
    private JLabel accountRegLabel;
    private JLabel personalDetailsLabel;
    private JLabel fullNameLabel;
    private JLabel fatherNameLabel;
    private JLabel cnicLabel;
    private JLabel dobLabel;
    private JLabel genderLabel;
    private JLabel emaiLabel;
    private JLabel phoneNumLabel;
    private JLabel accountPinLabel;
    private JLabel initialDepositLabel;
    private TextField accountPinField;
    private TextField initialDepositField;
    private TextField fullNameField;
    private TextField fatherNameField;
    private TextField cnicField;
    private TextField dobField;
    private TextField genderField;
    private TextField emailField;
    private TextField phoneNumField;
    private JButton closeButton;
    private JComboBox<String> dateChoser;
    private JComboBox<String> monthChoser;
    private JComboBox<String> yearChoser;
    private JComboBox<String> genderChoser;
    private RoundedButton registerButton;
    private JSeparator personalDetailSeparator;
    private JSeparator accountDetailSeparator;
    private JSeparator closeSeparator;

    // input variables;
    private String fullname;
    private String fatherName;
    private String cnic;
    private String dob;
    private String gender;
    private String email;
    private String phoneNum;
    private String accountPin;
    private String iniDeposit;

    private String[] dates = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
    private String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    private String[] years = new String[100];
    private String[] genders = { "Male", "Female", "Other" };

    public RegisterFrame() {

        // ========================= Assigning 100 year values =======================
        for (int i = 0; i < 100; i++) {
            years[i] = "" + (2006 - i);
        }

        frame = new JFrame();
        registerPanel = new JPanel();
        accountRegLabel = new JLabel();
        personalDetailsLabel = new JLabel();
        fullNameLabel = new JLabel();
        fatherNameLabel = new JLabel();
        cnicLabel = new JLabel();
        dobLabel = new JLabel();
        genderLabel = new JLabel();
        emaiLabel = new JLabel();
        phoneNumLabel = new JLabel();
        accountPinLabel = new JLabel();
        initialDepositLabel = new JLabel();
        accountPinField = new TextField();
        initialDepositField = new TextField();
        fullNameField = new TextField();
        fatherNameField = new TextField();
        cnicField = new TextField();
        dobField = new TextField();
        genderField = new TextField();
        emailField = new TextField();
        phoneNumField = new TextField();
        dateChoser = new JComboBox<String>(dates);
        monthChoser = new JComboBox<String>(months);
        yearChoser = new JComboBox<String>(years);
        genderChoser = new JComboBox<String>(genders);
        registerButton = new RoundedButton();
        closeButton = new JButton();
        personalDetailSeparator = new JSeparator();
        accountDetailSeparator = new JSeparator();
        closeSeparator = new JSeparator();

        // ==================== close button for the frame =========================
        closeButton.setText(null);
        closeButton.setBounds(675, 0, 25, 25);
        closeButton.setBackground(UIUtils.BG_COLOR);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(UIUtils.IMAGES_PATH + "close.png");
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
        registerPanel.add(closeButton);

        // ======================== Account Registration Label ====================
        accountRegLabel.setText("Account Registration");
        accountRegLabel.setBounds(45, 31, 500, 30);
        accountRegLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        accountRegLabel.setForeground(UIUtils.SC_COLOR);
        registerPanel.add(accountRegLabel);

        // ===================== Personal Details Label ============================
        personalDetailsLabel.setText("Personal Details");
        personalDetailsLabel.setBounds(50, 70, 500, 30);
        personalDetailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        personalDetailsLabel.setForeground(UIUtils.RG_COLOR);
        registerPanel.add(personalDetailsLabel);

        // ======================== Personal Detail Seperator =======================
        personalDetailSeparator.setOrientation(SwingConstants.HORIZONTAL);
        personalDetailSeparator.setForeground(UIUtils.SP_COLOR);
        personalDetailSeparator.setBounds(167, 87, 483, 1);
        registerPanel.add(personalDetailSeparator);

        // ======================= Close Seperator ===========================
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(674, 2, 1, 21);
        registerPanel.add(closeSeparator);

        // ======================= Full Name Label =============================
        fullNameLabel.setText("Full Name:");
        fullNameLabel.setBounds(60, 108, 500, 30);
        fullNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(fullNameLabel);

        // ======================== Fullname TextField =========================
        fullNameField.setBounds(190, 110, 250, 30);
        fullNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameField.setMargin(new Insets(2, 5, 2, 2));
        fullNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fullNameField.getText().equals("Full Name")) {
                    fullNameField.setText("");
                }
                fullNameField.setForeground(Color.white);
                fullNameField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fullNameField.getText().isEmpty()) {
                    fullNameField.setText("Full Name");
                }
                fullNameField.setForeground(UIUtils.RG_COLOR);
                fullNameField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(fullNameField);

        // ========================== Father Name Label =============================
        fatherNameLabel.setText("Father Name:");
        fatherNameLabel.setBounds(60, 148, 500, 30);
        fatherNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fatherNameLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(fatherNameLabel);

        // ======================== Father Name TextField ==========================
        fatherNameField.setBounds(190, 150, 250, 30);
        fatherNameField.setBorderColor(UIUtils.RG_COLOR);
        fatherNameField.setText("Father Name");
        fatherNameField.setForeground(UIUtils.RG_COLOR);
        fatherNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fatherNameField.setMargin(new Insets(2, 5, 2, 2));
        fatherNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fatherNameField.getText().equals("Father Name")) {
                    fatherNameField.setText("");
                }
                fatherNameField.setForeground(Color.white);
                fatherNameField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fatherNameField.getText().isEmpty()) {
                    fatherNameField.setText("Father Name");
                }
                fatherNameField.setForeground(UIUtils.RG_COLOR);
                fatherNameField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(fatherNameField);

        // ========================== CNIC Label ===========================
        cnicLabel.setText("CNIC:");
        cnicLabel.setBounds(60, 188, 500, 30);
        cnicLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cnicLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(cnicLabel);

        // ========================= CNIC TextField ==========================
        cnicField.setBounds(190, 190, 250, 30);
        cnicField.setBorderColor(UIUtils.RG_COLOR);
        cnicField.setText("xxxxx-xxxxxxx-x");
        cnicField.setForeground(UIUtils.RG_COLOR);
        cnicField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cnicField.setMargin(new Insets(2, 5, 2, 2));
        cnicField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cnicField.getText().equals("xxxxx-xxxxxxx-x")) {
                    cnicField.setText("");
                }
                cnicField.setForeground(Color.white);
                cnicField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cnicField.getText().isEmpty()) {
                    cnicField.setText("xxxxx-xxxxxxx-x");
                }
                cnicField.setForeground(UIUtils.RG_COLOR);
                cnicField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(cnicField);

        // ========================== DOB Label =============================
        dobLabel.setText("DOB:");
        dobLabel.setBounds(60, 228, 500, 30);
        dobLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dobLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(dobLabel);

        // ========================= DOB TextField ==========================
        dobField.setBounds(190, 230, 250, 30);
        dobField.setBorderColor(UIUtils.RG_COLOR);
        dobField.setText("DD/MM/YYYY");
        dobField.setForeground(UIUtils.RG_COLOR);
        dobField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dobField.setMargin(new Insets(2, 5, 2, 2));
        dobField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dobField.getText().equals("DD/MM/YYYY")) {
                    dobField.setText("");
                }
                dobField.setForeground(Color.white);
                dobField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dobField.getText().isEmpty()) {
                    dobField.setText("DD/MM/YYYY");
                }
                dobField.setForeground(UIUtils.RG_COLOR);
                dobField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(dobField);

        // ========================== DOB Choser ===================================
        dateChoser.setBounds(450, 230, 50, 30);
        monthChoser.setBounds(510, 230, 80, 30);
        yearChoser.setBounds(600, 230, 60, 30);
        dateChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(UIUtils.IMAGES_PATH + "down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        monthChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(UIUtils.IMAGES_PATH + "down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        yearChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(UIUtils.IMAGES_PATH + "down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        dateChoser.addActionListener(this);
        monthChoser.addActionListener(this);
        yearChoser.addActionListener(this);
        registerPanel.add(dateChoser);
        registerPanel.add(monthChoser);
        registerPanel.add(yearChoser);

        // ======================== Gender Label =============================
        genderLabel.setText("Gender:");
        genderLabel.setBounds(60, 268, 500, 30);
        genderLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(genderLabel);

        // ========================== Gender TextField =========================
        genderField.setBounds(190, 270, 250, 30);
        genderField.setBorderColor(UIUtils.RG_COLOR);
        genderField.setText("Male/Female/Other");
        genderField.setForeground(UIUtils.RG_COLOR);
        genderField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderField.setMargin(new Insets(2, 5, 2, 2));
        genderField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (genderField.getText().equals("Male/Female/Other")) {
                    genderField.setText("");
                }
                genderField.setForeground(Color.white);
                genderField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (genderField.getText().isEmpty()) {
                    genderField.setText("Male/Female/Other");
                }
                genderField.setForeground(UIUtils.RG_COLOR);
                genderField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(genderField);

        // ========================== Gender Choser =============================
        genderChoser.setBounds(450, 270, 80, 30);
        genderChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(UIUtils.IMAGES_PATH + "down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        genderChoser.addActionListener(this);
        registerPanel.add(genderChoser);

        // ======================= Email Label ===================================
        emaiLabel.setText("Email:");
        emaiLabel.setBounds(60, 308, 500, 30);
        emaiLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emaiLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(emaiLabel);

        // ======================== Email TextField ===============================
        emailField.setBounds(190, 310, 250, 30);
        emailField.setBorderColor(UIUtils.RG_COLOR);
        emailField.setText("abc123@gmail.com");
        emailField.setForeground(UIUtils.RG_COLOR);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setMargin(new Insets(2, 5, 2, 2));
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("abc123@gmail.com")) {
                    emailField.setText("");
                }
                emailField.setForeground(Color.white);
                emailField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("abc123@gmail.com");
                }
                emailField.setForeground(UIUtils.RG_COLOR);
                emailField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(emailField);

        // ======================== Phone Number Label ============================
        phoneNumLabel.setText("Phone Number:");
        phoneNumLabel.setBounds(60, 348, 500, 30);
        phoneNumLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(phoneNumLabel);

        // ========================= Phone Number TextField =======================
        phoneNumField.setBounds(190, 350, 250, 30);
        phoneNumField.setBorderColor(UIUtils.RG_COLOR);
        phoneNumField.setText("03xx-xxxxxxx");
        phoneNumField.setForeground(UIUtils.RG_COLOR);
        phoneNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumField.setMargin(new Insets(2, 5, 2, 2));
        phoneNumField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phoneNumField.getText().equals("03xx-xxxxxxx")) {
                    phoneNumField.setText("");
                }
                phoneNumField.setForeground(Color.white);
                phoneNumField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phoneNumField.getText().isEmpty()) {
                    phoneNumField.setText("03xx-xxxxxxx");
                }
                phoneNumField.setForeground(UIUtils.RG_COLOR);
                phoneNumField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(phoneNumField);

        // ========================== Account Pin Label =============================
        accountPinLabel.setText("Account PIN:");
        accountPinLabel.setBounds(60, 388, 500, 30);
        accountPinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountPinLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(accountPinLabel);

        // ======================== Account PIN TextField ==========================
        accountPinField.setBounds(190, 390, 250, 30);
        accountPinField.setBorderColor(UIUtils.RG_COLOR);
        accountPinField.setText("PIN");
        accountPinField.setForeground(UIUtils.RG_COLOR);
        accountPinField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountPinField.setMargin(new Insets(2, 5, 2, 2));
        accountPinField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (accountPinField.getText().equals("PIN")) {
                    accountPinField.setText("");
                }
                accountPinField.setForeground(Color.white);
                accountPinField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (accountPinField.getText().isEmpty()) {
                    accountPinField.setText("PIN");
                }
                accountPinField.setForeground(UIUtils.RG_COLOR);
                accountPinField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(accountPinField);

        // ========================== Initial Deposit Label ===========================
        initialDepositLabel.setText("Initial Deposit:");
        initialDepositLabel.setBounds(60, 428, 500, 30);
        initialDepositLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        initialDepositLabel.setForeground(UIUtils.TXT_COLOR);
        registerPanel.add(initialDepositLabel);

        // ==================== Initial Deposit TextField ==========================
        initialDepositField.setBounds(190, 430, 250, 30);
        initialDepositField.setBorderColor(UIUtils.RG_COLOR);
        initialDepositField.setText("Amount");
        initialDepositField.setForeground(UIUtils.RG_COLOR);
        initialDepositField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        initialDepositField.setMargin(new Insets(2, 5, 2, 2));
        initialDepositField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (initialDepositField.getText().equals("Amount")) {
                    initialDepositField.setText("");
                }
                initialDepositField.setForeground(Color.white);
                initialDepositField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (initialDepositField.getText().isEmpty()) {
                    initialDepositField.setText("Amount");
                }
                initialDepositField.setForeground(UIUtils.RG_COLOR);
                initialDepositField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        registerPanel.add(initialDepositField);

        // =========================== Register Button =================================
        registerButton.setBounds(190, 490, 250, 44);
        registerButton.setText("REGISTER");
        registerButton.setButtonColor(UIUtils.SC_COLOR);
        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerPanel.add(registerButton);

        // ===================== SignUp Panel for the frame ==================
        registerPanel.setBackground(UIUtils.BG_COLOR);
        registerPanel.setLayout(null);
        registerPanel.setBounds(0, 0, 700, 600);
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
        registerPanel.addMouseListener(ma);
        registerPanel.addMouseMotionListener(ma);
        frame.add(registerPanel);

        // ======================= Settings for the frame =========================
        frame.setUndecorated(true);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == genderChoser) {
            genderField.setText(genderChoser.getSelectedItem().toString());

        } else if (e.getSource() == dateChoser) {
            dobField.setText(
                    "" + dateChoser.getSelectedItem().toString() + "-" + monthChoser.getSelectedItem().toString()
                            + "-" + yearChoser.getSelectedItem().toString());

        } else if (e.getSource() == monthChoser) {
            dobField.setText(
                    "" + dateChoser.getSelectedItem().toString() + "-" + monthChoser.getSelectedItem().toString()
                            + "-" + yearChoser.getSelectedItem().toString());

        } else if (e.getSource() == yearChoser) {
            dobField.setText(
                    "" + dateChoser.getSelectedItem().toString() + "-" + monthChoser.getSelectedItem().toString()
                            + "-" + yearChoser.getSelectedItem().toString());

        } else if (e.getSource() == registerButton) {

            fullname = fullNameField.getText();
            fatherName = fatherNameField.getText();
            cnic = cnicField.getText();
            dob = dobField.getText();
            gender = genderField.getText();
            email = emailField.getText();
            phoneNum = phoneNumField.getText();
            accountPin = accountPinField.getText();
            iniDeposit = initialDepositField.getText();

            if (fullname.equals("") || fullname.equals("Full Name") ||
                    fatherName.equals("") || fatherName.equals("Father Name") ||
                    cnic.equals("") || cnic.equals("xxxxx-xxxxxxx-x") ||
                    dob.equals("") || dob.equals("DD/MM/YYYY") ||
                    gender.equals("") || gender.equals("Male/Female/Other") ||
                    email.equals("") || email.equals("abc123@gmail.com") ||
                    phoneNum.equals("") || phoneNum.equals("03xx-xxxxxxx") ||
                    accountPin.equals("") || accountPin.equals("PIN") ||
                    iniDeposit.equals("") || iniDeposit.equals("Amount")) {

                frame.setEnabled(false);
                new ErrorDialogBox(frame, "All Fields are required");

            } else {

                AccountClass.account = AccountRegistration.CreateAccount(fullname, fatherName, dob, cnic, gender, email,
                        phoneNum, accountPin, Double.parseDouble(iniDeposit));
                        
                System.out.println("Registered");
                registerPanel.setVisible(false);
                AccountDetailFrame();
            }

        } else if (e.getSource() == nextButton) {

            frame.setVisible(false);
            new LoginFrame();

        }

    }

    private JLabel accountDetailLabel;
    private JLabel accountNumLabel;
    private RoundedButton nextButton;
    private JLabel userFullName;
    private JLabel userAccountNum;
    private JLabel userPIN;

    // ====================================================================
    // ========================= Account Detail Panel =====================
    // ====================================================================
    private void AccountDetailFrame() {

        accountPanel = new JPanel();
        accountDetailLabel = new JLabel();
        accountNumLabel = new JLabel();
        accountDetailSeparator = new JSeparator();
        nextButton = new RoundedButton();
        userFullName = new JLabel();
        userAccountNum = new JLabel();
        userPIN = new JLabel();

        // ==================== close button for the frame =========================
        closeButton.setText(null);
        closeButton.setBounds(605, 0, 25, 25);
        closeButton.setBackground(UIUtils.BG_COLOR);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(UIUtils.IMAGES_PATH + "close.png");
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
        accountPanel.add(closeButton);

        // ======================== Account Registration Label ====================
        accountRegLabel.setText("Account Registration");
        accountRegLabel.setBounds(45, 31, 500, 30);
        accountRegLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        accountRegLabel.setForeground(UIUtils.SC_COLOR);
        accountPanel.add(accountRegLabel);

        // ===================== Account Details Label ============================
        accountDetailLabel.setText("Account Details");
        accountDetailLabel.setBounds(50, 70, 500, 30);
        accountDetailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        accountDetailLabel.setForeground(UIUtils.RG_COLOR);
        accountPanel.add(accountDetailLabel);

        // ======================== Account Detail Seperator =======================
        accountDetailSeparator.setOrientation(SwingConstants.HORIZONTAL);
        accountDetailSeparator.setForeground(UIUtils.SP_COLOR);
        accountDetailSeparator.setBounds(167, 87, 413, 1);
        accountPanel.add(accountDetailSeparator);

        // ======================= Close Seperator ===========================
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(604, 2, 1, 21);
        accountPanel.add(closeSeparator);

        // ======================= Full Name Label =============================
        fullNameLabel.setText("Full Name:");
        fullNameLabel.setBounds(60, 108, 500, 30);
        fullNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameLabel.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(fullNameLabel);

        // ======================= Account Number Label =============================
        accountNumLabel.setText("Account Number:");
        accountNumLabel.setBounds(60, 148, 500, 30);
        accountNumLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountNumLabel.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(accountNumLabel);

        // ========================== Account Pin Label =============================
        accountPinLabel.setText("Account PIN:");
        accountPinLabel.setBounds(60, 188, 500, 30);
        accountPinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountPinLabel.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(accountPinLabel);
        ////////
        //////
        ////
        ///
        //
        //
        // ======================= Full Name Label =============================
        userFullName.setText(AccountClass.account.getfullName().toUpperCase());
        userFullName.setBounds(200, 108, 500, 30);
        userFullName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userFullName.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(userFullName);

        // ======================= Account Number Label =============================
        userAccountNum.setText(AccountClass.account.getAccountNum());
        userAccountNum.setBounds(200, 148, 500, 30);
        userAccountNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userAccountNum.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(userAccountNum);

        // ========================== Account Pin Label =============================
        userPIN.setText(AccountClass.account.getPinCode());
        userPIN.setBounds(200, 188, 500, 30);
        userPIN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userPIN.setForeground(UIUtils.TXT_COLOR);
        accountPanel.add(userPIN);

        // =========================== Next Button =================================
        nextButton.setBounds(190, 240, 250, 44);
        nextButton.setText("NEXT");
        nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);
        nextButton.setButtonColor(UIUtils.SC_COLOR);
        accountPanel.add(nextButton);

        // ===================== Account details Panel for the frame ================
        accountPanel.setBackground(UIUtils.BG_COLOR);
        accountPanel.setLayout(null);
        accountPanel.setBounds(0, 0, 630, 320);
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
        accountPanel.addMouseListener(ma);
        accountPanel.addMouseMotionListener(ma);
        frame.add(accountPanel);
        frame.setSize(630, 320);
        frame.setLocationRelativeTo(null);

    }

}
