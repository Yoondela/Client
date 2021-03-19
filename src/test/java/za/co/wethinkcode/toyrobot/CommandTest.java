package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {
    @Test
    void getHelpName() {
        HelpCommand test = new HelpCommand();
        assertEquals("help", test.getName());
    }

    @Test
    void getForwardName() {
        Command test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());

    }

//    @Test
//    void getName(){
//        Command test = new Command("test");
//        assertEquals("test", test.getName());
//    }
//
//    @Test
//    void getNameAndArgment() {
//        Command test = new Command("test", "100");
//        assertEquals("test", test.getName());
//        assertEquals("100", test.getArgument());
//    }
//
//    @Test
//    void trimAndConvertName(){
//        Command command = new Command("Test ");
//        assertEquals("test", command.getName());
//    }

    @Test
    void createCommand() {
        Command forward = Command.create("forward 10");
        assertEquals("forward", forward.getName());
        assertEquals("10", forward.getArgument());

        Command shutdown = Command.create("shutdown");
        assertEquals("off", shutdown.getName());

        Command help = Command.create("help");
        assertEquals("help", help.getName());
    }

    @Test
    void executeForward() {
        Robot robot = new Robot("CrashTestDummy");
        Command forward100 = Command.create("forward 10");
        assertTrue(forward100.execute(robot));
        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void executeHelp(){
        Robot robot = new Robot("CrashTestDummy");
        Command help = Command.create("help");
        assertTrue(help.execute(robot));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
    }

    @Test
    void executeShutdown(){
        Robot robot = new Robot("CrashTestDummy");
        Command off = Command.create("off");
        assertTrue(off.execute(robot));
        assertEquals("Shutting down...", robot.getStatus());
    }

}
