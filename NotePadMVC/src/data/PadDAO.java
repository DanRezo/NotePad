package data;

import java.util.List;

import entities.Album;
import entities.Artist;
import entities.Playlist;
import entities.Song;

public interface PadDAO {

	public Artist create(Artist artist);
	public Album create(Album album);
	public Song create(Song song);
	public Album edit(int id, Album album);
	public Song edit(int id, Song song);
	public List <Song> getSongsByAlbum(int id);
	public List <Song> getSongsByArtist(int id);
	public List <Song> getSongsByGenre(int id);
	public List <Album> getAlbumsByArtist(int id); 
	public List <Album> getAlbumsByGenre(int id);
	public List<Playlist> showPlaylistByUser(int id);
}