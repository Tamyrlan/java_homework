package oop_3.Model;
import oop_3.Interface.tittleformat;
import oop_3.Items.Person;

public class Document<T extends Person> {
    tittleformat format;
    String text;
    String path;
    T person;

    public Document(T person) {
        this.person = person;
    }

    public void setFormat(tittleformat format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public <T extends Person> void save() {
        text = format.createString(person);
        Model.saveFile(text, this.path);

    }

}
