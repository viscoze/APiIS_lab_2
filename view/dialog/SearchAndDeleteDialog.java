package view.dialog;

import table_processor.TableProcessor;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class SearchAndDeleteDialog {

    private JDialog dialog;
    private TableProcessor tableProcessor;

    public SearchAndDeleteDialog(JFrame frame, TableProcessor tableProcessor) {
        this.dialog = new JDialog(frame,"Search",false);
        this.tableProcessor = tableProcessor;
        initializeDialog();
        initializeSearchAndDeleteDialog();
    }

    public JDialog getDialog() {
        dialog.setVisible(true);
        return dialog;
    }

    private void initializeDialog() {
        dialog.setSize(512,368);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
    }

    private void  initializeSearchAndDeleteDialog() {
        JPanel mainPanel       = new JPanel(new CardLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        String[] tabsNames     = { "Surname and group","Surname and subject mark","Surname and exam mark" };

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder("Choose the task"));

        ArrayList<JPanel> panels = getAllPanels();

        for(int indexOfTabsName = 0; indexOfTabsName < 3; indexOfTabsName++)
            tabbedPane.addTab(tabsNames[indexOfTabsName], panels.get(indexOfTabsName));

        mainPanel.add(tabbedPane);
        dialog.add(mainPanel);
    }

    private JPanel createSurnameAverageMarkPanel() {
        JPanel mainPanel   = new JPanel(new BorderLayout());
        JPanel enterPanel  = new JPanel();
        JPanel resultPanel = new JPanel();

        JLabel surname     = new JLabel("Surname: ");
        JLabel averageMark = new JLabel("Exam Mark: ");

        JTextField surnameText    = new JTextField(10);
        JTextField averageMarkMin = new JTextField(3);
        JTextField averageMarkMax = new JTextField(3);

        JButton search = new JButton("Search ->");
        JButton delete = new JButton("Delete");

        enterPanel.add(surname);
        enterPanel.add(surnameText);
        enterPanel.add(averageMark);
        enterPanel.add(averageMarkMin);
        enterPanel.add(averageMarkMax);
        enterPanel.add(search);

        mainPanel.add(enterPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(delete, BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel createSurnameAndGroupPanel() {
        JPanel mainPanel     = new JPanel(new BorderLayout());
        JPanel enterPanel    = new JPanel();
        JPanel resultPanel   = new JPanel();

        JLabel surname     = new JLabel("Surname: ");
        JLabel group       = new JLabel("Group:  ");

        JTextField surnameText    = new JTextField(10);
        JTextField groupText = new JTextField(10);

        JButton search = new JButton("Search ->");
        JButton delete = new JButton("Delete");

        search.addActionListener(e -> {
            String s  = surnameText.getText();
            Integer g = Integer.parseInt(surnameText.getText());
            tableProcessor.setPanel(resultPanel);
            tableProcessor.search(s,g);
        });

        enterPanel.add(surname);
        enterPanel.add(surnameText);
        enterPanel.add(group);
        enterPanel.add(groupText);
        enterPanel.add(search);

        mainPanel.add(enterPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(delete, BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel createSurnameAndMarkPanel() {
        JPanel mainPanel     = new JPanel(new BorderLayout());
        JPanel enterPanel    = new JPanel();
        JPanel resultPanel   = new JPanel();

        JLabel surname     = new JLabel("Surname: ");
        JLabel averageMark = new JLabel("Subject Mark: ");

        JTextField surnameText    = new JTextField(10);
        JTextField averageMarkMin = new JTextField(3);
        JTextField averageMarkMax = new JTextField(3);

        JButton search = new JButton("Search ->");
        JButton delete = new JButton("Delete");

        enterPanel.add(surname);
        enterPanel.add(surnameText);
        enterPanel.add(averageMark);
        enterPanel.add(averageMarkMin);
        enterPanel.add(averageMarkMax);
        enterPanel.add(search);

        mainPanel.add(enterPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(delete, BorderLayout.SOUTH);

        return mainPanel;
    }

    private ArrayList<JPanel> getAllPanels() {
        ArrayList<JPanel> panels = new ArrayList<>();

        panels.add(createSurnameAndGroupPanel());
        panels.add(createSurnameAndMarkPanel());
        panels.add(createSurnameAverageMarkPanel());

        return panels;
    }
}
