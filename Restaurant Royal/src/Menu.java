
import java.util.ArrayList;

public class Menu{
   protected int id;
   String menuName;
   String creationDate;
   String menuType;
   ArrayList<Dish> platAvaibility;

  public Menu (int id, String menuName, String creationDate, String menuType, ArrayList<Dish> platAvaibility){
        this.menuName = menuName;
        this.creationDate = creationDate;
        this.menuType = menuType;
        this.platAvaibility = platAvaibility;

  }

   public String MenuToString( int id, String menuName, String creationDate, String menuType, ArrayList<Dish> platAvaibility) {
      return "Menu [id=" + id + ", menuName=" + menuName + ", creationDate=" + creationDate + ", menuType=" + menuType + ", platAvaibility=" + platAvaibility + "]";
   }
   
   public void addPlat(Dish dish) {
    platAvaibility.add(dish);
   }

   public void removePlat(Dish dish) {
    platAvaibility.remove(dish);
   }

   public void displayMenu() {
    System.out.println("Menu number : " + id);
    System.out.println("Name of the menu : " + menuName);
    System.out.println("Creation date : " + creationDate);
    System.out.println("Type of menu : " + menuType);
   }

   public void findPlatByName(String Name) {
    for (Dish dish : platAvaibility) {
    }

   }

}
