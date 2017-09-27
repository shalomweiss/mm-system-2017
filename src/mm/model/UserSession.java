package mm.model;

public class UserSession {
		
		private String id;
		private String token;
		private User updatedUser;
		public UserSession(String id, String token, User updatedUser) {
			super();
			this.id = id;
			this.token = token;
			this.updatedUser = updatedUser;
		}
		
		
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getToken() {
			return token;
		}


		public void setToken(String token) {
			this.token = token;
		}


		public User getUpdatedUser() {
			return updatedUser;
		}


		public void setUpdatedUser(User updatedUser) {
			this.updatedUser = updatedUser;
		}


		@Override
		public String toString() {
			return "UserSession [id=" + id + ", token=" + token + ", updatedUser=" + updatedUser + "]";
		}
}