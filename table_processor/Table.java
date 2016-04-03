package table_processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Table {

    private LinkedList<LinkedHashMap<String, Integer>> mainTable;

    public Table() {
        this.mainTable = new LinkedList<>();
    }

    public LinkedList<LinkedHashMap<String, Integer>> getAllStudent() {
        return mainTable;
    }

    public void addStudent(String surname, Integer group, ArrayList<String> subjectsAndMarks) {
        LinkedHashMap<String, Integer> student = new LinkedHashMap<>();

        student.put(surname, group);
        for(int i = 0; i < subjectsAndMarks.size(); i+=2)
            student.put(subjectsAndMarks.get(i), Integer.parseInt(subjectsAndMarks.get(i+1)));

        mainTable.add(student);
    }

    public void deleteStudent(int index) {
        mainTable.remove(index);
    }

    public LinkedHashMap<String, Integer> getStudentByIndex(int index) {
        return mainTable.get(index);
    }

    public int searchStudentByGroup(String surname, Integer group) {
        for (LinkedHashMap<String, Integer> student:mainTable)
            if (student.containsKey(surname) && student.containsValue(group))
                return mainTable.indexOf(student);

        return -1;
    }

}
