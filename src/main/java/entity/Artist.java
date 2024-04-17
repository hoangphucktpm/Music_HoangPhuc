package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist implements Serializable{

    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
    private String url;

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;

    public Artist() {
    }
    public Artist(String id, String name, LocalDate birthDate, String url) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.url = url;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", url='" + url + '\'' +
                '}';
    }
}
