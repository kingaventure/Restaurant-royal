import java.util.ArrayList;

public class Restaurant {
    protected int id;
    String nameRestaurant;
    String address;
    ArrayList<Menu> menus;
    ArrayList<Command> commands;
    ArrayList<Employe> employes;

    public Restaurant(String nameRestaurant, String address, int id) {
        this.id = id;
        this.nameRestaurant = nameRestaurant;
        this.address = address;
        menus = new ArrayList<Menu>();
        commands = new ArrayList<Command>();
        employes = new ArrayList<Employe>();
    }

    public String RestaurantToString(String nameRestaurant, String address, int id) {
        return "Nom du restaurant : " + nameRestaurant + "\nAdresse : " + address + "\nId : " + id;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }


    public void addEmploye(Employe employe) {
        employes.add(employe);
    }

    public void removeEmploye(Employe employe) {
        employes.remove(employe);
    }

    public void displayEmploye() {
        for (Employe employe : employes) {
            
        }
    }

    public void findEmployeByRole(String role) {
        for (Employe employe : employes) {
            if (employe.getRole().equals(role)) {
                
            }
        }
    }

    public void saveCommande(String fichier) {

    }

    public void loadCommande(String fichier) {

    }

    private int totalSalaryEmployes() {
        int result = 0;
        for (Employe employe : employes) {
            result += employe.salary;
        }
        return result;
    }

    public void displayRestaurant() {
        System.out.println("Nom du restaurant : " + nameRestaurant);
        System.out.println("Adresse : " + address);
        System.out.println("Nombre d'employés : " + employes.size());
        System.out.println("Nombre de commandes : " + commands.size());
        System.out.println("Nombre de menus : " + menus.size());
        System.out.println("Total des salaires : " + totalSalaryEmployes() + "€");
        System.out.println("Ce restaurant à fait : " + totalMoneyMade() + "€");
    }

    private int totalMoneyMade() {
        int result = 0;
        for (Command command : commands) {
            result += command.amount;
        }
        return result;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
    }

    public void displayMenu() {
        for (Menu menu : menus) {
            menu.displayMenu();
        }
    }



}
