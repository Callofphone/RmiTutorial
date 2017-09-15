import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jamiel on 7-9-2017.
 */
public interface IRemoteWeatherMethods extends Remote {
    Weather retrieveWeather(String city) throws RemoteException;
}
