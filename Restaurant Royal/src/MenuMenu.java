import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMenu {

    private Scanner scanner;

    public MenuMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        switch (scanner.nextInt()) {
            case 1:
                File folder = new File("data");
                File[] listOfFiles = folder.listFiles();
                System.out.println("Here is the list of all the restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
    
                System.out.println("Entrer le nom du restaurant dont vous voulez afficher les menus :");
                String name = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/menus");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Voici une liste de tout les menus du restaurant " + name + " :");
                for (File file : listOfFiles2) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            fileName = fileName.substring(0, fileName.length() - 4);
                        }
                        System.out.println(fileName);
                    }
                }
                break;
            case 2:
                File dataDirectory = new File("data");
                if (dataDirectory.exists() && dataDirectory.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }
                        scanner.nextLine();
                        System.out.println("Entrer le nom du restaurant auquel vous voulez ajouter un menu :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            scanner.nextLine();
                            System.out.println("Entrer l'id du menu :");
                            int idMenu = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Entrer le nom du menu :");
                            String menuName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrer le type du menu  :");
                            String menuType = scanner.next();
                            scanner.nextLine();
                            String creationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            ArrayList<Dish> platAvaibility = new ArrayList<Dish>();
                            Menu menu = new Menu(idMenu, menuName, creationDate, menuType, platAvaibility);
                            String menuString = menu.MenuToString(idMenu, menuName, creationDate, menuType, platAvaibility);
                            File menuDirectory = new File("data/" + restaurantName + "/menus/" + menuName);
                            menuDirectory.mkdir();
                            File dishDirectory = new File("data/" + restaurantName + "/menus/" + menuName + "/dishes");
                            dishDirectory.mkdir();
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/menus/" + menuName + "/" + menuName + ".txt");
                                myWriter.write(menuString);
                                myWriter.close();
                                System.out.println("Le fichier à correctement été créer");
                            } catch (IOException e) {
                                System.out.println("Une erreur c'est produite.");
                                e.printStackTrace();
                            }
                            System.out.println("Le menu " + menuName + " est ajouté au restaurant : " + restaurantName);
                            
                        } else {
                            System.out.println("Le fichier de restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le dossier data n'existe pas.");
                }
                break;
            case 3:
                File dataDirectory2 = new File("data");
                if (dataDirectory2.exists() && dataDirectory2.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory2.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurant:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }
    
                        System.out.println("Entre le nom du restaurant auquel tu veux supprimer un menu:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entre le nom du menu que tu veux supprimer:");
                            String menuName = scanner.next();
                            File menuFile = new File("data/" + restaurantName + "/" + "menus" + "/" + menuName + ".txt");
                            if (menuFile.exists() && menuFile.isFile()) {
                                menuFile.delete();
                                System.out.println("Le menu " + menuName + " à bien été supprimer du restaurant : " + restaurantName);
                            } else {
                                System.out.println("Le fichier menu n'existe pas.");
                            }
                        } else {
                            System.out.println("Le fichier restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le dossier data n'existe pas.");
                }
                break;
            case 4:
                File dataDirectory3 = new File("data");
                if (dataDirectory3.exists() && dataDirectory3.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory3.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }
    
                        System.out.println("Entre le nom du restaurant du menu que tu veux afficher:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrer le nom du menu que vous voulez afficher :");
                            String menuName = scanner.next();
                            File menuFile = new File("data/" + restaurantName + "/" + "menus" + "/" + menuName + ".txt");
                            if (menuFile.exists() && menuFile.isFile()) {
                                try {
                                    Scanner myReader = new Scanner(menuFile);
                                    while (myReader.hasNextLine()) {
                                        String data = myReader.nextLine();
                                        System.out.println(data);
                                    }
                                    myReader.close();
                                } catch (IOException e) {
                                    System.out.println("Une erreur est arrivé.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Le fichier menu n'existe pas.");
                            }
                        } else {
                            System.out.println("Le fichier du restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le dossier data n'existe pas.");
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
}
