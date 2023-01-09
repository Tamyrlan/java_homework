package oop_3;
import oop_3.Items.Worker;
import oop_3.Model.*;
public class Controller {
    public static void run() {
        String pathJson = "oop_3/text/W1.json";
        String pathMd = "oop_3/text/W2.md";
        String pathXml = "oop_3/text/W3.xml";
        Worker w1 = new Worker(32, 35000, "Tom", "Bin");
        Document doc = new Document<Worker>(w1);
        doc.setFormat(new JsonFormat());
        doc.setPath(pathJson);
        doc.save();
        doc.setFormat(new MdFormat());
        doc.setPath(pathMd);
        doc.save();
        doc.setFormat(new XmlFormat());
        doc.setPath(pathXml);
        doc.save();
    }
}
