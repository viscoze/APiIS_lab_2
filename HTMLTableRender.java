import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.util.Hashtable;

public class HTMLTableRender  {
    public JScrollPane renderTable(String tableHTML) {
        JEditorPane table = new JEditorPane();
        table.setEditable(false);
        HTMLEditorKit kit = new HTMLEditorKit();
        table.setEditorKit(kit);
        table.setDocument(kit.createDefaultDocument());
        table.setText(tableHTML);
        return (new JScrollPane(table));
    }

    public String getHeader(int amountOfExams) {
        return  "<table border=1>\n" +
                "    <tr>\n" +
                "        <td rowspan=\"3\">Surname</td>\n" +
                "        <td rowspan=\"3\">Group</td>\n" +
                "        <td colspan=\"2\">Exams</td>\n" +
                "    </tr>\n" + getExamsCol(amountOfExams) +
                "</table>";
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
