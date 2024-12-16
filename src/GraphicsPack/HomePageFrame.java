package GraphicsPack;

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

public class HomePageFrame implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton closeButton;
    private static JSeparator closeSeparator;
    private static JPanel dashboardPanel;
    private static JLabel pageLabel;
    private static JLabel accountTitleLabel;
    private static JLabel accountHolderLabel;
    private static JLabel currentBalanceLabel;
    private static JLabel amountLabel;
    private static RoundedButton dashboardButton;
    private static RoundedButton accountDetailsButton;
    private static RoundedButton signOutButton;
    private static RoundedButton cashDepositButton;
    private static RoundedButton cashWithdrawlButton;
    private static RoundedButton cashDepositButton2;
    private static RoundedButton transferAmount;
    private static RoundedButton pinChangeButton;
    private static JSeparator separator;

    public HomePageFrame() {

        frame = new JFrame();
        panel = new JPanel();
        closeButton = new JButton();
        closeSeparator = new JSeparator();
        dashboardPanel = new JPanel();
        pageLabel = new JLabel();
        accountHolderLabel = new JLabel();
        accountTitleLabel = new JLabel();
        currentBalanceLabel = new JLabel();
        amountLabel = new JLabel();
        dashboardButton = new RoundedButton();
        accountDetailsButton = new RoundedButton();
        signOutButton = new RoundedButton();
        cashDepositButton = new RoundedButton();
        cashWithdrawlButton = new RoundedButton();
        cashDepositButton2 = new RoundedButton();
        transferAmount = new RoundedButton();
        pinChangeButton = new RoundedButton();
        separator = new JSeparator();

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

        // -------------------- Close Seperator -----------------------------------
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(774, 2, 1, 21);
        panel.add(closeSeparator);

        // --------------------- Page Label -----------------------
        pageLabel.setText("Dashboard");
        pageLabel.setBounds(58, 50, 500, 30);
        pageLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pageLabel.setForeground(UIUtils.BG_COLOR);
        dashboardPanel.add(pageLabel);

        // -------------------- Dashboard Button ----------------------------------
        dashboardButton.setText("Dashboard");
        dashboardButton.setBounds(35, 205, 150, 30);
        dashboardButton.setFocusable(false);
        dashboardButton.setButtonColor(UIUtils.BG_COLOR);
        dashboardButton.setForeground(UIUtils.TXT_COLOR);
        dashboardButton.addActionListener(this);
        dashboardPanel.add(dashboardButton);

        // ------------------ Account Details Button ------------------------------
        accountDetailsButton.setText("Account Details");
        accountDetailsButton.setBounds(35, 285, 150, 30);
        accountDetailsButton.setFocusable(false);
        accountDetailsButton.setButtonColor(UIUtils.BG_COLOR);
        accountDetailsButton.setForeground(UIUtils.TXT_COLOR);
        accountDetailsButton.addActionListener(this);
        dashboardPanel.add(accountDetailsButton);

        // -------------------- SignOut Button ------------------------------------
        signOutButton.setText("SignOut");
        signOutButton.setBounds(35, 365, 150, 30);
        signOutButton.setFocusable(false);
        signOutButton.setButtonColor(UIUtils.BG_COLOR);
        signOutButton.setForeground(UIUtils.TXT_COLOR);
        signOutButton.addActionListener(this);
        dashboardPanel.add(signOutButton);

        // -------------------- Seperator -----------------------------------------
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setForeground(UIUtils.SP_COLOR);
        separator.setBounds(240, 180, 540, 1);
        panel.add(separator);

        // --------------------- Account Title Label -----------------------
        accountTitleLabel.setText("Account Title");
        accountTitleLabel.setBounds(250, 30, 500, 30);
        accountTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        accountTitleLabel.setForeground(UIUtils.RG_COLOR);
        panel.add(accountTitleLabel);

        // -------------------- Account Holder Name Label -----------------------
        accountHolderLabel.setText(AccountClass.account.getfullName().toUpperCase());
        accountHolderLabel.setBounds(250, 50, 500, 30);
        accountHolderLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
        accountHolderLabel.setForeground(UIUtils.TXT_COLOR);
        panel.add(accountHolderLabel);

        // -------------------- Current Balance Label -----------------------
        currentBalanceLabel.setText("Current Balance");
        currentBalanceLabel.setBounds(250, 100, 500, 30);
        currentBalanceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        currentBalanceLabel.setForeground(UIUtils.RG_COLOR);
        panel.add(currentBalanceLabel);

        // -------------------- Amount Label -----------------------
        amountLabel.setText("Rs " + AccountClass.account.getBalance());
        amountLabel.setBounds(250, 125, 500, 30);
        amountLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        amountLabel.setForeground(UIUtils.TXT_COLOR);
        panel.add(amountLabel);

        // -------------------- Cash Deposit Button ------------------------------------
        cashDepositButton.setText("Deposit Amount");
        cashDepositButton.setBounds(600, 125, 150, 30);
        cashDepositButton.setFocusable(false);
        cashDepositButton.addActionListener(this);
        cashDepositButton.setButtonColor(UIUtils.SC_COLOR);
        cashDepositButton.setForeground(UIUtils.BG_COLOR);
        panel.add(cashDepositButton);

        // ------------------ Cash Deposit 2 Button ------------------------------------
        cashDepositButton2.setText("<html><font size='4'>Deposit Amount</font></html>");
        ImageIcon depositIcon = new ImageIcon(".\\Images\\deposit.png");
        cashDepositButton2.setIcon(depositIcon);
        cashDepositButton2.setIconTextGap(20);
        cashDepositButton2.setBounds(265, 230, 230, 65);
        cashDepositButton2.setButtonRoundness(30);
        cashDepositButton2.setFocusable(false);
        cashDepositButton2.addActionListener(this);
        cashDepositButton2.setButtonColor(UIUtils.SC_COLOR);
        cashDepositButton2.setForeground(UIUtils.BG_COLOR);
        panel.add(cashDepositButton2);

        // ------------------ Cash Withdrawl Button ------------------------------------
        cashWithdrawlButton.setText("<html><font size='4'>Withdraw Amount</font></html>");
        ImageIcon withdrawIcon = new ImageIcon(".\\Images\\withdraw.png");
        cashWithdrawlButton.setIcon(withdrawIcon);
        cashWithdrawlButton.setIconTextGap(20);
        cashWithdrawlButton.setBounds(525, 230, 230, 65);
        cashWithdrawlButton.setButtonRoundness(30);
        cashWithdrawlButton.setFocusable(false);
        cashWithdrawlButton.addActionListener(this);
        cashWithdrawlButton.setButtonColor(UIUtils.SC_COLOR);
        cashWithdrawlButton.setForeground(UIUtils.BG_COLOR);
        panel.add(cashWithdrawlButton);

        // ------------------ Tansfer Amount Button ------------------------------------
        transferAmount.setText("<html><font size='4'>Transfer Amount</font></html>");
        ImageIcon transferIcon = new ImageIcon(".\\Images\\transfer.png");
        transferAmount.setIcon(transferIcon);
        transferAmount.setIconTextGap(20);
        transferAmount.setBounds(265, 320, 230, 65);
        transferAmount.setButtonRoundness(30);
        transferAmount.setFocusable(false);
        transferAmount.addActionListener(this);
        transferAmount.setButtonColor(UIUtils.SC_COLOR);
        transferAmount.setForeground(UIUtils.BG_COLOR);
        panel.add(transferAmount);

        // ------------------ Pin Change Button ------------------------------------
        pinChangeButton.setText("<html><font size='4'>Pin Change</font></html>");
        ImageIcon pinChangeIcon = new ImageIcon(".\\Images\\pinChange.png");
        pinChangeButton.setIcon(pinChangeIcon);
        pinChangeButton.setIconTextGap(20);
        pinChangeButton.setBounds(525, 320, 230, 65);
        pinChangeButton.setButtonRoundness(30);
        pinChangeButton.setFocusable(false);
        pinChangeButton.addActionListener(this);
        pinChangeButton.setButtonColor(UIUtils.SC_COLOR);
        pinChangeButton.setForeground(UIUtils.BG_COLOR);
        panel.add(pinChangeButton);

        // -------------------- Dashboard Panel for the frame ---------------------
        dashboardPanel.setBounds(0, 0, 220, 600);
        dashboardPanel.setBackground(UIUtils.SC_COLOR);
        dashboardPanel.setLayout(null);
        frame.add(dashboardPanel);

        // -------------------- Bg Panel for the frame ----------------------------
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
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    private static JPanel PDpanel;
    private static JLabel accountDetailLabel;
    private static JSeparator accountDetailSeparator;
    private static JLabel fullNameLabel;
    private static JLabel fatherNameLabel;
    private static JLabel cnicLabel;
    private static JLabel dobLabel;
    private static JLabel genderLabel;
    private static JLabel emaiLabel;
    private static JLabel phoneNumLabel;
    private static JLabel accountNumLabel;
    private static JLabel accountPinLabel;
    private static JLabel fullNameText;
    private static JLabel fatherNameText;
    private static JLabel cnicText;
    private static JLabel dobText;
    private static JLabel genderText;
    private static JLabel emailText;
    private static JLabel phoneNumText;
    private static JLabel accountNumText;
    private static JLabel accountPinText;
    private static RoundedButton editInfoButton;

    private void PersonalDetailFrame() {

        PDpanel = new JPanel();
        accountDetailLabel = new JLabel();
        accountDetailSeparator = new JSeparator();
        fullNameLabel = new JLabel();
        fatherNameLabel = new JLabel();
        cnicLabel = new JLabel();
        dobLabel = new JLabel();
        genderLabel = new JLabel();
        emaiLabel = new JLabel();
        phoneNumLabel = new JLabel();
        accountNumLabel = new JLabel();
        accountPinLabel = new JLabel();
        fullNameText = new JLabel();
        fatherNameText = new JLabel();
        cnicText = new JLabel();
        dobText = new JLabel();
        genderText = new JLabel();
        emailText = new JLabel();
        phoneNumText = new JLabel();
        accountNumText = new JLabel();
        accountPinText = new JLabel();
        editInfoButton = new RoundedButton();

        // --------------------- Account Registration Label ----------------------
        accountDetailLabel.setText("Account Information");
        accountDetailLabel.setBounds(264, 35, 500, 30);
        accountDetailLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        accountDetailLabel.setForeground(UIUtils.SC_COLOR);
        PDpanel.add(accountDetailLabel);

        // -------------------- Account Detail Seperator --------------------------
        accountDetailSeparator.setOrientation(SwingConstants.HORIZONTAL);
        accountDetailSeparator.setForeground(UIUtils.SP_COLOR);
        accountDetailSeparator.setBounds(255, 87, 510, 1);
        PDpanel.add(accountDetailSeparator);

        // ======================= Full Name Label =============================
        fullNameLabel.setText("Full Name:");
        fullNameLabel.setBounds(260, 110, 500, 30);
        fullNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        fullNameLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(fullNameLabel);

        // ========================== Father Name Label =============================
        fatherNameLabel.setText("Father Name:");
        fatherNameLabel.setBounds(260, 150, 500, 30);
        fatherNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        fatherNameLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(fatherNameLabel);

        // ========================== CNIC Label ===========================
        cnicLabel.setText("CNIC:");
        cnicLabel.setBounds(260, 190, 500, 30);
        cnicLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cnicLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(cnicLabel);

        // ========================== DOB Label =============================
        dobLabel.setText("DOB:");
        dobLabel.setBounds(260, 230, 500, 30);
        dobLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dobLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(dobLabel);

        // ======================== Gender Label =============================
        genderLabel.setText("Gender:");
        genderLabel.setBounds(260, 270, 500, 30);
        genderLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        genderLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(genderLabel);

        // ======================= Email Label ===================================
        emaiLabel.setText("Email:");
        emaiLabel.setBounds(260, 310, 500, 30);
        emaiLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emaiLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(emaiLabel);

        // ======================== Phone Number Label ============================
        phoneNumLabel.setText("Phone Number:");
        phoneNumLabel.setBounds(260, 350, 500, 30);
        phoneNumLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        phoneNumLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(phoneNumLabel);

        // ========================== Account Num Label =============================
        accountNumLabel.setText("Account Number:");
        accountNumLabel.setBounds(260, 390, 500, 30);
        accountNumLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accountNumLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(accountNumLabel);

        // ========================== Account Pin Label =============================
        accountPinLabel.setText("Account PIN:");
        accountPinLabel.setBounds(260, 430, 500, 30);
        accountPinLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accountPinLabel.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(accountPinLabel);

        // ========================== Full Name Text =============================
        fullNameText.setText(AccountClass.account.getfullName());
        fullNameText.setBounds(420, 110, 500, 30);
        fullNameText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(fullNameText);

        // ========================== Father Name Text =============================
        fatherNameText.setText(AccountClass.account.getfatherName());
        fatherNameText.setBounds(420, 150, 500, 30);
        fatherNameText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fatherNameText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(fatherNameText);

        // ========================== CNIC Text =============================
        cnicText.setText(AccountClass.account.getCNIC());
        cnicText.setBounds(420, 190, 500, 30);
        cnicText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cnicText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(cnicText);

        // ========================== DOB Text =============================
        dobText.setText(AccountClass.account.getDOB());
        dobText.setBounds(420, 230, 500, 30);
        dobText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dobText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(dobText);

        // ========================== Gender Text =============================
        genderText.setText(AccountClass.account.getGender().toUpperCase());
        genderText.setBounds(420, 270, 500, 30);
        genderText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(genderText);

        // ========================== Email Text =============================
        emailText.setText(AccountClass.account.getEmail());
        emailText.setBounds(420, 310, 500, 30);
        emailText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(emailText);

        // ========================== Phone Number Text =============================
        phoneNumText.setText(AccountClass.account.getPhoneNum());
        phoneNumText.setBounds(420, 350, 500, 30);
        phoneNumText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(phoneNumText);

        // ========================== Account Number Text =============================
        accountNumText.setText(AccountClass.account.getAccountNum());
        accountNumText.setBounds(420, 390, 500, 30);
        accountNumText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountNumText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(accountNumText);

        // ========================== Account PIN Text =============================
        accountPinText.setText(
                AccountClass.account.getPinCode().charAt(0) + "xx" + AccountClass.account.getPinCode().charAt(3));
        accountPinText.setBounds(420, 430, 500, 30);
        accountPinText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountPinText.setForeground(UIUtils.TXT_COLOR);
        PDpanel.add(accountPinText);

        // =========================== Edit Info Button =============================
        editInfoButton.setBounds(660, 510, 100, 44);
        editInfoButton.setText("Edit");
        editInfoButton.setButtonColor(UIUtils.SC_COLOR);
        editInfoButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        editInfoButton.setFocusable(false);
        editInfoButton.addActionListener(this);
        PDpanel.add(editInfoButton);

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
        PDpanel.add(closeButton);

        // -------------------- Close Seperator -----------------------------------
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(774, 2, 1, 21);
        PDpanel.add(closeSeparator);

        // --------------------- Page Label -----------------------
        pageLabel.setText("Account Details");
        pageLabel.setBounds(39, 50, 500, 30);
        pageLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pageLabel.setForeground(UIUtils.BG_COLOR);
        dashboardPanel.add(pageLabel);

        // -------------------- Dashboard Button ----------------------------------
        dashboardButton.setText("Dashboard");
        dashboardButton.setBounds(35, 205, 150, 30);
        dashboardButton.setFocusable(false);
        dashboardButton.setButtonColor(UIUtils.BG_COLOR);
        dashboardButton.addActionListener(this);
        dashboardButton.setForeground(UIUtils.TXT_COLOR);
        dashboardPanel.add(dashboardButton);

        // ------------------ Account Details Button ------------------------------
        accountDetailsButton.setText("Account Details");
        accountDetailsButton.setBounds(35, 285, 150, 30);
        accountDetailsButton.setFocusable(false);
        accountDetailsButton.setButtonColor(UIUtils.BG_COLOR);
        accountDetailsButton.setForeground(UIUtils.TXT_COLOR);
        accountDetailsButton.addActionListener(this);
        dashboardPanel.add(accountDetailsButton);

        // -------------------- SignOut Button ------------------------------------
        signOutButton.setText("SignOut");
        signOutButton.setBounds(35, 365, 150, 30);
        signOutButton.setFocusable(false);
        signOutButton.setButtonColor(UIUtils.BG_COLOR);
        signOutButton.setForeground(UIUtils.TXT_COLOR);
        signOutButton.addActionListener(this);
        dashboardPanel.add(signOutButton);

        // -------------------- Dashboard Panel for the frame ---------------------
        dashboardPanel.setBounds(0, 0, 220, 600);
        dashboardPanel.setBackground(UIUtils.SC_COLOR);
        dashboardPanel.setLayout(null);
        frame.add(dashboardPanel);

        // -------------------- Bg Panel for the frame ----------------------------
        PDpanel.setBackground(UIUtils.BG_COLOR);
        PDpanel.setLayout(null);
        PDpanel.setBounds(0, 0, 800, 600);
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
        PDpanel.addMouseListener(ma);
        PDpanel.addMouseMotionListener(ma);
        frame.add(PDpanel);
        frame.setSize(800, 600);

    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    private static JPanel PDeditPanel;
    private static JLabel accountDetailEditLabel;
    private static RoundedButton continueButton;
    private static TextField fullNameField;
    private static TextField fatherNameField;
    private static TextField cnicField;
    private static TextField dobField;
    private static TextField genderField;
    private static TextField emailField;
    private static TextField phoneNumField;
    private static JComboBox<String> dateChoser;
    private static JComboBox<String> monthChoser;
    private static JComboBox<String> yearChoser;
    private static JComboBox<String> genderChoser;

    // input variables
    private String fullName;
    private String fatherName;
    private String cnic;
    private String dob;
    private String gender;
    private String email;
    private String phoneNum;

    String[] dates = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    String[] years = new String[100];
    String[] genders = { "Male", "Female", "Other" };

    private void PersonalDetailEditFrame() {

        for (int i = 0; i < 100; i++) {
            years[i] = "" + (2006 - i);
        }

        PDeditPanel = new JPanel();
        accountDetailEditLabel = new JLabel();
        accountDetailSeparator = new JSeparator();
        fullNameLabel = new JLabel();
        fatherNameLabel = new JLabel();
        cnicLabel = new JLabel();
        dobLabel = new JLabel();
        genderLabel = new JLabel();
        emaiLabel = new JLabel();
        phoneNumLabel = new JLabel();
        accountNumLabel = new JLabel();
        accountPinLabel = new JLabel();
        fullNameField = new TextField();
        fatherNameField = new TextField();
        cnicField = new TextField();
        dobField = new TextField();
        genderField = new TextField();
        emailField = new TextField();
        phoneNumField = new TextField();
        continueButton = new RoundedButton();
        dateChoser = new JComboBox<String>(dates);
        monthChoser = new JComboBox<String>(months);
        yearChoser = new JComboBox<String>(years);
        genderChoser = new JComboBox<String>(genders);

        // --------------------- Edit Account Label ----------------------
        accountDetailEditLabel.setText("Edit Account Information");
        accountDetailEditLabel.setBounds(264, 35, 500, 30);
        accountDetailEditLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        accountDetailEditLabel.setForeground(UIUtils.SC_COLOR);
        PDeditPanel.add(accountDetailEditLabel);

        // -------------------- Account Detail Seperator --------------------------
        accountDetailSeparator.setOrientation(SwingConstants.HORIZONTAL);
        accountDetailSeparator.setForeground(UIUtils.SP_COLOR);
        accountDetailSeparator.setBounds(255, 87, 630, 1);
        PDeditPanel.add(accountDetailSeparator);

        // ======================= Full Name Label =============================
        fullNameLabel.setText("Full Name:");
        fullNameLabel.setBounds(260, 110, 500, 30);
        fullNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        fullNameLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(fullNameLabel);

        // ========================== Father Name Label =============================
        fatherNameLabel.setText("Father Name:");
        fatherNameLabel.setBounds(260, 150, 500, 30);
        fatherNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        fatherNameLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(fatherNameLabel);

        // ========================== CNIC Label ===========================
        cnicLabel.setText("CNIC:");
        cnicLabel.setBounds(260, 190, 500, 30);
        cnicLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cnicLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(cnicLabel);

        // ========================== DOB Label =============================
        dobLabel.setText("DOB:");
        dobLabel.setBounds(260, 230, 500, 30);
        dobLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dobLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(dobLabel);

        // ======================== Gender Label =============================
        genderLabel.setText("Gender:");
        genderLabel.setBounds(260, 270, 500, 30);
        genderLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        genderLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(genderLabel);

        // ======================= Email Label ===================================
        emaiLabel.setText("Email:");
        emaiLabel.setBounds(260, 310, 500, 30);
        emaiLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emaiLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(emaiLabel);

        // ======================== Phone Number Label ============================
        phoneNumLabel.setText("Phone Number:");
        phoneNumLabel.setBounds(260, 350, 500, 30);
        phoneNumLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        phoneNumLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(phoneNumLabel);

        // ========================== Account Num Label =============================
        accountNumLabel.setText("Account Number:");
        accountNumLabel.setBounds(260, 390, 500, 30);
        accountNumLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accountNumLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(accountNumLabel);

        // ========================== Account Pin Label =============================
        accountPinLabel.setText("Account PIN:");
        accountPinLabel.setBounds(260, 430, 500, 30);
        accountPinLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accountPinLabel.setForeground(UIUtils.TXT_COLOR);
        PDeditPanel.add(accountPinLabel);

        // ======================== Fullname TextField =========================
        fullNameField.setBounds(420, 110, 250, 30);
        fullNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameField.setMargin(new Insets(2, 5, 2, 2));
        fullNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fullNameField.getText().equals(AccountClass.account.getfullName())) {
                    fullNameField.setText("");
                }
                fullNameField.setForeground(Color.white);
                fullNameField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fullNameField.getText().isEmpty()) {
                    fullNameField.setText(AccountClass.account.getfullName());
                }
                fullNameField.setForeground(UIUtils.RG_COLOR);
                fullNameField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(fullNameField);

        // ======================== Father Name TextField ==========================
        fatherNameField.setBounds(420, 150, 250, 30);
        fatherNameField.setBorderColor(UIUtils.RG_COLOR);
        fatherNameField.setText(AccountClass.account.getfatherName());
        fatherNameField.setForeground(UIUtils.RG_COLOR);
        fatherNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fatherNameField.setMargin(new Insets(2, 5, 2, 2));
        fatherNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fatherNameField.getText().equals(AccountClass.account.getfatherName())) {
                    fatherNameField.setText("");
                }
                fatherNameField.setForeground(Color.white);
                fatherNameField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fatherNameField.getText().isEmpty()) {
                    fatherNameField.setText(AccountClass.account.getfatherName());
                }
                fatherNameField.setForeground(UIUtils.RG_COLOR);
                fatherNameField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(fatherNameField);

        // ========================= CNIC TextField ==========================
        cnicField.setBounds(420, 190, 250, 30);
        cnicField.setBorderColor(UIUtils.RG_COLOR);
        cnicField.setText(AccountClass.account.getCNIC());
        cnicField.setForeground(UIUtils.RG_COLOR);
        cnicField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cnicField.setMargin(new Insets(2, 5, 2, 2));
        cnicField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cnicField.getText().equals(AccountClass.account.getCNIC())) {
                    cnicField.setText("");
                }
                cnicField.setForeground(Color.white);
                cnicField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cnicField.getText().isEmpty()) {
                    cnicField.setText(AccountClass.account.getCNIC());
                }
                cnicField.setForeground(UIUtils.RG_COLOR);
                cnicField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(cnicField);

        // ========================= DOB TextField ==========================
        dobField.setBounds(420, 230, 250, 30);
        dobField.setBorderColor(UIUtils.RG_COLOR);
        dobField.setText(AccountClass.account.getDOB());
        dobField.setForeground(UIUtils.RG_COLOR);
        dobField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dobField.setMargin(new Insets(2, 5, 2, 2));
        dobField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dobField.getText().equals(AccountClass.account.getDOB())) {
                    dobField.setText("");
                }
                dobField.setForeground(Color.white);
                dobField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dobField.getText().isEmpty()) {
                    dobField.setText(AccountClass.account.getDOB());
                }
                dobField.setForeground(UIUtils.RG_COLOR);
                dobField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(dobField);

        // ========================== DOB Choser ===================================
        dateChoser.setBounds(680, 230, 50, 30);
        monthChoser.setBounds(740, 230, 80, 30);
        yearChoser.setBounds(830, 230, 60, 30);
        dateChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(".\\Images\\down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        monthChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(".\\Images\\down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        yearChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(".\\Images\\down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        dateChoser.addActionListener(this);
        monthChoser.addActionListener(this);
        yearChoser.addActionListener(this);
        PDeditPanel.add(dateChoser);
        PDeditPanel.add(monthChoser);
        PDeditPanel.add(yearChoser);

        // ========================== Gender TextField =========================
        genderField.setBounds(420, 270, 250, 30);
        genderField.setBorderColor(UIUtils.RG_COLOR);
        genderField.setText(AccountClass.account.getGender());
        genderField.setForeground(UIUtils.RG_COLOR);
        genderField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderField.setMargin(new Insets(2, 5, 2, 2));
        genderField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (genderField.getText().equals(AccountClass.account.getGender())) {
                    genderField.setText("");
                }
                genderField.setForeground(Color.white);
                genderField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (genderField.getText().isEmpty()) {
                    genderField.setText(AccountClass.account.getGender());
                }
                genderField.setForeground(UIUtils.RG_COLOR);
                genderField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(genderField);

        // ========================== Gender Choser =============================
        genderChoser.setBounds(680, 270, 80, 30);
        genderChoser.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(".\\Images\\down_arrow.png"));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        genderChoser.addActionListener(this);
        PDeditPanel.add(genderChoser);

        // ======================== Email TextField ===============================
        emailField.setBounds(420, 310, 250, 30);
        emailField.setBorderColor(UIUtils.RG_COLOR);
        emailField.setText(AccountClass.account.getEmail());
        emailField.setForeground(UIUtils.RG_COLOR);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setMargin(new Insets(2, 5, 2, 2));
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals(AccountClass.account.getEmail())) {
                    emailField.setText("");
                }
                emailField.setForeground(Color.white);
                emailField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText(AccountClass.account.getEmail());
                }
                emailField.setForeground(UIUtils.RG_COLOR);
                emailField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(emailField);

        // ========================= Phone Number TextField =======================
        phoneNumField.setBounds(420, 350, 250, 30);
        phoneNumField.setBorderColor(UIUtils.RG_COLOR);
        phoneNumField.setText(AccountClass.account.getPhoneNum());
        phoneNumField.setForeground(UIUtils.RG_COLOR);
        phoneNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumField.setMargin(new Insets(2, 5, 2, 2));
        phoneNumField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phoneNumField.getText().equals(AccountClass.account.getPhoneNum())) {
                    phoneNumField.setText("");
                }
                phoneNumField.setForeground(Color.white);
                phoneNumField.setBorderColor(UIUtils.SC_COLOR);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phoneNumField.getText().isEmpty()) {
                    phoneNumField.setText(AccountClass.account.getPhoneNum());
                }
                phoneNumField.setForeground(UIUtils.RG_COLOR);
                phoneNumField.setBorderColor(UIUtils.RG_COLOR);
            }
        });
        PDeditPanel.add(phoneNumField);

        // =========================== Continue Button =============================
        continueButton.setBounds(780, 510, 100, 44);
        continueButton.setText("Continue");
        continueButton.setButtonColor(UIUtils.SC_COLOR);
        continueButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        continueButton.setFocusable(false);
        continueButton.addActionListener(this);
        PDeditPanel.add(continueButton);

        // -------------------- close button for the frame --------------------
        closeButton.setText(null);
        closeButton.setBounds(895, 0, 25, 25);
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
        PDeditPanel.add(closeButton);

        // -------------------- Close Seperator -----------------------------------
        closeSeparator.setOrientation(SwingConstants.VERTICAL);
        closeSeparator.setForeground(UIUtils.SP_COLOR);
        closeSeparator.setBounds(894, 2, 1, 21);
        PDeditPanel.add(closeSeparator);

        // --------------------- Page Label -----------------------
        pageLabel.setText("Account Details");
        pageLabel.setBounds(39, 50, 500, 30);
        pageLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pageLabel.setForeground(UIUtils.BG_COLOR);
        dashboardPanel.add(pageLabel);

        // -------------------- Dashboard Button ----------------------------------
        dashboardButton.setText("Dashboard");
        dashboardButton.setBounds(35, 205, 150, 30);
        dashboardButton.setFocusable(false);
        dashboardButton.setButtonColor(UIUtils.BG_COLOR);
        dashboardButton.setForeground(UIUtils.TXT_COLOR);
        dashboardButton.addActionListener(this);
        dashboardPanel.add(dashboardButton);

        // ------------------ Account Details Button ------------------------------
        accountDetailsButton.setText("Account Details");
        accountDetailsButton.setBounds(35, 285, 150, 30);
        accountDetailsButton.setFocusable(false);
        accountDetailsButton.setButtonColor(UIUtils.BG_COLOR);
        accountDetailsButton.setForeground(UIUtils.TXT_COLOR);
        accountDetailsButton.addActionListener(this);
        dashboardPanel.add(accountDetailsButton);

        // -------------------- SignOut Button ------------------------------------
        signOutButton.setText("SignOut");
        signOutButton.setBounds(35, 365, 150, 30);
        signOutButton.setFocusable(false);
        signOutButton.setButtonColor(UIUtils.BG_COLOR);
        signOutButton.setForeground(UIUtils.TXT_COLOR);
        signOutButton.addActionListener(this);
        dashboardPanel.add(signOutButton);

        // -------------------- Dashboard Panel for the frame ---------------------
        dashboardPanel.setBounds(0, 0, 220, 600);
        dashboardPanel.setBackground(UIUtils.SC_COLOR);
        dashboardPanel.setLayout(null);
        frame.add(dashboardPanel);

        // -------------------- Bg Panel for the frame ----------------------------
        PDeditPanel.setBackground(UIUtils.BG_COLOR);
        PDeditPanel.setLayout(null);
        PDeditPanel.setBounds(0, 0, 1000, 600);
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
        PDeditPanel.addMouseListener(ma);
        PDeditPanel.addMouseMotionListener(ma);
        frame.add(PDeditPanel);

        frame.setSize(920, 600);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == accountDetailsButton) {

            panel.setVisible(false);
            PersonalDetailFrame();

        } else if (e.getSource() == editInfoButton) {

            PDpanel.setVisible(false);
            PersonalDetailEditFrame();

        } else if (e.getSource() == continueButton) {

            fullName = fullNameField.getText();
            fatherName = fatherNameField.getText();
            cnic = cnicField.getText();
            dob = dobField.getText();
            gender = genderField.getText();
            email = emailField.getText();
            phoneNum = phoneNumField.getText();

            AccountClass.account.UpdateUser(AccountClass.account.getAccountNum(), fullName, fatherName, dob, cnic,
                    gender, email, phoneNum);

            PDeditPanel.setVisible(false);
            PersonalDetailFrame();

        } else if (e.getSource() == signOutButton) {

            frame.setVisible(false);
            new LoginFrame();

        } else if (e.getSource() == dashboardButton) {

            frame.setVisible(false);
            new HomePageFrame();

        } else if (e.getSource() == cashDepositButton || e.getSource() == cashDepositButton2) {

            frame.setVisible(false);
            new DepositFrame();

        } else if (e.getSource() == cashWithdrawlButton) {

            frame.setVisible(false);
            new WithdrawFrame();

        } else if (e.getSource() == pinChangeButton) {

            frame.setVisible(false);
            new PinChangeFrame();

        } else if (e.getSource() == transferAmount) {

            frame.setVisible(false);
            new TransferFrame();

        } else if (e.getSource() == genderChoser) {

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
        }

    }

}
