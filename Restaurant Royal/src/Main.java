import java.io.File;
import java.util.Scanner;

public class Main {
    
    public static void deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Bienvenue à restaurant Royal, voici vos options :");
            System.out.println("1 : Menu Restaurant");
            System.out.println("2 : Menu Employés");
            System.out.println("3 : Menu Menus");
            System.out.println("4 : Menu Plats");
            System.out.println("5 : Menu Commandes");
            System.out.println("6 : Sortir");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Bienvenue dans le menu des restaurants, voici vos options :");
                    System.out.println("1 : Afficher tous les restaurants");
                    System.out.println("2 : Ajouter un restaurant");
                    System.out.println("3 : Retirer un restaurant");
                    System.out.println("4 : Afficher les détails d'un restaurant");
                    System.out.println("5 : Revenir au menu principal");

                    RestaurantMenu restaurantMenu = new RestaurantMenu(scanner);
                    restaurantMenu.displayMenu();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Bienvenue dans le menu des employés, voici vos options :");
                    System.out.println("1 : Afficher tous les employés");
                    System.out.println("2 : Ajouter un employé");
                    System.out.println("3 : Retirer un employé");
                    System.out.println("4 : Afficher les détails d'un employé");
                    System.out.println("5 : Revenir au menu principal");

                    EmployeMenu employeMenu = new EmployeMenu(scanner);
                    employeMenu.displayMenu();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Bienvenue dans le menu des menus, voici vos options :");
                    System.out.println("1 : Afficher tous les menus");
                    System.out.println("2 : Ajouter un menu");
                    System.out.println("3 : Retirer un menu");
                    System.out.println("4 : Afficher les détails d'un menu");
                    System.out.println("5 : Revenir au menu principal");

                    MenuMenu menuMenu = new MenuMenu(scanner);
                    menuMenu.displayMenu();
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Bienvenue dans le menu des plats, voici vos options :");
                    System.out.println("1 : Afficher tous les plats");
                    System.out.println("2 : Ajouter un plat");
                    System.out.println("3 : Retirer un plat");
                    System.out.println("4 : Afficher les détails d'un plat");
                    System.out.println("5 : Revenir au menu principal");

                    DishMenu dishMenu = new DishMenu(scanner);
                    dishMenu.displayMenu();
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Bienvenue dans le menu des commandes, voici vos options :");
                    System.out.println("1 : Afficher toutes les commandes");
                    System.out.println("2 : Ajouter une commande");
                    System.out.println("3 : Retirer une commande");
                    System.out.println("4 : Afficher les détails d'une commande");
                    System.out.println("5 : Revenir au menu principal");

                    CommandMenu commandMenu = new CommandMenu(scanner);
                    commandMenu.displayMenu();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

        scanner.close();
    }
}