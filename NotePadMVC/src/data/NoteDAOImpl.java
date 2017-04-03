package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Playlist;
import entities.Song;
import entities.User;

public class NoteDAOImpl implements NoteDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Playlist addSongToPlaylist(Playlist playlist, Song song) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist showPlaylist(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist createPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist updatePlaylistTitle(int id, Playlist playlist) {

		Playlist managed = em.find(Playlist.class, id);
	
		String newTitle = playlist.getTitle();

		if (newTitle != null) {
			managed.setTitle(newTitle);
		}

		em.persist(managed);
		em.flush();
		
		return managed;
	}

	@Override
	public boolean destroyPlaylist(User user, Playlist playlist) {
		
		if (user.getId() == playlist.getOwner().getId() && playlist != null) {
			
			em.remove(playlist);
			em.flush();
			
			if (em.contains(playlist)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public Playlist addPlaylistUser(User user, Playlist playlist) {
		
		Playlist managed = em.find(Playlist.class, playlist.getId());

		List<User> users = managed.getUsers();
		users.add(user);

		managed.setUsers(users);
		
		em.persist(managed);
		em.flush();
		
		return managed;
	}

	@Override
	public Playlist removePlaylistUser(User user, Playlist playlist) {
		
		Playlist managed = em.find(Playlist.class, playlist.getId());

		List<User> users = managed.getUsers();
		users.remove(user);
		
		if(users.contains(user)) {
			return null;
		}
		
		managed.setUsers(users);
		
		em.persist(managed);
		em.flush();
		
		return managed;
	}

}
