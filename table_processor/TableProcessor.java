package table_processor;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

public class TableProcessor {

    private Table  table;
    private JPanel panel;

    public TableProcessor(Table table) {
        this.table = table;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void addStudent(String surname, Integer group, DefaultTableModel tableModel) {
        ArrayList<String> subjectsAndMarks = new ArrayList<>();
        Vector tableData = tableModel.getDataVector();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Vector tableDatum = (Vector)tableData.elementAt(i);
            subjectsAndMarks.add(tableDatum.elementAt(0).toString());
            subjectsAndMarks.add(tableDatum.elementAt(1).toString());
        }

        System.out.println("Surname: " + surname + "Subject:" + subjectsAndMarks.get(0) + "Mark" + subjectsAndMarks.get(1));

        table.addStudent(surname, group, subjectsAndMarks);
   }

    public void search(String surname, Integer group) {
        int indexOfStudent = table.searchStudentByGroup(surname, group);
        LinkedHashMap<String, Integer> student = table.getStudentByIndex(indexOfStudent);

    }
}
