import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RestaurantMenu {

    private final Scanner scanner;

    public RestaurantMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        switch (scanner.nextInt()) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                scanner.nextLine();
                File folder = new File("data");
                File[] listOfFiles = folder.listFiles();
                System.out.println("Voici une liste des restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                scanner.nextLine();
                System.out.println("Choissiez un id : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Entrer le nom du restaurant : ");
                String name2 = scanner.next();
                scanner.nextLine();
                System.out.println("Entrer l'addresse du restaurant : ");
                String address = scanner.next();
                scanner.nextLine();

                Restaurant restaurant = new Restaurant(name2, address, id);
                String restaurantString = restaurant.RestaurantToString(name2, address, id);

                File restaurantDirectory = new File("data/" + name2);
                File menuDirectory = new File("data/" + name2 + "/menus");
                File commandDirectory = new File("data/" + name2 + "/commands");
                File employeDirectory = new File("data/" + name2 + "/employes");
                
                File restaurantFile2 = new File("data/" + name2 + "/" + name2 + ".txt");

                restaurantDirectory.mkdirs();
                menuDirectory.mkdirs();
                commandDirectory.mkdir();
                employeDirectory.mkdir();
                
                try {
                    restaurantFile2.createNewFile();
                } catch (Exception e) {
                    System.out.println("Une erreur c'est produite lors de la création du fichier.");
                    e.printStackTrace();
                }

                try {
                    FileWriter myWriter = new FileWriter("data/" + name2 + "/" + name2 + ".txt");
                    myWriter.write(restaurantString);
                    myWriter.close();
                    System.out.println("Restaurant " + name2 + " ajouté avec succès");
                } catch (IOException e) {
                    System.out.println("Une erreur c'est produite.");
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                File folder2 = new File("data");
                File[] listOfFiles2 = folder2.listFiles();
                System.out.println("Voici une liste des restaurants :");
                for (File file : listOfFiles2) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }

                System.out.println("Ecrivez le nom du restaurant que vous voulez supprimer: ");
                String name3 = scanner.next();
                File restaurantDirectory2 = new File("data/" + name3);
                deleteDirectory(restaurantDirectory2);
                System.out.println("Restaurant " + name3 + " supprimé avec succès");
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                File folder3 = new File("data");
                File[] listOfFiles3 = folder3.listFiles();
                System.out.println("Voici une liste des restaurants :");
                for (File file : listOfFiles3) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
                System.out.println("Ecrivez le nom du restaurant dont vous voulez afficher les détails: ");
                String name4 = scanner.next();
                File restaurantFile3 = new File("data/" + name4 + "/" + name4 + ".txt");
                try {
                    Scanner myReader = new Scanner(restaurantFile3);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (IOException e) {
                    System.out.println("Une erreur c'est produite.");
                    e.printStackTrace();
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    private void deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }
}