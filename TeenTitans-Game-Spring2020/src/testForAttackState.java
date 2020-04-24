import BaseClasses.AttackState;
import Model.Monster;
import Model.Player;

public class testForAttackState {

    public static void main(String[] args) throws InterruptedException {
        Player bob = new Player("1","100","5","2","yes","yes");
        Monster mon = new Monster("1","50","5","2","Phil","Phil is evil","Phill has been oofed","Cheeseburger");
        AttackState.attackState(bob,mon);
    }

}
