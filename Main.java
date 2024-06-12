import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0; 

        while (choice != 4) {
            System.out.println("\nBook Management Application.");
            System.out.println("\nHere are your choices:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. View all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 1) {
                System.out.print("Please add book title: ");
                String title = scanner.nextLine();
                System.out.print("Could you add the book author as well? : ");
                String author = scanner.nextLine();
                bookList.add(new Book(title, author));
                System.out.println("Book has been added to the application.");
            } else if (choice == 2) {
                System.out.print("Enter the title of the book you would like to remove: ");
                String titleToRemove = scanner.nextLine();
                boolean removed = false;
                for (Book book : bookList) {
                    if (book.getTitle().equalsIgnoreCase(titleToRemove)) {
                        bookList.remove(book);
                        removed = true;
                        break;
                    }
                }
                if (removed) {
                    System.out.println("Book has been removed.");
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                if (bookList.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                }
            } else if (choice != 4) {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the application, please wait...");
        scanner.close();
    }
}
