package table_processor;

import view.HTMLTablePanel;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TableProcessor {

    private Table  table;
    private HTMLTablePanel HTMLpanel;
    private JPanel panel;

    public TableProcessor(Table table) {
        this.table = table;
    }

    public void setHTMLPanel(HTMLTablePanel panel) {
        this.HTMLpanel = panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void renderTable() {
        HTMLpanel.setTable(table.getAllStudents());
    }

    public Table getTable() {
        return table;
    }

    public void addStudent(String surname, String group, TableModel tableModel) {
        ArrayList<String> subjectsAndMarks = new ArrayList<>();

        for (int i = 0; i < tableModel.getRowCount(); i++)
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                String data = (String) tableModel.getValueAt(i, j);
                if (data == null) break;
                subjectsAndMarks.add((String) tableModel.getValueAt(i, j));
            }

        table.addStudent(surname, group, subjectsAndMarks);
   }

    public void search(String surname, String group) {
        int indexOfStudent = table.searchStudentByGroup(surname, group);
        LinkedHashMap<String, String> student = table.getStudentByIndex(indexOfStudent);

    }

    public void remove(int index) {
        table.deleteStudent(index);
    }


}
