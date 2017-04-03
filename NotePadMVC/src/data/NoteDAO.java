package data;

import entities.Playlist;
import entities.Song;
import entities.User;

public interface NoteDAO {
	
	public Playlist addSongToPlaylist(Playlist playlist, Song song);
	public Playlist showPlaylist(int id);
	public Playlist createPlaylist(Playlist playlist);
	public Playlist updatePlaylist(int id, Playlist playlist);
	public Playlist destroyPlaylist(User id, Playlist playlist);
	
}
