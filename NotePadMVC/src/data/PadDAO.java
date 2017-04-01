package data;

import java.util.List;

import entities.Playlist;
import entities.Song;
import entities.User;

public interface PadDAO {
	
	User editPadName(User alias); //ability to change their alias
	User addNote(User newNote);
	User getSongByArtist(Song artist);
	User getSongByTitle(Song title);
	User getSongsByGenre(Song genere);
	User delteSongfromPad(Song pad);
	User deleteSongFromPlaylist(Song plaulist);
	List<Playlist> playlist();
	List<Song> listsongs();
	
}
