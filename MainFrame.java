import java.awt.*;
import java.util.Hashtable;
import javax.swing.*;

public class MainFrame {

    private JFrame frame;
    private final int FRAME_SIZE_X = 1024;
    private final int FRAME_SIZE_Y = 768;

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
        JPanel mainPanel  = new JPanel(new BorderLayout(3,1));
        JPanel menuPanel  = new JPanel();
        JPanel pagePanel  = new JPanel();
        JPanel tablePanel   = new JPanel();

        JButton createButton = new JButton("Create");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(e -> renderDialog(createButton.getText()));
        searchButton.addActionListener(e -> renderDialog(searchButton.getText()));
        deleteButton.addActionListener(e -> renderDialog(deleteButton.getText()));

        menuPanel.add(createButton);
        menuPanel.add(searchButton);
        menuPanel.add(deleteButton);

        tablePanel.add(renderTable(getHeader(3)));

        JButton firstButton = new JButton("First Page");
        JButton lastButton  = new JButton("Last Page");
        JButton nextButton  = new JButton("Next Page >");
        JButton prevButton  = new JButton("< Prev Page");

        pagePanel.add(firstButton);
        pagePanel.add(prevButton);
        pagePanel.add(nextButton);
        pagePanel.add(lastButton);

        mainPanel.add(menuPanel, BorderLayout.PAGE_START);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(pagePanel, BorderLayout.PAGE_END);

        frame.add(mainPanel);
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

    private void renderDialog(String title) {
        JDialog dialog = new JDialog(frame,title,false);
        dialog.setSize(FRAME_SIZE_X/2,FRAME_SIZE_Y/2);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }

    private JEditorPane renderTable(String tableHTML) {
        JEditorPane table = new JEditorPane("text/html",tableHTML);
        table.setEditable(false);
        return table;
    }

    private String getHeader(int amountOfExams) {
        return  "<table border='1' style=\"width:100%;text-align:center;\">\n" +
                "    <tr>\n" +
                "        <td rowspan=\"3\">Surname</td>\n" +
                "        <td rowspan=\"3\">Group</td>\n" +
                "        <td colspan=\"2\">Exams</td>\n" +
                "    </tr>\n" + getExamsCol(amountOfExams) +
                "</table>";
    }

    private String getExamsCol(int amountOfExams) {
        String examsHTML = "";
        for (int i = 0; i < amountOfExams; i++) {
            examsHTML +="    <tr>" +
                        "        <td colspan=\"2\">" + (i+1) + "</td>" +
                        "    </tr>" +
                        "    <tr>" +
                        "        <td>Subject</td>" +
                        "        <td>Mark</td>" +
                        "    </tr>";
        }
        return examsHTML;
    }

    private String getStudentRow(String surname, String group, Hashtable<String, Integer> subjectToMark) {
        String studentRow = "<tr><td>" + surname + "</td><td>" + group + "</td>";

        return (studentRow+"</tr>");
    }
}
