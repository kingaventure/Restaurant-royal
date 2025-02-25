import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeMenu {

    private Scanner scanner;

    public EmployeMenu(Scanner scanner) {
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

                System.out.println("Entrez le nom du restaurant dont vous voulez afficher tous les employés : ");
                String name = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/employes/");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Voici la liste de tous les employés :");
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

                        System.out.println("Entrez le nom du restaurant auquel vous voulez ajouter un employé :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez l'identifiant de l'employé :");
                            int idEmploye = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Entrez le nom de famille de l'employé :");
                            String lastName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le prénom de l'employé :");
                            String firstName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le rôle de l'employé (Caissier, cuisinier, serveur) :");
                            String role = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez la date d'embauche de l'employé (format J/M/A) :");
                            String employmentDate = scanner.next();
                            scanner.nextLine();
                            System.out.println("Entrez le salaire de l'employé :");
                            int salary = scanner.nextInt();
                            scanner.nextLine();
                            Employe employe = new Employe(idEmploye, lastName, firstName, role, employmentDate, salary);
                            String employeString = employe.EmployeToString(idEmploye, lastName, firstName, role, employmentDate, salary);
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/" + "employes" + "/" + lastName + ".txt");
                                myWriter.write(employeString);
                                myWriter.close();
                                System.out.println("Écriture réussie dans le fichier.");
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue.");
                                e.printStackTrace();
                            }
                            System.out.println("Employé " + firstName + " ajouté avec succès au restaurant " + restaurantName);
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

                        System.out.println("Entrez le nom du restaurant dont vous voulez supprimer un employé :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez le nom de famille de l'employé que vous voulez supprimer :");
                            String lastName = scanner.next();
                            File employeFile = new File("data/" + restaurantName + "/" + lastName + ".txt");
                            if (employeFile.exists() && employeFile.isFile()) {
                                employeFile.delete();
                                System.out.println("Employé " + lastName + " supprimé avec succès du restaurant " + restaurantName);
                            } else {
                                System.out.println("Le fichier de l'employé n'existe pas.");
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

                        System.out.println("Entrez le nom du restaurant dont vous voulez afficher un employé :");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Entrez le nom de famille de l'employé que vous voulez afficher :");
                            String lastName = scanner.next();
                            File employeFile = new File("data/" + restaurantName + "/" + "employes" + "/" + lastName + ".txt");
                            if (employeFile.exists() && employeFile.isFile()) {
                                try {
                                    Scanner myReader = new Scanner(employeFile);
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
                                System.out.println("Le fichier de l'employé n'existe pas.");
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
}