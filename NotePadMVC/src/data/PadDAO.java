package data;

import java.util.List;

import entities.Album;
import entities.Artist;
import entities.Playlist;
import entities.Song;

public interface PadDAO {

	public Artist createNewArtist(Artist artist);
	public Album createNewAlbum(Album album);
	public Song createNewSongWithNewAlbum(Song song, Album album);
	public Song createNewSongWithExistingAlbum(Song song, Album album);
	public Album edit(int id, Album album);
	public Song edit(int id, Song song);
	public Artist edit(int id, Artist artist);
	public List <Song> getSongsByAlbum(int id);
	public List <Song> getSongsByArtist(int id);
	public List <Song> getSongsByGenre(int id);
	public List <Album> getAlbumsByArtist(int id); 
	public List <Album> getAlbumsByGenre(int id);
	public List<Playlist> showPlaylistByUser(int id);
	public Album getAlbumById(int i);
}