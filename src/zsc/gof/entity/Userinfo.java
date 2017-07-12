package zsc.gof.entity;

public class Userinfo {
	private int userId;
	private String username;
	private String password;
	private int locked;
	private String faceing;
	private Role role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public String getFaceing() {
		return faceing;
	}
	public void setFaceing(String faceing) {
		this.faceing = faceing;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
