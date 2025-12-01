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


    public static void main(String[] args) {
        try {
            System.out.println(Task1.Part1(50, "inputs/input_task1_1.txt"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }





}