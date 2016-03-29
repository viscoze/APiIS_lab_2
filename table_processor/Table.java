package table_processor;

import java.util.Hashtable;
import java.util.LinkedHashMap;

public class Table {

    private LinkedHashMap<String[],Hashtable<String,Integer>> mainTable;

    public Table() {
        this.mainTable = new LinkedHashMap<>();
    }

    public void add(String surname, String group, Hashtable<String, Integer> listOfSubjectsAndMarks) {
        String[] surnameAndGroup = { surname, group };
        mainTable.put(surnameAndGroup, listOfSubjectsAndMarks);
    }
}
