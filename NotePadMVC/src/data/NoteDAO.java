package data;

import java.util.List;

import entities.Playlist;
import entities.Song;
import entities.User;

public interface NoteDAO {
	
	public Playlist addSongToPlaylist(Playlist playlist, Song song);
	public Playlist showPlaylist(int id);
	public User createPlaylist(Playlist playlist, User user);
	public Playlist updatePlaylistTitle(int id, Playlist playlist);
	public User addPlaylistUser(User user, int playlistId);
	public Playlist removePlaylistUser(User user, Playlist playlist);
	public boolean destroyPlaylist(User id, Playlist playlist);
	public List<Playlist> showAllPlaylists();
	
}
