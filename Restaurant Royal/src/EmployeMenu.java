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
                System.out.println("Here is the list of all the restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }

                System.out.println("Enter the name of the restaurant you want to display all the employes : ");
                String name = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/employes/");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Here is the list of all the employes :");
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
                        System.out.println("List of restaurants:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Enter the name of the restaurant you want to add an employe to:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the id of the employe:");
                            int idEmploye = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the last name of the employe:");
                            String lastName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the first name of the employe:");
                            String firstName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the role of the employe (Caissier, cuisinier, serveur):");
                            String role = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the employment date of the employe (D/M/Y format):");
                            String employmentDate = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the salary of the employe:");
                            int salary = scanner.nextInt();
                            scanner.nextLine();
                            Employe employe = new Employe(idEmploye, lastName, firstName, role, employmentDate, salary);
                            String employeString = employe.EmployeToString(idEmploye, lastName, firstName, role, employmentDate, salary);
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/" + "employes" + "/" + lastName + ".txt");
                                myWriter.write(employeString);
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            System.out.println("Employe " + firstName + " added successfully to restaurant " + restaurantName);
                        } else {
                            System.out.println("Restaurant file does not exist.");
                        }
                    } else {
                        System.out.println("No restaurants found.");
                    }
                } else {
                    System.out.println("Data directory does not exist.");
                }
                break;
            case 3:
                File dataDirectory2 = new File("data");
                if (dataDirectory2.exists() && dataDirectory2.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory2.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("List of restaurants:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Enter the name of the restaurant you want to remove an employe from:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the last name of the employe you want to remove:");
                            String lastName = scanner.next();
                            File employeFile = new File("data/" + restaurantName + "/" + lastName + ".txt");
                            if (employeFile.exists() && employeFile.isFile()) {
                                employeFile.delete();
                                System.out.println("Employe " + lastName + " removed successfully from restaurant " + restaurantName);
                            } else {
                                System.out.println("Employe file does not exist.");
                            }
                        } else {
                            System.out.println("Restaurant file does not exist.");
                        }
                    } else {
                        System.out.println("No restaurants found.");
                    }
                } else {
                    System.out.println("Data directory does not exist.");
                }
                break;
            case 4:
                File dataDirectory3 = new File("data");
                if (dataDirectory3.exists() && dataDirectory3.isDirectory()) {
                    String[] restaurantDirectories = dataDirectory3.list();
                    if (restaurantDirectories != null && restaurantDirectories.length > 0) {
                        System.out.println("List of restaurants:");
                        for (String restaurantName : restaurantDirectories) {
                            System.out.println(restaurantName);
                        }

                        System.out.println("Enter the name of the restaurant you want to display an employe from:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the last name of the employe you want to display:");
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
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Employe file does not exist.");
                            }
                        } else {
                            System.out.println("Restaurant file does not exist.");
                        }
                    } else {
                        System.out.println("No restaurants found.");
                    }
                } else {
                    System.out.println("Data directory does not exist.");
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}