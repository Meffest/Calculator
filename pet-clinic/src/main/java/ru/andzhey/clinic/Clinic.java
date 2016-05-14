package ru.andzhey.clinic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анджей on 11.05.2016.
 */
public class Clinic {
    private boolean isExit;
    private final List<Client> clients;
    int id = 1;

    public Clinic() {
        clients = new ArrayList<Client>();
        isExit = false;
    }

    /**
     * Clinics menu
     */
    public void menu() {
        ConsoleHelper.writeMessage("Введите номер интересующей операции :");
        ConsoleHelper.writeMessage("1 - добавить клиента");
        ConsoleHelper.writeMessage("2 - посмотреть список клиентов");
        ConsoleHelper.writeMessage("3 - найти интересующего клиента по имени");
        ConsoleHelper.writeMessage("4 - удалить клиента");
        ConsoleHelper.writeMessage("exit - выход из программы");
    }

    /**
     * Add clients to clinic
     * @throws IOException
     */
    public void addClient() throws IOException {
        Pet pet;
        ConsoleHelper.writeMessage("Введите имя клиента :");
        String clientName = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите тип животного (cat or dog) :");
        String petType = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите имя животного :");
        String petName = ConsoleHelper.readString();
        if (petType.equalsIgnoreCase("cat")) {
            pet = new Cat(petName);
        } else if (petType.equalsIgnoreCase("dog")) {
            pet = new ConsoleHelper.Dog(petName);
        } else {
            pet = new ChudoUdo(petName, petType);
        }
        clients.add(new Client(id++, clientName, pet));
        System.out.println();
    }

    /**
     * Find client by name
     *
     * @throws IOException
     */
    public void findClientByName() throws IOException {
        ArrayList<Client> findClients = new ArrayList<Client>();
        ConsoleHelper.writeMessage("Введите имя клиента: ");
        String clientName = ConsoleHelper.readString();
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                findClients.add(client);
            }
        }
        if (!findClients.isEmpty()) {
            for (int i = 0; i < findClients.size(); i++) {
                ConsoleHelper.writeMessage("Найден клиент: " + findClients.get(i).getId() + " " + findClients.get(i).getName() +
                        " " + findClients.get(i).getPet().getPetType() + " " + findClients.get(i).getPet().getName());
            }
            System.out.println();
        } else {
            ConsoleHelper.writeMessage("Клиент не найден. Хотите повторить запрос? yes/no");
            String ask = ConsoleHelper.readString();
            if (ask.equalsIgnoreCase("yes")) {
                findClientByName();
            } else return;
        }
    }

    /**
     * Remove client by name
     * @throws IOException
     */
    public void removeClientByName() throws IOException {
        ArrayList<Client> findClients = new ArrayList<Client>();
        String ask;
        ConsoleHelper.writeMessage("Введите имя клиента(ов), которого хотите удалить : ");
        String clientName = ConsoleHelper.readString();
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                findClients.add(client);
            }
        }
        if (!findClients.isEmpty()) {
            for (int i = 0; i < findClients.size(); i++) {
                ConsoleHelper.writeMessage("Найден клиент: " + findClients.get(i).getId() + " " + findClients.get(i).getName() +
                        " " + findClients.get(i).getPet().getPetType() + " " + findClients.get(i).getPet().getName());
            }
            ConsoleHelper.writeMessage("Вы действительно хотите удалить выбранных клиентов? yes/no : ");
            ask = ConsoleHelper.readString();
            if (ask.equalsIgnoreCase("yes")) {
                for (int i = 0; i < findClients.size(); i++) {
                    for (int j = 0; j < clients.size(); j++) {
                        if (clients.get(j).equals(findClients.get(i))) {
                            clients.remove(clients.get(j));
                        }
                    }
                }
            } else return;
        } else {
            ConsoleHelper.writeMessage("Клиент не найден. Хотите повторить запрос? yes/no");
            ask = ConsoleHelper.readString();
            if (ask.equalsIgnoreCase("yes")) {
                removeClientByName();
            } else return;
        }
    }

    /**
     * Start working clinic
     * @throws IOException
     */
    public void start() throws IOException {
        ConsoleHelper.writeMessage("Здравствуйте!");
        while (!isExit) {
            menu();
            String choice = ConsoleHelper.readString();
            switch (choice) {
                case "1":
                    addClient();
                    break;
                case "2":
                    ConsoleHelper.writeMessage("Список зарегистрированных клиентов:");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.println(clients.get(i).getId() + " " + clients.get(i).getName() +
                                " " + clients.get(i).getPet().getPetType() + " " + clients.get(i).getPet().getName());
                    }
                    System.out.println();
                    break;
                case "3":
                    findClientByName();
                    break;
                case "4":
                    removeClientByName();
                    break;
                case "exit":
                    System.out.println("Всего доброго!");
                    isExit = true;
                    break;
            }
        }
    }
}
