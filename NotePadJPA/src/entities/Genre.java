package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name="name")
	private Category genre;
	@ManyToMany
	@JoinTable(name = "genre_album", 
	joinColumns = @JoinColumn(name = "genre_id"), 
	inverseJoinColumns = @JoinColumn(name = "album_id"))
	private List<Album> albums;

	public Category getGenre() {
		return genre;
	}

	public void setGenre(Category genre) {
		this.genre = genre;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genre=" + genre + "]";
	}

}
