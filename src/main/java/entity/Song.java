package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Song")
public class Song implements Serializable {

    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    private String id;
    private String name;
    private String runtime;
    private String lyric;
    private String fileLink;

    @ManyToMany(mappedBy = "songs")
    private Set<Album> albums;


    public Song() {
    }

    public Song(String id, String name, String runtime, String lyric, String fileLink) {
        this.id = id;
        this.name = name;
        this.runtime = runtime;
        this.lyric = lyric;
        this.fileLink = fileLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    @Override
    public String toString() {
        return String.format("Song [id=%s, name=%s, runtime=%s, lyric=%s, fileLink=%s]", id, name, runtime, lyric, fileLink);
    }
}
