package za.co.wethinkcode.robotworlds;

import java.util.Scanner;

public class Play {
    static Scanner scanner;

    public static void main(String[] args) {
        Robot robot;
        scanner = new Scanner(System.in);

        String name = getInput("What do you want to name your robot?");
        System.out.println("Hello Kiddo!");
        robot = new Robot(name);
        System.out.println(robot.toString()); // TODO: Should this be here?

        Command command;
        boolean shouldContinue = true;
        do {
            String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();
            try {


                command = Command.create(instruction);
                shouldContinue = robot.handleCommand(command);


            } catch (IllegalArgumentException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
            }
            System.out.println(robot);
            if(robot.getStatus() == "Fired one shot"
                    || robot.getStatus() == "Reloaded") {
                System.out.println(robot.getName() + " > Shots left: " + robot.remainingShots);
            }
        } while (shouldContinue);

    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        while (input.isBlank()) {
            System.out.println(prompt);
            input = scanner.nextLine();
        }
        return input;
    }
}

