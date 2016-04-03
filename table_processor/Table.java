package table_processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Table {

    private LinkedList<LinkedHashMap<String, Integer>> mainTable;

    public Table() {
        this.mainTable = new LinkedList<>();
    }

    public void addStudent(String surname, Integer group, ArrayList<String> subjectsAndMarks) {

    }

    public LinkedList<LinkedHashMap<String, Integer>> getAllStudent() {
        return mainTable;
    }

}
