package za.co.wethinkcode.toyrobot;

import java.util.Locale;

public abstract class Command {
    private final String name;
    private final String argument;

    public Command(String name){
        this.name = name.trim().toLowerCase();
        this.argument = null;
    }
    public abstract boolean execute(Robot target);

    public Command(String name, String argument){
        this.name = name.trim().toLowerCase();
        this.argument = argument;
    }

    public String getName(){
        return name;
    }

    public String getArgument() {
        return argument;
    }

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        switch (args[0]){
            case "off":
            case "shutdown":
                return new ShutdownCommand();
            case "help":
                return new HelpCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}
