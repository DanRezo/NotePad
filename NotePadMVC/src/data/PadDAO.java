package data;

import java.util.List;

import entities.Album;
import entities.Artist;
import entities.Song;
import entities.User;

public interface PadDAO {

	// User editPadName(User alias); //ability to change their alias
	// User addNote(User newNote);
	// User delteSongfromPad(Song pad);
	// User deleteSongFromPlaylist(Song plaulist);
	public void showPlaylists();

	public Artist create(Artist artist);

	public Album create(Album album);

	public Song create(Song song);

	public Song edit(int id, Song song);

	public List<Song> getSongsByAlbum(int id);

	public List<Song> getSongsByArtist(int id);
}