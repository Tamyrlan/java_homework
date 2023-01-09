package oop_3.Model;
import oop_3.Interface.tittleformat;
import oop_3.Items.Person;
public class JsonFormat implements tittleformat {
    @Override
    public <T extends Person> String createString(T person){
        return String.format("{\n" +
        "\"worker\" : {\n" +
        "\"age\":%d,\n" +
        "\"Firstname\":\"%s\",\n" +
        "\"Surname\":\"%s\"\n" +
        "}\n" +
        "}", person.getAge(), person.getFirstName(), person.getSurname());
    }
}
