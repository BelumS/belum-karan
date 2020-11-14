package org.example.numbers;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.example.constants.ValueConstants;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

/**
 * A simple clock where it plays a sound after X number of minutes/seconds
 * or at a particular time
 */
public final class AlarmClock {
    private static Time time = new Time();
    private static Time alarm = new Time(0, 0);

    private AlarmClock() {
    }

    public static void displayAlarm(Scanner scanner) throws Exception {
        try (scanner) {
            new Time().showCurrentTime();
            System.out.println();

            System.out.println("Do you want to set the alarm?: [Y]/[N]");
            String choice = scanner.next();

            if (ValueConstants.VALUE_Y.equalsIgnoreCase(choice)) {
                setAlarm(scanner);
            }

            System.out.println("Do you want to set the time?: [Y]/[N]");
            String setTime = scanner.next();

            if (ValueConstants.VALUE_Y.equalsIgnoreCase(setTime)) {
                System.out.print("Enter the hour: ");
                String hour = scanner.next();
                System.out.println();

                System.out.print("Enter the minute: ");
                String minute = scanner.next();
                System.out.println();

                time = new Time(Integer.parseInt(hour), Integer.parseInt(minute));
                System.out.println("The updated time is: [" + time + "]");
                System.out.println();
            }

            if (time.toString().equalsIgnoreCase(alarm.toString())) {
                ring(alarm);
            }
        } catch (Exception e) {
            System.err.println("An Exception occurred: " + e);
            throw e;
        }
    }

    public static void setAlarm(Scanner scanner) {
        System.out.print("Enter the hour: ");
        String hour = scanner.next();
        System.out.println();

        System.out.print("Enter the minute: ");
        String minute = scanner.next();
        System.out.println();

        alarm = new Time(Integer.parseInt(hour), Integer.parseInt(minute));
        System.out.println("The alarm has been set for [" + alarm + "]");
        System.out.println();
    }

    private static void ring(Time alarm) throws InterruptedException, IOException, JavaLayerException {
        File file = new File("src/main/resources/media/Alarm-Clock-Sound.mp3");
        InputStream in = new FileInputStream(file);
        try (in) {
            System.out.println("The Alarm set for " + alarm + " has gone off!");
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(file);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));

            InputStream buff = new BufferedInputStream(in);
            Player player = new Player(buff);
            long length = in.available();
            player.play();

            Thread.sleep(3000);
            snooze(player);
        } catch (Exception e) {
            System.err.println("An Exception occurred before snoozing!" + e);
            throw e;
        }
    }

    public static void snooze(Player player) {
        System.out.println("The snooze button was pressed, the alarm is turned off.");
        player.close();

        System.exit(0);
    }
}
