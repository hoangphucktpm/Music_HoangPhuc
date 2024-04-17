package dao;

import entity.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface AlbumDao extends Remote {
    public boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException;
    public List<Album> getAllAlbum() throws RemoteException;
    public List<Album> listAlbumByGenreAndYear(String genre, int year) throws RemoteException;
    public Map<String, Long> getNumberOfAlbumByGenre() throws RemoteException;
}

