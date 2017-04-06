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
	public Playlist addSongToPlaylist(int songId, int playListId) {
		Song song = em.find(Song.class, songId);
		System.out.println(playListId);
		String query = "SELECT p FROM Playlist p WHERE p.id = :id";
		Playlist p = em.createQuery(query, Playlist.class).setParameter("id", playListId).getSingleResult();
		song.addPlayList(p);
		em.merge(song);

		return p;
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
	public User createPlaylist(String title, User user) {

		User managedUser = em.find(User.class, user.getId());
		
		Playlist playlist = new Playlist();
		
		playlist.setTitle(title);
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
	public User destroyPlaylist(User user, Playlist playlist) {
		
		User managedUser = user;
		Playlist managedPlaylist = playlist;
		
		System.out.println(managedUser);
		System.out.println("*******************************************************"); 
		
		try {			
			managedUser = em.find(User.class, user.getId());			
			managedPlaylist = em.find(Playlist.class, playlist.getId());
			
			
			System.out.println(managedUser);
			
			System.out.println("*******************************************************"); 
			System.out.println("successful try"); 
		} catch (NoResultException e) {
			
			System.out.println("*******************************************************"); 
			System.out.println("unsuccessful try"); 
			return managedUser;
		}

		if (managedUser.getId() == managedPlaylist.getOwner().getId() 
				&& managedPlaylist != null) {
			
			System.out.println(managedPlaylist.getId());
			
			String query = "Delete from Playlist where id=:id";
			em.createQuery(query).setParameter("id", managedPlaylist.getId()).executeUpdate();
//			em.remove(managedPlaylist);		
			em.flush();
			System.out.println("*******************************************************"); 
			System.out.println("successful if"); 
//			if (em.contains(playlist)) {
//				return false;
//			} else {
//				return true;
//			}
			
		} else  {
			
			managedUser.getPlaylists().remove(managedPlaylist);
			em.persist(managedUser);
			System.out.println("*******************************************************"); 
			System.out.println("unsuccessful if"); 
		}
		
		try {
			String selectQuery = "SELECT u FROM User AS u JOIN FETCH u.playlists WHERE u.id = :id";
			managedUser = em.createQuery(selectQuery, User.class).setParameter("id", user.getId()).getSingleResult();
		} catch (NoResultException e) {

			managedUser = em.find(User.class, user.getId());
		}	
		
		return managedUser;
	}

	@Override
	public User addPlaylistUser(User user, int playlistId) {
		
		Playlist managedPlaylist = em.find(Playlist.class, playlistId);
		User managedUser = em.find(User.class, user.getId());

//		List<User> users = managedPlaylist.getUsers();
//		users.add(managedUser);

		List<Playlist> playlists = managedUser.getPlaylists();
		playlists.add(managedPlaylist);

		managedUser.setPlaylists(playlists);
//		managedPlaylist.setUsers(users);

//		em.persist(managedPlaylist);
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

	@Override
	public User getPlayListByUser(String alias) {
		String query = "SELECT u FROM User u JOIN FETCH u.playlists where u.alias = :alias";

		User user = em.createQuery(query, User.class).setParameter("alias", alias).getSingleResult();
		return user;
	}
}
