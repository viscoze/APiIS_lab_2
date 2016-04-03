package view;

import javax.swing.*;
import java.util.Hashtable;

public class HTMLTablePanel extends JPanel {

    private JLabel table;

    HTMLTablePanel() {
        super();
        this.table = new JLabel();
        table.setText(getHeader(5));
        add(table);
    }

    public String getHeader(int amountOfExams) {
        return  "<html>\n" +
                "<table border=1 cellpadding=5 width=744px>\n" +
                "<tr>\n" +
                "   <td rowspan=3>Surname</td>\n" +
                "   <td rowspan=3>Group</td>\n" +
                "   <td colspan=" + amountOfExams*2 + ">Exams</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                getNumberOfExam(amountOfExams) +
                "</tr>\n" +
                "<tr>\n" +
                getSubjectMark(amountOfExams) +
                "</tr>\n" +
                "<tr>\n" +
                "  \n" +
                "</tr>\n" +
                "</table>\n" +
                "</html>";
    }

    private String getNumberOfExam(int amountOfExams) {
        String number = "";
        for (int i = 0; i < amountOfExams; i++) {
            number += "<td colspan=2>"+(i+1)+"</td>\n";
        }
        return number;
    }

    private String getSubjectMark(int amountOfExams) {
        String subjectMark = "";
        for (int i = 0; i < amountOfExams; i++) {
            subjectMark += "   <td>Subject</td>\n" +
                           "   <td>Mark</td>\n";
        }
        return subjectMark;
    }

    private String getStudentTable() {
        return "1";
    }

    private String getStudentRow(String surname, String group, Hashtable<String, Integer> subjectsAndMarksTable) {
        return "!";
    }
}
