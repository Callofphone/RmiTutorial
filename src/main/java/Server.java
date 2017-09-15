import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * Created by jamiel on 7-9-2017.
 */
public class Server implements IRemoteWeatherMethods {
    private List<Weather> cityClimates;

    public Server() {
        cityClimates = new ArrayList<Weather>();
        initializeCityClimates();
    }

    private void initializeCityClimates() {
        cityClimates.add(new Weather("Taipei", "36℃", "Rain", "85%"));
        cityClimates.add(new Weather("Toronto", "12℃", "Sunny day", "65%"));
    }

    public Weather retrieveWeather(String city) throws RemoteException {
        for (Weather climate : cityClimates) {
            if (climate.getCity().equalsIgnoreCase(city)) {
                return climate;
            }
        }
        return null;
    }

    public static void main (String[] args) {
        try {
            Server obj = new Server();
            IRemoteWeatherMethods stub = (IRemoteWeatherMethods) UnicastRemoteObject.exportObject(obj, 1299);

            Registry reg = LocateRegistry.createRegistry(1299);
            reg.rebind("WeatherServer", stub);
        }
        catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
