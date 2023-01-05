package oop_2;
import java.util.List;
public class tempTable {
    String path = "oop_2/table.txt";
    repository utilities = new repository();
    List<person> persons = utilities.getList(path);
    /**
     * @return
     */
    public List<person> gPersons(){
        return persons;
    }
}
