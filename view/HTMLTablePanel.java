package view;

import javax.swing.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class HTMLTablePanel extends JPanel {

    private JLabel table;

    HTMLTablePanel() {
        super();
        this.table = new JLabel();
        add(table);
    }

    public void setTable(LinkedList<LinkedHashMap<String, String>> mainTable) {
        table.setText(getStudentTable(mainTable));
    }

    private String getStudentTable(LinkedList<LinkedHashMap<String, String>> mainTable) {
        String studentsTable = "<html><table border=1 cellpadding=5 width=744px>"
                               + getHeader(getMaxAmountOfExams(mainTable));

        try {
            for (LinkedHashMap<String, String> sm : mainTable) {
                String surname = (String) sm.keySet().toArray()[0];
                String group = sm.get(surname);
                sm.remove(surname);
                studentsTable += getStudentRow(surname, group, sm);
            }
        } catch (NullPointerException npe) {
            npe.getStackTrace();
        }

        return studentsTable + "</table></html>";
    }

    private String getStudentRow(String surname, String group, LinkedHashMap<String, String> studentsMarks) {
        String surnameAndGroupHTML = "<td>"+surname+"</td><td>"+group+"</td>";
        String studentsMarksHTML = "";

        for(Map.Entry<String, String> sm:studentsMarks.entrySet()) {
            studentsMarksHTML += "<td>"+sm.getKey()+"</td><td>"+sm.getValue()+"</td>";
        }

        return "<tr>" + surnameAndGroupHTML + studentsMarksHTML  + "</tr>";
    }

    private int getMaxAmountOfExams(LinkedList<LinkedHashMap<String, String>> mainTable) {
        return mainTable.getFirst().size();
    }

    private String getHeader(int amountOfExams) {
        return "<tr>\n" +
                "   <td rowspan=3>Surname</td>\n" +
                "   <td rowspan=3>Group</td>\n" +
                "   <td colspan=" + amountOfExams*2 + ">Exams</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                getNumberOfExam(amountOfExams) +
                "</tr>\n" +
                "<tr>\n" +
                getSubjectMark(amountOfExams) +
                "</tr>\n";
    }

    private String getNumberOfExam(int amountOfExams) {
        String number = "";
        for (int i = 0; i < amountOfExams; i++)
            number += "<td colspan=2>"+(i+1)+"</td>\n";

        return number;
    }

    private String getSubjectMark(int amountOfExams) {
        String subjectMark = "";
        for (int i = 0; i < amountOfExams; i++)
            subjectMark += "   <td>Subject</td>\n" +
                           "   <td>Mark</td>\n";

        return subjectMark;
    }
}
