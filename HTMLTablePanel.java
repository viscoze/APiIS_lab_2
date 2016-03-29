import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.util.Hashtable;

public class HTMLTablePanel extends JPanel {

    private JLabel table;

    HTMLTablePanel() {
        super();
        this.table = new JLabel();
        table.setText(getHeader(3));
        add(table);
        this.setSize((int) table.getBounds().getWidth(), (int) table.getBounds().getHeight());
    }

    public void createHead1() {
        table.setText("<html><table border=1 cellpadding=10 width=744px>"
                + "<tr>"
                + "<td rowspan=2 ALIGN=center width=75%><font face=’verdana’ size = 5>ФИО студента</td><td rowspan=2 ALIGN=center><font face=’verdana’ size = 5>Группа</td><td colspan=4 ALIGN=center><font face=’verdana’ size = 5>Число пропусков занятий за год</td></tr>"
                + "<tr>"
                + "<td ALIGN=center><font face=’verdana’ size = 5>По болезни</td><td ALIGN=center><font face=’verdana’ size = 5>По другим причинам</td><td ALIGN=center><font face=’verdana’ size = 5>Без уважительной причины</td><td ALIGN=center><font face=’verdana’ size = 5>Итого</td></tr>"
                + "<tr>"
                + "<td>test</td><td>test</td><td>test</td><td>test</td><td>test</td><td>test</td></tr>"
                + "</table></html>");
    }

    public void createHead2() {
        table.setText("<html><table border=1 cellpadding=10 width=744px>"
                + "<tr>"
                + "<td rowspan=2 ALIGN=center width=75%><font face=’verdana’ size = 5>ФИО студента</td><td rowspan=2 ALIGN=center><font face=’verdana’ size = 5>Группа</td><td colspan=4 ALIGN=center><font face=’verdana’ size = 5>Число пропусков занятий за год</td></tr>"
                + "<tr>"
                + "<td ALIGN=center><font face=’verdana’ size = 5>По болезни</td><td ALIGN=center><font face=’verdana’ size = 5>По другим причинам</td><td ALIGN=center><font face=’verdana’ size = 5>Без уважительной причины</td><td ALIGN=center><font face=’verdana’ size = 5>Итого</td></tr>"
                + "<tr>"
                + "<td>test</td><td>test</td><td>test</td><td>test</td><td>test</td><td>test</td></tr>"
                + "</table></html>");
    }

    public String getHeader(int amountOfExams) {
        return  "<html><table border=1>\n" +
                "    <tr>\n" +
                "        <td rowspan=\"3\">Surname</td>\n" +
                "        <td rowspan=\"3\">Group</td>\n" +
                "        <td colspan=4>Exams</td>\n" +
                "    </tr>\n" +
                "    <tr>" +
                "        <td colspan=\"2\">1</td>" +
                "    </tr>" +
                "    <tr>" +
                "        <td>Subject</td>" +
                "        <td>Mark</td>" +
                "    </tr>" +
                "    <tr>" +
                "        <td colspan=\"2\">1</td>" +
                "    </tr>" +
                "    <tr>" +
                "        <td>Subject</td>" +
                "        <td>Mark</td>" +
                "    </tr>" +
                "</table></html>";
    }

    public String getExamsCol(int amountOfExams) {
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

    public String getStudentRow(String surname, String group, Hashtable<String, Integer> subjectToMark) {
        String studentRow = "<tr><td>" + surname + "</td><td>" + group + "</td>";

        return (studentRow+"</tr>");
    }
}
