import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Task1 {

    public static int Part1(int currentPosition, String filePath) throws IOException {
        int counter = 0;

        String line;
        char direction;
        int number;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            if (currentPosition < 0)
                currentPosition += 100;

            direction = line.charAt(0);
            number = Integer.parseInt(line.substring(1));

            if (direction == 'R')
                currentPosition = (currentPosition + number) % 100;
            else
                currentPosition = (currentPosition - number) % 100;
            if (currentPosition == 0)
                counter++;
        }
        return counter;
    }



    public static int Part2(int currentPosition, String filePath) throws IOException {
        int counter = 0;

        String line;
        char direction;
        int number;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {

            direction = line.charAt(0);
            number = Integer.parseInt(line.substring(1));

            if (currentPosition < 0)
                currentPosition += 100;

            if (direction == 'R') {
                counter += (currentPosition + number) / 100;
                currentPosition = (currentPosition + number) % 100;
            }
            else {
                currentPosition -= number;
                // -1 because 99 is the last valid value before the dial turns back to 0.
                // Symmetric to 100 when turning right
                while (currentPosition < -1 ) {
                    currentPosition += 100;
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Task1.Part1(50, "inputs/input_task1.txt"));
            System.out.println(Task1.Part2(50, "inputs/input_task1.txt"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}