package view.dialog;

import table_processor.TableProcessor;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CreateDialog {

    private JDialog dialog;
    private TableProcessor tableProcessor;

    public CreateDialog(JFrame frame, TableProcessor tableProcessor) {
        this.dialog = new JDialog(frame,"Search",false);
        this.tableProcessor = tableProcessor;
        initializeDialog();
        initializeCreateDialog();
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

    private void initializeCreateDialog() {
        JPanel mainPanel   = new JPanel(new BorderLayout());
        JPanel enterPanel  = new JPanel();
        JPanel tablePanel  = new JPanel();

        JLabel surname     = new JLabel("Surname: ");
        JLabel group       = new JLabel("Group: ");

        JTextField surnameText = new JTextField(10);
        JTextField groupText   = new JTextField(10);

        JTable table = initializeTable();
        tablePanel.add(new JScrollPane(table));

        JButton addStudent = new JButton("Add new Student to Table");

        addStudent.addActionListener(e -> {
            String s = surnameText.getText();
            String g = groupText.getText();
            tableProcessor.addStudent(s,g,table.getModel());
        });

        enterPanel.add(surname);
        enterPanel.add(surnameText);
        enterPanel.add(group);
        enterPanel.add(groupText);



        mainPanel.add(enterPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(addStudent, BorderLayout.SOUTH);

        dialog.add(mainPanel);
    }

    private JTable initializeTable() {
        String columnNames[]    = { "Subject", "Mark" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 8);
        JTable table            = new JTable(model);

        return table;
    }
}
