package data;

import java.util.List;

import javax.persistence.EntityManager;
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
		Playlist yourPlayList = em.find(Playlist.class, id);
		em.flush();
		return yourPlayList;
	}

	@Override
	public Playlist createPlaylist(Playlist playlist) {
		em.persist(playlist);
		em.flush();

		return null;
	}

	@Override
	public Playlist updatePlaylist(int id, Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist destroyPlaylist(User id, Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}
}
	


