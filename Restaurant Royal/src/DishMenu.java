import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DishMenu {

    private Scanner scanner;

    public DishMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        switch (scanner.nextInt()) {
            case 1:
                File folder = new File("data");
                File[] listOfFiles = folder.listFiles();
                System.out.println("Voici la liste de tous les restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }

                System.out.println("Entrez le nom du restaurant dont vous voulez afficher tous les plats : ");
                String name = scanner.next();

                File restaurantDirectory2 = new File("data/" + name + "/menus");
                File[] listOfFiles3 = restaurantDirectory2.listFiles();
                System.out.println("Voici la liste de tous les menus :");
                for (File file : listOfFiles3) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
                System.out.println("Entrez le nom du menu dont vous voulez afficher tous les plats : ");
                String menuName = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/menus/" + menuName + "/dishes");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Voici la liste de tous les plats :");
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
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }
                        scanner.nextLine();
                        System.out.println("Entrez le nom du restaurant auquel vous voulez ajouter un plat :");
                        String restaurantName = scanner.next();

                        File restaurantDirectory3 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles4 = restaurantDirectory3.listFiles();
                        System.out.println("Voici la liste de tous les menus :");
                        for (File file : listOfFiles4) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }

                        System.out.println("Entrez le nom du menu auquel vous voulez ajouter un plat :");
                        String menuName1 = scanner.next();

                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            scanner.nextLine();
                            System.out.println("Entrez l'identifiant du plat :");
                            int idDish = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Entrez le nom du plat :");
                            String dishName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez la description du plat :");
                            String description = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le prix du plat :");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Entrez les calories du plat :");
                            int calories = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Entrez la catégorie du plat :");
                            String category = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez la taille de la portion du plat :");
                            String servingSize = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez la date d'ajout du plat (format J/M/A) :");
                            String dateOfAdding = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le type de cuisine du plat :");
                            String cuisineType = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le temps de cuisson du plat :");
                            String cookTime = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le prix spécial du plat :");
                            double specialPrice = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Entrez l'URL de l'image du plat :");
                            String imageURL = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez la disponibilité du plat (true/false) :");
                            boolean availability = scanner.nextBoolean();
                            scanner.nextLine();
                            Dish dish = new Dish(idDish, availability, dishName, description, price, calories, category, servingSize, dateOfAdding, cuisineType, cookTime, specialPrice, imageURL);
                            String dishString = dish.DishToString(idDish, availability, dishName, description, price, calories, category, servingSize, dateOfAdding, cuisineType, cookTime, specialPrice, imageURL);
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/menus/" + menuName1 + "/dishes/" + dishName + ".txt");
                                myWriter.write(dishString);
                                myWriter.close();
                                System.out.println("Écriture réussie dans le fichier.");
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue.");
                                e.printStackTrace();
                            }
                            System.out.println("Plat " + dishName + " ajouté avec succès au restaurant " + restaurantName);
                            updateDish(restaurantName, dishName, menuName1);
                        } else {
                            System.out.println("Le fichier du restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le répertoire de données n'existe pas.");
                }
                break;
            case 3:
                File dataDirectory2 = new File("data");
                if (dataDirectory2.exists() && dataDirectory2.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory2.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Entrez le nom du restaurant dont vous voulez supprimer un plat :");
                        String restaurantName = scanner.next();

                        File restaurantDirectory5 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles5 = restaurantDirectory5.listFiles();
                        System.out.println("Voici la liste de tous les menus :");
                        for (File file : listOfFiles5) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }

                        System.out.println("Entrez le nom du menu dont vous voulez supprimer un plat :");
                        String menuName2 = scanner.next();

                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez le nom du plat que vous voulez supprimer :");
                            String dishName = scanner.next();
                            File dishFile = new File("data/" + restaurantName + "/menus/" + menuName2 + "/dishes/" + dishName + ".txt");
                            if (dishFile.exists() && dishFile.isFile()) {
                                dishFile.delete();
                                System.out.println("Plat " + dishName + " supprimé avec succès du restaurant " + restaurantName);
                            } else {
                                System.out.println("Le fichier du plat n'existe pas.");
                            }
                        } else {
                            System.out.println("Le fichier du restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le répertoire de données n'existe pas.");
                }
                break;
            case 4:
                File dataDirectory3 = new File("data");
                if (dataDirectory3.exists() && dataDirectory3.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory3.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Entrez le nom du restaurant dont vous voulez afficher un plat :");
                        String restaurantName = scanner.next();

                        File restaurantDirectory6 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles6 = restaurantDirectory6.listFiles();
                        System.out.println("Voici la liste de tous les menus :");
                        for (File file : listOfFiles6) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }

                        System.out.println("Entrez le nom du menu dont vous voulez afficher un plat :");
                        String menuName3 = scanner.next();

                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez le nom du plat que vous voulez afficher :");
                            String dishName = scanner.next();
                            File dishFile = new File("data/" + restaurantName + "/menus/" + menuName3 + "/dishes/" + dishName + ".txt");
                            if (dishFile.exists() && dishFile.isFile()) {
                                try {
                                    Scanner myReader = new Scanner(dishFile);
                                    while (myReader.hasNextLine()) {
                                        String data = myReader.nextLine();
                                        System.out.println(data);
                                    }
                                    myReader.close();
                                } catch (IOException e) {
                                    System.out.println("Une erreur est survenue.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Le fichier du plat n'existe pas.");
                            }
                        } else {
                            System.out.println("Le fichier du restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le répertoire de données n'existe pas.");
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    public void updateDish(String name, String dishName, String menuName) {
    String filePath = "data/" + name + "/menus/" + menuName + "/" + menuName + ".txt";
    try {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        boolean dishLineFound = false;
        
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("Plats:")) {
                lines.set(i, lines.get(i) + ", " + dishName);
                dishLineFound = true;
                break;
            }
        }
        
        if (!dishLineFound) {
            lines.add("Plats : " + dishName);
        }
        
        Files.write(Paths.get(filePath), lines);
    } catch (IOException e) {
        System.out.println("Une erreur est survenue.");
        e.printStackTrace();
    }
}

}