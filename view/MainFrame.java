package view;

import view.dialog.CreateDialog;
import view.dialog.SearchAndDeleteDialog;

import java.awt.*;
import javax.swing.*;

public class MainFrame {

    private JFrame frame;
    private HTMLTablePanel helperHTML;

    public MainFrame() {
        this.frame = new JFrame();
        this.helperHTML = new HTMLTablePanel();

        initializeFrameSettings();
        initializeUserInterface();
        initializeMenuBar();
    }

    private void initializeFrameSettings() {
        frame.setTitle("Table by Vlad");
        frame.setSize(1024,768);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void initializeUserInterface() {
        JPanel mainPanel  = new JPanel(new BorderLayout(3,1));
        JPanel tablePanel = new HTMLTablePanel();

        JPanel menuPanel = initializeMenuPanel();
        JPanel pagePanel = initializePaginatePanel();

        mainPanel.add(menuPanel, BorderLayout.PAGE_START);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(pagePanel, BorderLayout.PAGE_END);

        frame.add(mainPanel);
    }

    private JPanel initializeMenuPanel() {
        JPanel menuPanel  = new JPanel();
        SearchAndDeleteDialog searchAndDeleteDialog = new SearchAndDeleteDialog(frame);
        CreateDialog createDialog = new CreateDialog(frame);

        JButton createButton = new JButton("Add New Student");
        JButton searchButton = new JButton("Search and Delete");

        createButton.addActionListener(e -> createDialog.getDialog() );
        searchButton.addActionListener(e -> searchAndDeleteDialog.getDialog() );

        menuPanel.add(createButton);
        menuPanel.add(searchButton);

        return menuPanel;
    }

    private JPanel initializePaginatePanel() {
        JPanel pagePanel  = new JPanel();

        JButton firstButton = new JButton("First Page");
        JButton lastButton  = new JButton("Last Page");
        JButton nextButton  = new JButton("Next Page >");
        JButton prevButton  = new JButton("< Prev Page");

        pagePanel.add(firstButton);
        pagePanel.add(prevButton);
        pagePanel.add(nextButton);
        pagePanel.add(lastButton);

        return pagePanel;
    }

    private void initializeMenuBar() {
        JMenuBar menuBar  = new JMenuBar();
        JMenu fileMenu    = new JMenu("File");

        JMenuItem menuOpen = new JMenuItem("Open");
        JMenuItem menuSave = new JMenuItem("Save");
        JMenuItem menuExit = new JMenuItem("Exit");

        menuExit.addActionListener(e -> frame.dispose());

        fileMenu.add(menuOpen);
        fileMenu.add(menuSave);
        fileMenu.addSeparator();
        fileMenu.add(menuExit);

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
    }

}
