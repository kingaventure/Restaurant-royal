import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommandMenu {

    private Scanner scanner;

    public CommandMenu(Scanner scanner) {
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

                System.out.println("Enter the name of the restaurant you want to display all the commands : ");
                String name = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/commands");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Here is the list of all the commands :");
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

                        System.out.println("Enter the name of the restaurant you want to add a command to:");
                        String restaurantName = scanner.next();
                        scanner.nextLine();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the id of the command:");
                            int numberCommand = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the total price of the command:");
                            double commandTotalPrice = scanner.nextDouble();
                            scanner.nextLine();
                            Command command = new Command(numberCommand, commandTotalPrice);
                            String commandString = command.CommandToString();
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/" + "commands" + "/" + numberCommand + ".txt");
                                myWriter.write(commandString);
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            System.out.println("Command " + numberCommand + " added successfully to restaurant " + restaurantName);
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

                        System.out.println("Enter the name of the restaurant you want to remove a command from:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the id of the command you want to remove:");
                            int idCommand = scanner.nextInt();
                            File commandFile = new File("data/" + restaurantName + "/" + "commands" + "/" + idCommand + ".txt");
                            if (commandFile.exists() && commandFile.isFile()) {
                                commandFile.delete();
                                System.out.println("Command " + idCommand + " removed successfully from restaurant " + restaurantName);
                            } else {
                                System.out.println("Command file does not exist.");
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

                        System.out.println("Enter the name of the restaurant you want to display a command from:");
                        String restaurantName = scanner.next();
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the id of the command you want to display:");
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
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Command file does not exist.");
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