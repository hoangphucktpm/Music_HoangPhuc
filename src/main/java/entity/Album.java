package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Album")
@NamedQueries({
        @NamedQuery(name = "Album.getAllAlbum", query = "SELECT a FROM Album a"),
        @NamedQuery(name = "Album.listAlbumByGenreAndYear", query = "SELECT a FROM Album a WHERE a.genre.name LIKE :genre AND a.yearOfRelease = :year"),
        @NamedQuery(name = "Album.getNumberOfAlbumByGenre", query = "SELECT a.genre.name, COUNT(a) FROM Album a GROUP BY a.genre.name ORDER BY a.genre.name")
})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String title;
    private Double price;
    private int yearOfRelease;
    private String downloadLink;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "Album_Artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )

    private Set<Artist> artists;

    @ManyToMany
    @JoinTable(
            name = "album_songs",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )



    private Set<Song> songs;

    public Album() {
    }

    public Album(String id, String title, Double price, int yearOfRelease, String downloadLink) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.downloadLink = downloadLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    @Override
    public String toString() {
        return String.format("Album [id=%s, title=%s, price=%s, yearOfRelease=%s, downloadLink=%s]", id, title, price, yearOfRelease, downloadLink);
    }
}
