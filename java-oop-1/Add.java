
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * .1. Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.
 * под форматами понимаем структуру файлов, например:
 * в файле на одной строке хранится одна часть записи, пустая строка - разделитель
 * <p>
 * Класс Add реализует базу данный «Телефонный справочник»
 * БД постоена на основе контейнера HashMap<String, String>
 * в качестве ключа используется номер телефона в виде строку, а в качестве значения - фамилия
 * класс включает в себя метод main который запускает работу с БД
 * также включены методы
 * addPB - добавляет запись по заданным номеру телефона и фамилии
 * delPB - удаляет запись по номеру телефона
 * savePB - сохраняет БД в текстовом файле phone.txt
 * loadPB - загружает БД из текстового файла phone.txt
 * PrintPhonebook - выводит на екран все записи БД
 * FindSurname - производит поиск фамилии по номеру телефона
 * FindNumberPhone - производит поиск списка номеров по фамилии
 */
public class Add {

    private static HashMap<String, String> pb = new HashMap<String, String>();

    /**
     * addPB - добавляет запись по заданным номеру телефона и фамилии
     *
     * @param phone
     * @param name
     */
    private static void addPB(String phone, String name) {
        pb.put(phone, name);
    }

    /**
     * delPB - удаляет запись по номеру телефона
     *
     * @param phone
     */
    private static void delPB(String phone) {
        pb.remove(phone);
    }

    /**
     * savePB - сохраняет БД в текстовом файле phone.txt
     *
     * @throws IOException исключение
     */
    private static void savePB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for (Map.Entry<String, String> k : pb.entrySet()) {
            writer.write(k.getKey() + " " + k.getValue() + System.lineSeparator());
        }
        writer.close();
    }

    /**
     * loadPB - загружает БД из текстового файла phone.txt
     *
     * @throws IOException исключение производит проверку на наличие файла
     */
    public static void loadPB() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act = reader.readLine()) != null) {
                String[] dat = act.split(" ");
                pb.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    /**
     * PrintPhonebook - выводит на экран все записи БД
     */
    public static void PrintPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> k : pb.entrySet()) {
            System.out.println(k.getValue() + ": " + k.getKey());
        }
    }

    /**
     * FindSurname - производит поиск фамилии по номеру телефона заданому в качестве аргумента
     *
     * @param number
     * @return возвращает строку
     */
    public static String FindSurname(String number) {
        String result = pb.get(number);
        if (result == null) return "абонент с таким номером не найдей";
        return result;
    }

    /**
     * FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
     *
     * @param surname
     * @return возвращает массив строк
     */
    public static String[] FindNumberPhone(String surname) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : pb.entrySet()) {
            if (surname.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    /**
     * Запуск программы
     * String act переменная описывает вызываемое действие
     * loadPB() загрузка БД
     * PrintPhonebook() вывод записей на экран
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String act;
        loadPB();
        PrintPhonebook();
        System.out.println("выбор действия:\n(1)добавить данные,\n(2)удалить данные,\n(3) найти номера по фамилии,\n(4)найти фамилию," +
                "\n(5)сохранить,\n(ex)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("ex")) {
            //добавление записи
            if (act.equals("1")) {
                System.out.println("Введите фамилию:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addPB(phone, name);
            } else {
                //удаление записи
                if (act.equals("2")) {
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPB(phone);
                } else {
                    //поиск номеров по фамилии
                    if (act.equals("3")) {
                        System.out.println("Введите фамилию:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        //поиск фамилии по номеру
                        if (act.equals("4")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {
                            //сохранение БД в файл
                            if (act.equals("5")) {
                                savePB();
                            }
                        }
                    }
                }
            }
            //запрос на следующее действие
            System.out.println("выбор действия: (1)добавить данные, (2)удалить данные, (3) найти номера по фамилии, (4)найти фамилию, (5)сохранить, (ex)выход");
            act = bf.readLine();
        }
    }
}