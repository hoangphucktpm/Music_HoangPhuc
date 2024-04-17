package server;

import dao.AlbumDao;
import dao.Impl.AlbumImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {

    private static final String URL = "rmi://HOANGPHUC:6541/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            AlbumDao albumDao = new AlbumImpl();

            LocateRegistry.createRegistry(6541);

            context.bind(URL + "albumDao", albumDao);

            System.out.println("Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
