public class Astronaut{
    String name;    // name of player
    Collection items;     // collectables player has

    public Astronaut(){
        items = new Collection();
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}
