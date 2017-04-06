package data;

import java.util.List;

import entities.Playlist;
import entities.Song;
import entities.User;

public interface NoteDAO {
	
	public Playlist addSongToPlaylist(int songId, int playListId);
	public Playlist showPlaylist(int id);
	public User createPlaylist(String title, User user);
	public Playlist updatePlaylistTitle(int id, Playlist playlist);
	public User addPlaylistUser(User user, int playlistId);
	public Playlist removePlaylistUser(User user, Playlist playlist);
	public User destroyPlaylist(int userId, int playlistId);
	public List<Playlist> showAllPlaylists();
	public User getPlayListByUser(String alias);
	
}
