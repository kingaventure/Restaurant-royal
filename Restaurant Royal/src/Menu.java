import java.util.ArrayList;

public class Menu {
    protected int id;
    String menuName;
    String creationDate;
    String menuType;
    ArrayList<Dish> platAvaibility;

    public Menu(int id, String menuName, String creationDate, String menuType, ArrayList<Dish> platAvaibility) {
        this.id = id;
        this.menuName = menuName;
        this.creationDate = creationDate;
        this.menuType = menuType;
        this.platAvaibility = platAvaibility;
    }

    public String MenuToString(int id, String menuName, String creationDate, String menuType, ArrayList<Dish> platAvaibility) {
        return "Id du menu : " + id + "\nNom du menu : " + menuName + "\nDate de création : " + creationDate + "\nType de menu : " + menuType;
    }

    public void addPlat(Dish dish) {
        platAvaibility.add(dish);
    }

    public void removePlat(Dish dish) {
        platAvaibility.remove(dish);
    }

    public void displayMenu() {
        System.out.println("Numéro du menu : " + id);
        System.out.println("Nom du menu : " + menuName);
        System.out.println("Date de création : " + creationDate);
        System.out.println("Type de menu : " + menuType);
    }

    
}