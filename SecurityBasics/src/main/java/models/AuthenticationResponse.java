package models;



public class AuthenticationResponse {
	
	private String jwt;
	private int userId;


	public AuthenticationResponse(String jwt,int userId) {
		
		this.jwt = jwt;
		this.userId=userId;
	}

	public String getJwt() {
		return jwt;
	}

	public int getUserId() {
		return userId;
	}
	
}
