package oop_3.Model;
import oop_3.Interface.tittleformat;
import oop_3.Items.Person;
public class XmlFormat implements tittleformat {

    @Override
    public <T extends Person> String createString(T person) {
        return String.format("<xml>\n" +
                "<Worker>\n" +
                "<age>%d</age>\n" +
                "<Firstname>%s</Firstname>\n" +
                "<Surname>Какое-то имя</Surname>\n" +
                "</Worker>" +
                "</xml>", person.getAge(), person.getFirstName(), person.getSurname());
    }

}

