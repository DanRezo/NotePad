package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Playlist;
import entities.Song;
import entities.User;

@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Playlist addSongToPlaylist(Playlist playlist, Song song) {
		List<Song> songs;
		Playlist playList1 = playlist;
		em.getTransaction().begin();
		songs = playlist.getSongs();
		songs.add(song);
		playList1.setSongs(songs);
		em.persist(playList1);
		em.flush();

		return playList1;
	}

	@Override
	public Playlist showPlaylist(int id) {
		
		try {
			String query = "SELECT p FROM Playlist AS p JOIN FETCH p.songs WHERE p.id = :id";
			
			Playlist playlist = em.createQuery(query, Playlist.class).setParameter("id", id)
					.getSingleResult();

			return playlist;
		} catch (NoResultException e) {
			return em.find(Playlist.class, id);
		}
	}

	@Override
	public User createPlaylist(Playlist playlist, User user) {

		User managedUser = em.find(User.class, user.getId());

		playlist.setOwner(managedUser);
		managedUser.getOwnedPlaylists().add(playlist);
		managedUser.getPlaylists().add(playlist);

		em.persist(playlist);
		em.persist(managedUser);
		em.flush();

		String query = "SELECT u FROM User AS u JOIN FETCH u.playlists WHERE u.id = :id";

		User userWithPlaylists = em.createQuery(query, User.class).setParameter("id", managedUser.getId())
				.getSingleResult();

		return userWithPlaylists;
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
	public void destroyPlaylist(User user, Playlist playlist) {

		if (user.getId() == playlist.getOwner().getId() && playlist != null) {

			em.remove(playlist);
			em.flush();

//			if (em.contains(playlist)) {
//				return false;
//			} else {
//				return true;
//			}
		} else {
			
			user.getPlaylists().remove(playlist);
						
		}
	}

	@Override
	public User addPlaylistUser(User user, int playlistId) {

		Playlist managedPlaylist = em.find(Playlist.class, playlistId);
		User managedUser = em.find(User.class, user.getId());

		List<User> users = managedPlaylist.getUsers();
		users.add(managedUser);

		List<Playlist> playlists = managedUser.getPlaylists();
		playlists.add(managedPlaylist);

		managedUser.setPlaylists(playlists);
		managedPlaylist.setUsers(users);

		em.persist(managedPlaylist);
		em.persist(managedUser);
		em.flush();

		return managedUser;
	}

	@Override
	public Playlist removePlaylistUser(User user, Playlist playlist) {

		Playlist managed = em.find(Playlist.class, playlist.getId());

		List<User> users = managed.getUsers();
		users.remove(user);

		if (users.contains(user)) {
			return null;
		}

		managed.setUsers(users);

		em.persist(managed);
		em.flush();

		return managed;
	}

	@Override
	public List<Playlist> showAllPlaylists() {

		String query = "SELECT DISTINCT p FROM Playlist AS p JOIN FETCH p.songs";

		List<Playlist> playlists = em.createQuery(query, Playlist.class).getResultList();

		return playlists;
	}
}
