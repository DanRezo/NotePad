package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "album_id")
	private Album album;
	@ManyToMany
	@JoinTable(name = "song_playlist", 
	joinColumns = @JoinColumn(name = "song_id"), 
	inverseJoinColumns = @JoinColumn(name = "playlist_id"))
	private List<Playlist> playlists;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public void addPlayList(Playlist p){
		if(playlists != null){
			playlists.add(p);
		}
		else{
			playlists = new ArrayList<>();
			playlists.add(p);
		}
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + "]";
	}

}
