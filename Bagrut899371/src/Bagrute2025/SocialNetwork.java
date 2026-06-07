package Bagrute2025;

public class SocialNetwork {
    public User[] users;
    public SocialNetwork(User[] users){
        this.users = users;
    }
    public boolean exactOne(User other){
        for (int i = 0; i < this.users.length; i++) {
            if(this.users[i].mutual(other) == 1) return true;
        }
        return false;
    }
}
