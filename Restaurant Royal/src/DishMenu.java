import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out.println("Here is the list of all the restaurants :");
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }

                System.out.println("Enter the name of the restaurant you want to display all the dishes : ");
                String name = scanner.next();

                File restaurantDirectory2 = new File("data/" + name + "/menus");
                File[] listOfFiles3 = restaurantDirectory2.listFiles();
                System.out.println("Here is the list of all the menus :");
                for (File file : listOfFiles3) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
                System.out.println("Enter the name of the menu you want to display all the dishes : ");
                String menuName = scanner.next();
                File restaurantDirectory = new File("data/" + name + "/menus/" + menuName + "/dishes");
                File[] listOfFiles2 = restaurantDirectory.listFiles();
                System.out.println("Here is the list of all the dishes :");
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
                        scanner.nextLine();
                        System.out.println("Enter the name of the restaurant you want to add a dish to:");
                        String restaurantName = scanner.next();

                        File restaurantDirectory3 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles4 = restaurantDirectory3.listFiles();
                        System.out.println("Here is the list of all the menus :");
                        for (File file : listOfFiles4) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }

                        
                        System.out.println("Enter the name of the menu you want to add a dish to:");
                        String menuName1 = scanner.next();
                        
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            scanner.nextLine();
                            System.out.println("Enter the id of the dish:");
                            int idDish = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the name of the dish:");
                            String dishName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the description of the dish:");
                            String description = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the price of the dish:");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter the calories of the dish:");
                            int calories = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the category of the dish:");
                            String category = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the serving size of the dish:");
                            String servingSize = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the date of adding of the dish (D/M/Y format):");
                            String dateOfAdding = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the cuisine type of the dish:");
                            String cuisineType = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the cook time of the dish:");
                            String cookTime = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the special price of the dish:");
                            double specialPrice = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter the image URL of the dish:");
                            String imageURL = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter the availability of the dish (true/false):");
                            boolean availability = scanner.nextBoolean();
                            scanner.nextLine();
                            Dish dish = new Dish(idDish, availability, dishName, description, price, calories, category, servingSize, dateOfAdding, cuisineType, cookTime, specialPrice, imageURL);
                            String dishString = dish.DishToString(idDish, availability, dishName, description, price, calories, category, servingSize, dateOfAdding, cuisineType, cookTime, specialPrice, imageURL);
                            try {
                                FileWriter myWriter = new FileWriter("data/" + restaurantName + "/menus/" + menuName1 + "/dishes/" + dishName + ".txt");
                                myWriter.write(dishString);
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            System.out.println("Dish " + dishName + " added successfully to restaurant " + restaurantName);
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

                        System.out.println("Enter the name of the restaurant you want to remove a dish from:");
                        String restaurantName = scanner.next();

                        File restaurantDirectory5 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles5 = restaurantDirectory5.listFiles();
                        System.out.println("Here is the list of all the menus :");
                        for (File file : listOfFiles5) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }
                        
                        System.out.println("Enter the name of the menu you want to remove a dish from:");
                        String menuName2 = scanner.next();
                        
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the name of the dish you want to remove:");
                            String dishName = scanner.next();
                            File dishFile = new File("data/" + restaurantName + "/menus/" + menuName2 + "/dishes/" + dishName + ".txt");
                            if (dishFile.exists() && dishFile.isFile()) {
                                dishFile.delete();
                                System.out.println("Dish " + dishName + " removed successfully from restaurant " + restaurantName);
                            } else {
                                System.out.println("Dish file does not exist.");
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

                        System.out.println("Enter the name of the restaurant you want to display a dish from:");
                        String restaurantName = scanner.next();

                        File restaurantDirectory6 = new File("data/" + restaurantName + "/menus");
                        File[] listOfFiles6 = restaurantDirectory6.listFiles();
                        System.out.println("Here is the list of all the menus :");
                        for (File file : listOfFiles6) {
                            if (file.isDirectory()) {
                                System.out.println(file.getName());
                            }
                        }
                        
                        System.out.println("Enter the name of the menu you want to display a dish from:");
                        String menuName3 = scanner.next();
                        
                        File restaurantFile2 = new File("data/" + restaurantName + "/" + restaurantName + ".txt");
                        if (restaurantFile2.exists() && restaurantFile2.isFile()) {
                            System.out.println("Enter the name of the dish you want to display:");
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
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Dish file does not exist.");
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