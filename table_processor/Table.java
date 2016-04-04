package table_processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Table {

    private LinkedList<LinkedHashMap<String, String>> mainTable;

    public Table() {
        this.mainTable = new LinkedList<>();
    }

    public LinkedList<LinkedHashMap<String, String>> getAllStudents() {
        return mainTable;
    }

    public void addStudent(String surname, String group, ArrayList<String> subjectsAndMarks) {
        LinkedHashMap<String, String> student = new LinkedHashMap<>();

        student.put(surname, group);
        for(int i = 0; i < subjectsAndMarks.size(); i+=2)
            student.put(subjectsAndMarks.get(i), subjectsAndMarks.get(i+1));

        mainTable.add(student);
    }

    public void deleteStudent(int index) {
        mainTable.remove(index);
    }

    public LinkedHashMap<String, String> getStudentByIndex(int index) {
        return mainTable.get(index);
    }

    public int searchStudentByGroup(String surname, String group) {
        for (LinkedHashMap<String, String> student:mainTable)
            if (student.containsKey(surname) && student.containsValue(group))
                return mainTable.indexOf(student);

        return -1;
    }

}
