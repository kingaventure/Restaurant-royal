

public class Command {
    public int numberCommand;
    public int amount;

    public Command(int numberCommand, int amount) {
        this.numberCommand = numberCommand;
        this.amount = amount;
    }

    public String commandToString(int numberCommand,int amount) {
        return "Commande numéro : " + numberCommand + " Montant : " + amount;
    }
}
