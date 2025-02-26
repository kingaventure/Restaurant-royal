import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CommandMenu {

    private final Scanner scanner;

    public CommandMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        switch (scanner.nextInt()) {
            case 1 -> {
                File folder = new File("data");
                File[] listOfFiles = folder.listFiles();
                System.out.println("Voici la liste de tous les restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }

                System.out.println("Entrez le nom du restaurant dont vous voulez afficher toutes les commandes : ");
                String name = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/commands");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Voici la liste de toutes les commandes :");
                for (File file : listOfFiles2) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            fileName = fileName.substring(0, fileName.length() - 4);
                        }
                        System.out.println(fileName);
                    }
                }
            }
            case 2 -> {
                File dataDirectory = new File("data");
                if (dataDirectory.exists() && dataDirectory.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Entrez le nom du restaurant auquel vous voulez ajouter une commande :");
                        String restaurantName = scanner.next();
                        scanner.nextLine();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            File restaurantDirectory2 = new File("data/" + restaurantName + "/menus");
                            File[] listOfFiles3 = restaurantDirectory2.listFiles();
                            System.out.println("Voici la liste de tous les menus :");
                            for (File file : listOfFiles3) {
                                if (file.isDirectory()) {
                                    System.out.println(file.getName());
                                }
                            }
                            System.out.println("Entrez le menu auquel vous voulez prendre un plat dans la commande :");
                            String menuName = scanner.next();
                            scanner.nextLine();
                            File restaurantDirectory = new File("data/" + restaurantName + "/menus/" + menuName + "/dishes");
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
                             
                            System.out.println("Entrez le nom du plat que vous voulez ajouter à la commande :");
                            String selectedDish = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez l'identifiant de la commande :");
                            int numberCommand = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Entrez le prix total de la commande :");
                            int commandTotalPrice = scanner.nextInt();
                            scanner.nextLine();
                            Command command = new Command(numberCommand, commandTotalPrice);
                            String commandString = command.commandToString( numberCommand, commandTotalPrice);
                            try {
                                try (FileWriter myWriter = new FileWriter("data/" + restaurantName + "/" + "commands" + "/" + numberCommand + ".txt")) {
                                    myWriter.write(commandString);
                                }
                                System.out.println("Écriture réussie dans le fichier.");
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue.");
                                e.printStackTrace();
                            }
                            System.out.println("Commande " + numberCommand + " ajoutée avec succès au restaurant " + restaurantName);
                            updateCommand(restaurantName, numberCommand, commandTotalPrice, selectedDish, menuName);
                        } else {
                            System.out.println("Le fichier du restaurant n'existe pas.");
                        }
                    } else {
                        System.out.println("Aucun restaurant trouvé.");
                    }
                } else {
                    System.out.println("Le répertoire de données n'existe pas.");
                }
            }
            case 3 -> {
                File dataDirectory2 = new File("data");
                if (dataDirectory2.exists() && dataDirectory2.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory2.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Entrez le nom du restaurant dont vous voulez supprimer une commande :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez l'identifiant de la commande que vous voulez supprimer :");
                            int idCommand = scanner.nextInt();
                            File commandFile = new File("data/" + restaurantName + "/" + "commands" + "/" + idCommand + ".txt");
                            if (commandFile.exists() && commandFile.isFile()) {
                                commandFile.delete();
                                System.out.println("Commande " + idCommand + " supprimée avec succès du restaurant " + restaurantName);
                            } else {
                                System.out.println("Le fichier de la commande n'existe pas.");
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
            }
            case 4 -> {
                File dataDirectory3 = new File("data");
                if (dataDirectory3.exists() && dataDirectory3.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory3.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("Liste des restaurants :");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Entrez le nom du restaurant dont vous voulez afficher une commande :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez l'identifiant de la commande que vous voulez afficher :");
                            int idCommand = scanner.nextInt();
                            File commandFile = new File("data/" + restaurantName + "/" + "commands" + "/" + idCommand + ".txt");
                            if (commandFile.exists() && commandFile.isFile()) {
                                try {
                                    Scanner myReader = new Scanner(commandFile);
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
                                System.out.println("Le fichier de la commande n'existe pas.");
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
            }
            case 5 -> {
            }
            default -> System.out.println("Choix invalide");
        }
    }

    public void updateCommand(String name, int commandName, int price, String selectedDish, String menuName) {
        String filePath = "data/" + name + "/" + name + ".txt";
        String fileDishPath = "data/" + name + "/commands/" + commandName + ".txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileDishPath));
            boolean dishLineFound = false;
    
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("Plats: ")) {
                    lines.set(i, lines.get(i) + (lines.get(i).endsWith(":") ? " " : ", ") + selectedDish);
                    dishLineFound = true;
                }

                
            }
            if(!dishLineFound) {
                lines.add("Plats: " + selectedDish);
            }
            Files.write(Paths.get(fileDishPath), lines);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue.");
            e.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            boolean commandLineFound = false;
            boolean totalPriceLineFound = false;
            int totalPrice = 0;
    
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("Commandes: ")) {
                    lines.set(i, lines.get(i) + (lines.get(i).endsWith(":") ? " " : ", ") + commandName);
                    commandLineFound = true;
                }
                if (lines.get(i).startsWith("Total des recettes (en euros): ")) {
                    totalPrice = Integer.parseInt(lines.get(i).split(":")[1].trim());
                    totalPrice += price;
                    lines.set(i, "Total des recettes (en euros): " + totalPrice);
                    totalPriceLineFound = true;
                }
            }
    
            if (!commandLineFound) {
                lines.add("Commandes: " + commandName);
            }
            
            if (!totalPriceLineFound) {
                lines.add("Total des recettes (en euros): " + price);
            }
    
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue.");
            e.printStackTrace();
        }
    }
}