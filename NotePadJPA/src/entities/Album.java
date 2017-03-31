package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(name = "release_year")
	private LocalDate releaseYear;
	private String picture;
	@OneToMany(mappedBy = "album")
	private List<Song> songs;
	@ManyToMany(mappedBy = "albums")
	private List<Album> albums;
	@ManyToMany(mappedBy = "albums")
	@Enumerated(EnumType.STRING)
	private List<Category> genres;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(LocalDate releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public int getId() {
		return id;
	}
	

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + "]";
	}

}
