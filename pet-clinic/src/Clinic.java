import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анджей on 11.05.2016.
 */
public class Clinic {
    private final List<Client> clients;
    int id = 1;

    public Clinic() {
        clients = new ArrayList<Client>();
    }

    /**
     * Added client
     * @param client
     */
    public void addClient(final Client client) {
        this.clients.add(client);
    }

    /**
     * Find client by name
     * @throws IOException
     */
    public void findClientByName() throws IOException {
        String clientName;
        String ask;
        ConsoleHelper.writeMessage("Введите имя клиента: ");
        clientName = ConsoleHelper.readString();
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                ConsoleHelper.writeMessage("Найден клиент: " + client.getId() + " " + client.getName() +
                        " " + client.getPet().getPetType() + " " + client.getPet().getName());
                return;
            }
        }
        ConsoleHelper.writeMessage("Клиент не найден. Хотите повторить запрос? yes/no");
        ask = ConsoleHelper.readString();
        if (ask.equalsIgnoreCase("yes")) {
            findClientByName();
        }else return;
    }
}
