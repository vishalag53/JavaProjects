package TextBasedAdventureGame;

public class Player {
    private int hp;
    private String name;
    private String weapon;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void subtractHp(int hp){
        this.hp -= hp;
    }

    public void addHp(int hp){
        this.hp += hp;
    }
}
