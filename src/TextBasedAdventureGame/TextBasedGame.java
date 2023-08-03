package TextBasedAdventureGame;

import java.util.Random;
import java.util.Scanner;

public class TextBasedGame {
    Scanner sc = new Scanner(System.in);
    Player player = new Player();

    int choice;
    int monsterHp;
    int silverRing;

    public static void main(String[] args) {
        TextBasedGame game = new TextBasedGame();
        game.playerSetUp();
        game.townGate();
    }

    public void playerSetUp(){
        player.setHp(10);
        monsterHp = 15;

        player.setWeapon("Knife");

        System.out.println("Your HP: " + player.getHp());
        System.out.println("Your weapon: " + player.getWeapon());

        System.out.print("Please Enter you name: ");
        player.setName(sc.nextLine());

        System.out.println("Hello " + player.getName() + ", let's start the game!");
    }

    public void townGate(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("You are at the gate of the town.");
        System.out.println("A guard is standing in front of you.");
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3. Leave");
        System.out.println("------------------------------------------------------------------");

        choice = sc.nextInt();

        if(choice == 1){
            if(silverRing == 1){
                ending();
            }
            else{
                System.out.println("Guard: Hello there, stranger. So your name is " + player.getName()
                        + "? \nSorry but we cannot let stranger enter our town.");
                sc.nextLine();
                townGate();
            }
        }
        else if(choice == 2){
            player.subtractHp(1);
            System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You receive 1 damage)\n");
            System.out.println("Your HP: " + player.getHp());
            sc.nextLine();
            townGate();
        }
        else if( choice == 3){
            crossRoad();
        }
        else{
            townGate();
        }
    }

    public void crossRoad(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = sc.nextInt();

        if (choice == 1){
            north();
        }
        else if(choice == 2){
            east();
        }
        else if (choice == 3){
            townGate();
        }
        else if(choice == 4){
            west();
        }
        else{
            crossRoad();
        }
    }

    public void north(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("There is a river. You drink the water and rest at the riverside.");
        System.out.println("Your HP is recovered.");
        player.addHp(1);
        System.out.println("Your HP: " + player.getHp());
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = sc.nextInt();

        if(choice == 1){
            crossRoad();
        }
        else{
            north();
        }

    }

    public void east(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You walked into a forest and found a Long Sword!");
        player.setWeapon("Long Sword");
        System.out.println("Your Weapon: " + player.getWeapon());
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = sc.nextInt();

        if(choice == 1){
            crossRoad();
        }
        else{
            east();
        }
    }

    public void west(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = sc.nextInt();

        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            crossRoad();
        } else {
            west();
        }
    }

    public void fight(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Your HP: " + player.getHp());
        System.out.println("Monster HP: " + monsterHp);
        System.out.println("\n1: Attack");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = sc.nextInt();

        if (choice == 1) {
            attack();
        } else if (choice == 2) {
            crossRoad();
        } else {
            fight();
        }
    }

    public void attack(){
        int playerDamage = 0;

        if(player.getWeapon().equals("Knife")){
            playerDamage = new Random().nextInt(5);
        } else if (player.getWeapon().equals("Long Sword")) {
            playerDamage = new Random().nextInt(8);
        }

        System.out.println("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHp -= playerDamage;

        System.out.println("Monster HP: " + monsterHp);

        if(monsterHp < 1){
            win();
        }
        else{
            int monsterDamage = new Random().nextInt(4);

            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");
            player.subtractHp(monsterDamage);

            System.out.println("Player HP: " + player.getHp());

            if(player.getHp() < 1){
                dead();
            } else if (player.getHp() > 0) {
                fight();
            }
        }
    }

    public void dead(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public void win(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtained a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n------------------------------------------------------------------\n");

        silverRing = 1;

        choice = sc.nextInt();
        if(choice == 1){
            crossRoad();
        }
        else {
            win();
        }
    }

    public void ending(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}