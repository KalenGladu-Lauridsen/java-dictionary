import java.util.InputMismatchException;
import java.util.Scanner;

public class DictionaryTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dictionary dict = new Dictionary();
        int option = 0;
        while (option != 5) {
            try {
                System.out.println(
                        "*************************************\n               Dictionary\n*************************************");
                System.out.println("1. Add words to the Dictionary");
                System.out.println("2. Search a word in the Dictionary");
                System.out.println("3. Display number of nodes in the Dictionary");
                System.out.println("4. Reset Dictionary");
                System.out.println("5. Exit");
                System.out.print("Enter your option: ");
                option = scan.nextInt();
                System.out.println();
                switch (option) {
                    case 1:
                        int subOption = 0;
                        while (subOption != 3) {
                            System.out.println("1. Read text from the user");
                            System.out.println("2. Read text from a file");
                            System.out.println("3. Go back to main menu");
                            System.out.print("Enter your option: ");
                            subOption = scan.nextInt();
                            // Empties stream
                            scan.nextLine();

                            switch (subOption) {
                                case 1:
                                    System.out.println("Enter text: ");
                                    String word = scan.nextLine();
                                    dict.readFromUser(word.split(" "));
                                    dict.addToTree();
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("\nEnter name of file to be read:");
                                    String fileName = scan.next();
                                    System.out.println("Reading from file...");
                                    dict.readFromFile(fileName);
                                    dict.addToTree();
                                    System.out.println("Done\n");
                                    break;
                                case 3:
                                    System.out.println("Exiting from here... going back to main menu\n");
                                    break;
                                default:
                                    System.out.println("Invalid option...\n");
                            }
                        }
                        break;
                    case 2:
                        if (dict.isEmpty() == 0) {
                            System.out.println("Enter word you want to search: ");
                            String word = scan.next();
                            if (dict.search(word) == -1)
                                System.out.println("Word searched was not found...\n");
                            else {
                                System.out.print(word + " occurs " + dict.search(word) + " times\n\n");
                            }
                        } else
                            System.out.println("Unable to search... map is empty\n");
                        break;
                    case 3:
                        System.out.print("Dictionary has: " + dict.nodeNum() + " nodes\n\n");
                        break;
                    case 4:
                        if (dict.isEmpty() == 0) {
                            dict.reset();
                            System.out.println("Dictionary has been reset\n");
                        } else
                            System.out.println("Map was already empty...\n");
                        break;
                    case 5:
                        System.out.println("Have a good day!");
                        break;
                    default:
                        System.out.println("Invalid choice... please chose an option above\n");
                }
            } catch (InputMismatchException ime) {
                String error = scan.next();
                System.err.println("\nInput Mismatch Exception\n");
            }
        }
        scan.close();
    }
}
