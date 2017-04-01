package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String alias;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String password;
	@Column(name = "profile_picture")
	private String profilePicture;
	@Column(name = "admin_level")
	@Enumerated(EnumType.STRING)
	private AdminLevel adminLevel;
	@ManyToMany
	@JoinTable(name = "playlist_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "playlist_id"))
	private List<Playlist> playlists;
	@OneToMany(mappedBy = "owner")
	private List<Playlist> ownedPlaylists;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public AdminLevel getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(AdminLevel adminLevel) {
		this.adminLevel = adminLevel;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public int getId() {
		return id;
	}

	public List<Playlist> getOwnedPlaylists() {
		return ownedPlaylists;
	}

	public void setOwnedPlaylists(List<Playlist> ownedPlaylists) {
		this.ownedPlaylists = ownedPlaylists;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", alias=" + alias + "]";
	}

}
