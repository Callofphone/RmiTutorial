import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.RemoteException;


/**
 * Created by jamiel on 8-9-2017.
 */
public class Client {
    private Client() {}

    private static Weather getWeather(String city) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1299);
        IRemoteWeatherMethods stub = (IRemoteWeatherMethods) registry.lookup("WeatherServer");

        return stub.retrieveWeather(city);
    }

    public static void main(String[] args) {
        try {
            System.out.println(getWeather("Taipei"));
            System.out.println(getWeather("Toronto"));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
