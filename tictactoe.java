import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[30m";
        String CYAN =  "\u001B[36m";
        String welcome = "Welcome to the TicTacToe game! The rules are the following: ";

        System.out.println(GREEN +  welcome.toUpperCase());
        System.out.println();
        System.out.println("1. The game will contain a 3x3 grid, and you will be asked to select a row and a column.");
        System.out.println("2. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner." + RESET);
        System.out.println();

        int[][] array = new int[3][3];
        boolean catsTurn = true;

        while (true) {
            String currentPlayer = catsTurn ? "Cats" : "Dogs";
            int currentPlayerMarker = catsTurn ? 1 : 2;


            
            System.out.print(CYAN + "Player " + currentPlayer + ": Enter row (0 to 2) -> ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0 to 2) -> " + RESET);
            int column = scanner.nextInt();

          
            if (row >= 0 && row < 3 && column >= 0 && column < 3 && array[row][column] == 0) {
                array[row][column] = currentPlayerMarker;
            } else {
                System.out.println("You can't use this space, please try again.");
                continue;
            }

            if (checkWin(array, currentPlayerMarker)) {
                printArray(array, catsTurn);
                System.out.println("Congratulations User " + currentPlayer + ", you have won!");
                break;
            }

            printArray(array, catsTurn);

            catsTurn = !catsTurn;
        }

        scanner.close();
    }

    public static boolean checkWin(int[][] array, int currentPlayer) {

        for (int i = 0; i < 3; i++) {
            if ((array[i][0] == currentPlayer && array[i][1] == currentPlayer && array[i][2] == currentPlayer) ||
                (array[0][i] == currentPlayer && array[1][i] == currentPlayer && array[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((array[0][0] == currentPlayer && array[1][1] == currentPlayer && array[2][2] == currentPlayer) ||
            (array[0][2] == currentPlayer && array[1][1] == currentPlayer && array[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public static void printArray(int[][] array, boolean catsTurn) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String color;
                String symbol;
                String backgroundColor = "";
                
                if (array[i][j] == 1) {
                    color = "\u001B[95m"; // Pink color for X
                    symbol = "X";
                } else if (array[i][j] == 2) {
                    color = "\u001B[31m"; // Red color for O
                    symbol = "O";
                } else {
                    color = "\u001B[37m"; //white color for empty space           
                    symbol = "0";
                    backgroundColor = "\u001B[40m";
                }
                System.out.print(backgroundColor + color + symbol + "\u001B[0m" + " ");


            }
            System.out.println();
        }
    }
}
