package oop_4;
import java.util.ArrayList;

/**
 * Имитация чата, главная задача составить архитектуру классов и методов
 */
public class Program {

  public static void main(String[] args) {
    Chat gb = new Chat();
    File f = new File();

    User client1 = new User("Тима", gb);
    User client2 = new User("Арман", gb);
    User client4 = new User("Алмагуль", gb);

    gb.appendClient(client1);
    gb.appendClient(client2);
    gb.appendClient(client4);

    client1.sendMsg("привет всем!");

    client2.sendMsg("ку-ку!");

    User client3 = new User("Коля", gb);
    gb.appendClient(client3);

    client3.sendMsg("hello world!");
    client3.sendMsg("Котик", 3.3);

  }
}

/**
 * Пользователь
 */
class User {

  String name;
  private Chatroom chatroom;

  public User(String name, Chatroom chatroom) {
    this.name = name;
    this.chatroom = chatroom;
  }

  void printMessage(String msg) {
    System.out.printf("Чат %s: %s\n", name, msg);
  }

  void printMessage(String msg, Double f) {
    System.out.printf("Чат %s: %s\n", name, msg, f);
  }

  void sendMsg(String text) {
    chatroom.sendMessage(text, this);
  }

  void sendMsg(String fileName, Double fileSize) {
    chatroom.sendMessage(fileName, fileSize, this);
  }

}

interface Chatroom {

  void sendMessage(String msg, User user);

  void appendClient(User user);

  void sendMessage(String fileName, Double fileSize, User user);
}

/**
 * Работа с чатом
 */
class Chat implements Chatroom {

  ArrayList<User> users = new ArrayList<>();
  /*
   Отравка текстового сообщения
    */
  @Override
  public void sendMessage(String text, User me) {

    for (User user : users) {
      if (user.name != me.name) {
        user.printMessage(text);
      }
    }
  }
  /*
  Пользователь добавился
   */
  @Override
  public void appendClient(User client) {
    System.out.println("\n >>> добавился " + client.name);
    users.add(client);
  }
  /*
   Отправка файла
    */
  @Override
  public void sendMessage(String fileName, Double fileSize, User me) {
    System.out.println(
        "Отправил файл с именем: " + fileName + " Раземер файла " + fileSize + " Мб");
    for (User user : users) {
      if (user.name != me.name) {
        user.printMessage(fileName, fileSize);
      }
    }

  }
}

/**
 * Класс для отправки файла в чат
 */
class File {
}

