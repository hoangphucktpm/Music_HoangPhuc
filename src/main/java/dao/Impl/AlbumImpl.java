package dao.Impl;

import dao.AlbumDao;
import entity.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;


public class AlbumImpl extends UnicastRemoteObject implements AlbumDao {

    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public AlbumImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }

    // a. Cap nhat don gia cho mot album nao do khi biet ma so (Khong cho phep cap nhat cac thuoc tinh khac cua album)
    @Override
    public boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Album album = em.find(Album.class, id);
            if (album == null) {
                java.util.logging.Logger.getLogger(AlbumImpl.class.getName()).log(Level.WARNING, "Album with id " + id + " not found");
                return false;
            }
            album.setPrice(newPrice);
            em.merge(album);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            java.util.logging.Logger.getLogger(AlbumImpl.class.getName()).log(Level.SEVERE, "Failed to update album price", e);
            return false;
        }
    }

    // lấy ra all
    public List<Album> getAllAlbum() throws RemoteException {
        return em.createNamedQuery("Album.getAllAlbum", Album.class).getResultList();
    }

    // b. Tim kiem cac album theo the loai va nam phat hanh (tim tuong doi)
    public List<Album> listAlbumByGenreAndYear(String genre, int year) throws RemoteException {
        return em.createNamedQuery("Album.listAlbumByGenreAndYear", Album.class)
                .setParameter("genre", genre)
                .setParameter("year", year)
                .getResultList();
    }

    // c. Liet ke so luong album theo the loai, ket qua sap xep theo ten the loai tang dan
    public Map<String, Long> getNumberOfAlbumByGenre() throws RemoteException {
        return em.createNamedQuery("Album.getNumberOfAlbumByGenre", Object[].class)
                .getResultList()
                .stream()
                .collect(java.util.stream.Collectors.toMap(x -> (String) x[0], x -> (Long) x[1]));
    }
}
