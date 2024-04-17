package daoTest;

import dao.AlbumDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.Naming;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbumDaoTest {

    private static final String URL = "rmi://HOANGPHUC:6541/";
    private AlbumDao albumDao;

    @BeforeAll
    public void setUp() throws Exception {
        albumDao = (AlbumDao) Naming.lookup(URL + "albumDao");
    }

     @Test
     // Lấy all
    public void testGetAllAlbum() throws Exception {
        albumDao.getAllAlbum().forEach(System.out::println);
    }

    @Test
    // Lấy theo thể loại và năm
    public void testListAlbumByGenreAndYear() throws Exception {
        albumDao.listAlbumByGenreAndYear("Pop", 2021).forEach(System.out::println);
    }

    @Test
    // Lấy số lượng theo thể loại
    public void testGetNumberOfAlbumByGenre() throws Exception {
        albumDao.getNumberOfAlbumByGenre().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    @Test
    // Cập nhật giá của album
    public void testUpdatePriceOfAlbum() throws Exception {
        albumDao.updatePriceOfAlbum("album3", 12412);
    }

    @AfterAll
    public void tearDown() throws Exception {
        albumDao = null;
    }
}
