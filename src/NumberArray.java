import java.util.Scanner;

public class NumberArray {
    public static void displayArray(double[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("%6.3f", array[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void randomElement(double[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = Math.random() * 10;
            }
        }
    }

    public static void addElement(double[][] array) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("Enter element %d-%d: ", row, col);
                array[row][col] = scanner.nextDouble();
            }
        }
    }

    public static double sumColumn(double[][] array, int columnIndex) {
        double total = 0;
        for (int row = 0; row < array.length; row++) {
            total += array[row][columnIndex];
        }
        return total;
    }

    public static double sumRow(double[][] array, int rowIndex) {
        double total = 0;
        for (int col = 0; col < array[rowIndex].length; col++) {
            total += array[rowIndex][col];
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isValidChoice = false;
        boolean isValidNum = false;
        boolean isValidIndex = false;
        int row;
        int col;

        do {
            System.out.print("Enter number of rows: ");
            row = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            col = scanner.nextInt();
            if (row >= 0 && row <= 10 && col >= 0 && col <= 10) {
                isValidNum = true;
            } else {
                System.out.println("Invalid input. Minimum is 0 and maximum is 10");
            }
        } while (!isValidNum);

        double[][] demoArray = new double[row][col];
        do {
            System.out.println("1. Enter Element");
            System.out.println("2. Random Element");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            if (choice == 1 || choice == 2) {
                isValidChoice = true;
            } else {
                System.out.println("Invalid choice! Please choose again!");
            }
        } while (!isValidChoice);

        switch (choice) {
            case 1:
                addElement(demoArray);
                break;
            case 2:
                randomElement(demoArray);
                break;
        }
        System.out.println();
        System.out.println("Here is your array: ");
        displayArray(demoArray);

        int colIndex;
        do {
            System.out.print("Enter the index of column you want to summarize: ");
            colIndex = scanner.nextInt();
            if (colIndex >= 0 && colIndex <= demoArray[0].length) {
                isValidIndex = true;
            } else {
                System.out.println("Invalid Input! Please enter again");
            }
        } while (!isValidIndex);
        double totalCol = sumColumn(demoArray,colIndex);
        System.out.printf("Summarize of column %d is %f", colIndex, totalCol);
        System.out.println();


        int rowIndex;
        isValidIndex = false;
        do {
            System.out.print("Enter the index of row you want to summarize: ");
            rowIndex = scanner.nextInt();
            if (rowIndex >= 0 && rowIndex <= demoArray.length) {
                isValidIndex = true;
            } else {
                System.out.println("Invalid Input! Please enter again");
            }
        } while (!isValidIndex);
        double totalRow = sumRow(demoArray,rowIndex);
        System.out.printf("Summarize of row %d is %f", rowIndex, totalRow);
        System.out.println();
    }
}
