package Bagrute2025;

public class User {
    private String name;
    private int id;
    private int[] friends;
    public User(String name, int id, int[] friends){
        this.name = name;
        this.id = id;
        this.friends = friends.clone();
    }

    public int mutual(User other){
        int m = 0;
        int[] larger = this.getFriends();
        int[] smaller = other.getFriends();
        if(smaller.length > larger.length){
            int[] temp = larger;
            larger = smaller;
            smaller = temp;
        }
        for (int i = 0; i < larger.length; i++) {
            if(inArr(larger[i], smaller)) m++;
        }
        return m;
    }

    public boolean inArr(int id, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == id) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getFriends() {
        return friends.clone();
    }

    public void setFriends(int[] friends) {
        this.friends = friends;
    }
}
