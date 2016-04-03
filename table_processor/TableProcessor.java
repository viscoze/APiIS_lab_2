package table_processor;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedHashMap;
import java.util.LinkedList;

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

    }

    public void search(String surname, Integer group) {
        int indexOfStudent = table.searchStudentByGroup(surname, group);
        LinkedHashMap<String, Integer> student = table.getStudentByIndex(indexOfStudent);

    }
}
