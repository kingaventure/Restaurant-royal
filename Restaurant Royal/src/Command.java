
import java.util.ArrayList;

public class Command {
    public int numberCommand;
    ArrayList<Dish> plats;
    public double amount;

    public Command(int numberCommand, double amount) {
        this.numberCommand = numberCommand;
        this.amount = amount;
    }

    public String commandToString(){
        return "Command [numberCommand = " + numberCommand + "plats = " + plats + "amount =" + amount + "]";
    }

    

    public void addPlat(Dish dish) {
        plats.add(dish);
    }

    public void removePlat(Dish dish) {
        plats.remove(dish);
    }

    public void calculateAmount() {
        for (Dish dish : plats) {
            amount += dish.price;
        }
    }

    public void displayCommand() {
        System.out.println("Commande number : " + numberCommand);
        for (Dish dish : plats) {
            
        }
        calculateAmount();
        System.out.println("Total amount : " + amount);

    }

    public String CommandToString() {
        return "Command [numberCommand=" + numberCommand + ", dish=" + plats + ", amount=" + amount + "]";
    }
}
