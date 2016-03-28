import java.awt.*;
import javax.swing.*;

public class MainFrame {

    private JFrame frame;
    private JPanel tablePanel;
    private String tableHTML;
    private final int FRAME_SIZE_X = 512;
    private final int FRAME_SIZE_Y = 384;

    public MainFrame() {
        this.frame = new JFrame();

        initializeFrameSettings();
        initializeUserInterface();
        initializeMenuBar();
    }

    private void initializeFrameSettings() {
        frame.setTitle("Table by Vlad");
        frame.setSize(FRAME_SIZE_X,FRAME_SIZE_Y);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void initializeUserInterface() {
        JPanel mainPanel  = new JPanel(new BorderLayout());
        JPanel menuPanel  = new JPanel();
        JPanel pagePanel  = new JPanel();
        this.tablePanel   = new JPanel();

        JButton createButton = new JButton("Create");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(e -> renderDialog(createButton.getText()));
        searchButton.addActionListener(e -> renderDialog(searchButton.getText()));
        deleteButton.addActionListener(e -> renderDialog(deleteButton.getText()));

        menuPanel.add(createButton);
        menuPanel.add(searchButton);
        menuPanel.add(deleteButton);

        renderTable();

        mainPanel.add(menuPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(pagePanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
    }

    private void initializeMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu   = new JMenu("File");

        JMenuItem open = new JMenuItem("Open");

        fileMenu.add(open);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
    }

    private void renderDialog(String title) {
        JDialog dialog = new JDialog(frame,title,false);
        dialog.setSize(FRAME_SIZE_X/2,FRAME_SIZE_Y/2);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }

    private void renderTable() {
        String html="<table style=\"width:100%\" border=\"1\">\n" +
                "  <tr>\n" +
                "    <td>Jill</td>\n" +
                "    <td>Smith</td> \n" +
                "    <td>50</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Eve</td>\n" +
                "    <td>Jackson</td> \n" +
                "    <td>94</td>\n" +
                "  </tr>\n" +
                "</table>";
        JEditorPane ed1 = new JEditorPane("text/html",html);
        tablePanel.add(ed1);
    }
}
