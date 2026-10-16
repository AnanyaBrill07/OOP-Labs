import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ResortApp extends JFrame {
    //Shared polymorphic ArrayList
    public static ArrayList<AccommodationType> accommodations = new ArrayList<>();

    private CardLayout cardManager;
    private JPanel containerPanel;
    private SearchCheckoutPage searchPageRef;
    private CheckInPage checkInPageRef;

    public ResortApp() {
        setTitle("Resort Check-In System");
        setSize(850, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardManager = new CardLayout();
        containerPanel = new JPanel(cardManager);

        MainMenuPage menuPage = new MainMenuPage(this);
        checkInPageRef = new CheckInPage(this);
        searchPageRef = new SearchCheckoutPage(this);

        containerPanel.add(menuPage, "MENU");
        containerPanel.add(checkInPageRef, "CHECKIN");
        containerPanel.add(searchPageRef, "SEARCH");

        add(containerPanel);
        cardManager.show(containerPanel, "MENU");
    }

    public void showPage(String pageName) {
        if (pageName.equals("CHECKIN") && checkInPageRef != null) {
            checkInPageRef.updateDisplayArea();
        } else if (pageName.equals("SEARCH") && searchPageRef != null) {
            searchPageRef.refreshTable();
        }
        cardManager.show(containerPanel, pageName);
    }

    //1 MAINPAGE
    class MainMenuPage extends JPanel {
        public MainMenuPage(ResortApp app) {
            setLayout(new GridBagLayout());
            setBorder(new EmptyBorder(40, 40, 40, 40));
            setBackground(new Color(245, 246, 248));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; gbc.gridy = 0; gbc.insets = new Insets(0, 0, 30, 0);

            JLabel title = new JLabel("Resort Management System");
            title.setFont(new Font("SansSerif", Font.BOLD, 24));
            add(title, gbc);

            JPanel btnPanel = new JPanel(new GridLayout(3, 1, 0, 15));
            btnPanel.setOpaque(false);

            JButton btn1 = makeButton("Open Check-In / Data Entry");
            JButton btn2 = makeButton("Open Search & Check-Out");
            JButton btn3 = makeButton("Exit Application");

            btn1.addActionListener(e -> app.showPage("CHECKIN"));
            btn2.addActionListener(e -> app.showPage("SEARCH"));
            btn3.addActionListener(e -> System.exit(0));

            btnPanel.add(btn1);
            btnPanel.add(btn2);
            btnPanel.add(btn3);

            gbc.gridy = 1;
            add(btnPanel, gbc);
        }
    }

    //2 DATA ENTRY PAGE
    class CheckInPage extends JPanel {
        private JComboBox<String> typeBox;
        private JTextField txtRoom, txtGuest, txtRate, txtFloor;
        private JCheckBox chkBed, chkPool;
        private JPanel cardSubPanel;
        private JTextArea txtDisplay;

        public CheckInPage(ResortApp app) {
            setLayout(new BorderLayout(15, 15));
            setBorder(new EmptyBorder(25, 25, 25, 25));
            setBackground(Color.WHITE);

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            JLabel headLbl = new JLabel("Data Entry & Check-In");
            headLbl.setFont(new Font("SansSerif", Font.BOLD, 18));
            JButton backBtn = makeButton("Back to Menu");
            backBtn.addActionListener(e -> app.showPage("MENU"));
            top.add(headLbl, BorderLayout.WEST);
            top.add(backBtn, BorderLayout.EAST);
            add(top, BorderLayout.NORTH);

            JPanel form = new JPanel(new GridBagLayout());
            form.setOpaque(false);
            GridBagConstraints g = new GridBagConstraints();
            g.insets = new Insets(6, 6, 6, 6);
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0; g.gridy = 0;

            form.add(new JLabel("Type:"), g);
            typeBox = new JComboBox<>(new String[]{"Standard Room", "Luxury Villa"});
            g.gridx = 1;
            form.add(typeBox, g);

            g.gridx = 0; g.gridy++;
            form.add(new JLabel("Room No:"), g);
            txtRoom = new JTextField(12);
            g.gridx = 1;
            form.add(txtRoom, g);

            g.gridx = 0; g.gridy++;
            form.add(new JLabel("Guest Name:"), g);
            txtGuest = new JTextField(12);
            g.gridx = 1;
            form.add(txtGuest, g);

            g.gridx = 0; g.gridy++;
            form.add(new JLabel("Rate ($):"), g);
            txtRate = new JTextField(12);
            g.gridx = 1;
            form.add(txtRate, g);

            g.gridx = 0; g.gridy++; g.gridwidth = 2;
            cardSubPanel = new JPanel(new CardLayout());
            cardSubPanel.setOpaque(false);

            JPanel stdOpt = new JPanel(new GridLayout(2, 2, 5, 5));
            stdOpt.setOpaque(false);
            stdOpt.add(new JLabel("Floor:"));
            txtFloor = new JTextField();
            stdOpt.add(txtFloor);
            stdOpt.add(new JLabel("Extra Bed:"));
            chkBed = new JCheckBox();
            stdOpt.add(chkBed);

            JPanel villaOpt = new JPanel(new GridLayout(1, 2, 5, 5));
            villaOpt.setOpaque(false);
            villaOpt.add(new JLabel("Private Pool:"));
            chkPool = new JCheckBox();
            villaOpt.add(chkPool);

            cardSubPanel.add(stdOpt, "STD");
            cardSubPanel.add(villaOpt, "VILLA");
            form.add(cardSubPanel, g);

            typeBox.addActionListener(e -> {
                CardLayout c = (CardLayout)(cardSubPanel.getLayout());
                if (typeBox.getSelectedIndex() == 0) {
                    c.show(cardSubPanel, "STD");
                } else {
                    c.show(cardSubPanel, "VILLA");
                }
            });

            JButton submitBtn = makeButton("Complete Check-In");
            g.gridy++;
            form.add(submitBtn, g);

            add(form, BorderLayout.WEST);

            txtDisplay = new JTextArea();
            txtDisplay.setEditable(false);
            txtDisplay.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane pane = new JScrollPane(txtDisplay);
            pane.setBorder(BorderFactory.createTitledBorder("Active Accommodations List"));
            add(pane, BorderLayout.CENTER);

            submitBtn.addActionListener(e -> doCheckIn());
            updateDisplayArea();
        }

        private void doCheckIn() {
            //Exception handling for invalid malformed input
            try {
                String rNum = txtRoom.getText().trim();
                String gName = txtGuest.getText().trim();
                
                if (rNum.equals("") || gName.equals("")) {
                    JOptionPane.showMessageDialog(this, "Room number and guest name cannot be empty!");
                    return;
                }

                double rateVal = Double.parseDouble(txtRate.getText().trim());

                AccommodationType newItem;
                if (typeBox.getSelectedIndex() == 0) {
                    String floorVal = txtFloor.getText().trim();
                    boolean bedVal = chkBed.isSelected();
                    newItem = new StandardRoom(rNum, rateVal, true, gName, floorVal, bedVal);
                } else {
                    boolean poolVal = chkPool.isSelected();
                    newItem = new LuxuryVilla(rNum, rateVal, true, gName, poolVal);
                }

                accommodations.add(newItem);
                updateDisplayArea();
                JOptionPane.showMessageDialog(this, "Check-in successful!");

                txtRoom.setText("");
                txtGuest.setText("");
                txtRate.setText("");
                txtFloor.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Nightly rate must be a valid number!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void updateDisplayArea() {
            String textContent = "";
            if (accommodations.isEmpty()) {
                textContent = "No active accommodations registered.";
            } else {
                for (int i = 0; i < accommodations.size(); i++) {
                    AccommodationType item = accommodations.get(i);
                    textContent += item.getDetailedInfo() + "\n----------------------------------------\n";
                }
            }
            txtDisplay.setText(textContent);
        }
    }

    //  3SEARCH PAGE
    class SearchCheckoutPage extends JPanel {
        private JComboBox<String> searchCriteriaBox;
        private JTextField txtSearchValue;
        private JTextArea resultBox;
        private JComboBox<String> roomBox;

        public SearchCheckoutPage(ResortApp app) {
            setLayout(new BorderLayout(15, 15));
            setBorder(new EmptyBorder(25, 25, 25, 25));
            setBackground(Color.WHITE);

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            JLabel title = new JLabel("Search & Check-Out");
            title.setFont(new Font("SansSerif", Font.BOLD, 18));
            JButton backBtn = makeButton("Back to Menu");
            backBtn.addActionListener(e -> app.showPage("MENU"));
            top.add(title, BorderLayout.WEST);
            top.add(backBtn, BorderLayout.EAST);
            add(top, BorderLayout.NORTH);

            //Search panel including criterion selector, search value field, and Search button
            JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
            searchPanel.setOpaque(false);
            searchPanel.add(new JLabel("Criterion:"));
            searchCriteriaBox = new JComboBox<>(new String[]{"Room Number", "Guest Name", "Floor Level", "Has Private Pool"});
            searchPanel.add(searchCriteriaBox);

            searchPanel.add(new JLabel("Value:"));
            txtSearchValue = new JTextField(10);
            searchPanel.add(txtSearchValue);

            JButton searchBtn = makeButton("Search");
            searchPanel.add(searchBtn);

            //Check-out panel
            JPanel checkoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
            checkoutPanel.setOpaque(false);
            checkoutPanel.add(new JLabel("Room:"));
            roomBox = new JComboBox<>();
            checkoutPanel.add(roomBox);
            JButton checkoutBtn = makeButton("Process Check-Out");
            checkoutPanel.add(checkoutBtn);

            JPanel wrap = new JPanel(new BorderLayout());
            wrap.setOpaque(false);
            wrap.add(searchPanel, BorderLayout.WEST);
            wrap.add(checkoutPanel, BorderLayout.EAST);
            add(wrap, BorderLayout.CENTER);

            resultBox = new JTextArea();
            resultBox.setEditable(false);
            resultBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane pane = new JScrollPane(resultBox);
            pane.setBorder(BorderFactory.createTitledBorder("Search Results & Status List"));
            add(pane, BorderLayout.SOUTH);

            searchBtn.addActionListener(e -> performSearch());
            checkoutBtn.addActionListener(e -> doCheckout());

            refreshTable();
        }

        public void refreshTable() {
            roomBox.removeAllItems();
            String output = "";
            if (accommodations.isEmpty()) {
                output = "No accommodations available.";
            } else {
                output = "All Current Accommodations:\n\n";
                for (int i = 0; i < accommodations.size(); i++) {
                    AccommodationType a = accommodations.get(i);
                    output += a.getDetailedInfo() + "\n\n";
                    if (a.isOccupied()) {
                        roomBox.addItem(a.getRoomNumber());
                    }
                }
            }
            resultBox.setText(output);
        }

        private void performSearch() {
            String criterion = (String) searchCriteriaBox.getSelectedItem();
            String query = txtSearchValue.getText().trim().toLowerCase();
            String res = "Search Results for [" + criterion + ": " + query + "]:\n\n";
            boolean foundAny = false;

            //Polymorphic search handling both subclasses using instanceof checks
            for (int i = 0; i < accommodations.size(); i++) {
                AccommodationType a = accommodations.get(i);
                boolean match = false;

                switch (criterion) {
                    case "Room Number":
                        if (a.getRoomNumber().toLowerCase().contains(query)) {
                            match = true;
                        }
                        break;
                    case "Guest Name":
                        if (a.getGuestName().toLowerCase().contains(query)) {
                            match = true;
                        }
                        break;
                    case "Floor Level":
                        if (a instanceof StandardRoom) {
                            if (((StandardRoom) a).getFloorLevel().toLowerCase().contains(query)) {
                                match = true;
                            }
                        }
                        break;
                    case "Has Private Pool":
                        if (a instanceof LuxuryVilla) {
                            boolean pool = ((LuxuryVilla) a).hasPrivatePool();
                            if (String.valueOf(pool).contains(query)) {
                                match = true;
                            }
                        }
                        break;
                }

                if (match || query.equals("")) {
                    res += a.getDetailedInfo() + "\n\n";
                    foundAny = true;
                }
            }

            if (!foundAny) {
                res += "No matching results found.";
            }
            resultBox.setText(res);
        }

        private void doCheckout() {
            String targetRoom = (String) roomBox.getSelectedItem();
            if (targetRoom == null) {
                JOptionPane.showMessageDialog(this, "No occupied rooms available for check-out.");
                return;
            }

            boolean removed = false;
            for (int i = 0; i < accommodations.size(); i++) {
                AccommodationType a = accommodations.get(i);
                if (a.getRoomNumber().equals(targetRoom)) {
                    accommodations.remove(i);
                    removed = true;
                    break;
                }
            }

            if (removed) {
                JOptionPane.showMessageDialog(this, "Room " + targetRoom + " checked out successfully!");
                refreshTable();
                if (checkInPageRef != null) {
                    checkInPageRef.updateDisplayArea();
                }
            }
        }
    }

    private JButton makeButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btn.setBackground(new Color(230, 232, 235));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ResortApp().setVisible(true);
        });
    }
}
       
    
           
            