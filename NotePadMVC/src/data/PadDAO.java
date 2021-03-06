package data;

import java.util.List;

import entities.Album;
import entities.Artist;
import entities.Playlist;
import entities.Song;

public interface PadDAO {

	public Artist createNewArtist(Artist artist);
	public Album createNewAlbum(Album album);
	public Song createNewSongWithNewAlbum(Song song);
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
	public Artist showArtist(int id);
	public Album showAlbum(int id);
	public Song showSong(int id);

	public boolean removeArtist(Artist artist);
	public boolean removeSong(Song song);
	public boolean removeAlbum(Album album);

	public boolean deleteArtist(int id);
	public boolean deleteSong(int id);
	public boolean deleteAlbum(int album);
	List<Artist> listArtist();
	List<Album> listAlbum();
	List<Song> listSongs();
	public List<Artist> getArtists();
	public Album getSongsByAlbumById(int id);
	Song getSongById(int id);

	public Album addSongWithNewAlubum(String songTitle, String artistName, 
			String albumTitle, int albumYear, int genreId);
	public Album addSongWithExistingAlbum(String songTitle, int albumId);
}
