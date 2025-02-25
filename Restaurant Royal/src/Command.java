
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
        return "Commande [numéroCommande = " + numberCommand + ", plats = " + plats + ", montant = " + amount + "]";
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
        System.out.println("Numéro de commande : " + numberCommand);
        for (Dish dish : plats) {
            
        }
        calculateAmount();
        System.out.println("Montant total : " + amount);
    }

    public String CommandToString() {
        return "Commande [numéroCommande=" + numberCommand + ", plats=" + plats + ", montant=" + amount + "]";
    }
}
