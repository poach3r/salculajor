package Main;

import Gui.Interactor;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static Backend.Interactor interactorLogic = new Backend.Interactor();
    public static Gui.Frame frame = new Gui.Frame();
    public static Interactor interactorGui = new Interactor();
    public static Gui.Header header = new Gui.Header();
    //public static Backend.FileIO fileIO = new Backend.FileIO();
    public static Backend.Config config = new Backend.Config();

    public static void main(String[] args) {
        frame.add(interactorGui, BorderLayout.CENTER);
        frame.add(header, BorderLayout.NORTH);
        frame.pack();

        if(args.length >= 1) {
            try {
                load(args[0]);
            } catch (FileNotFoundException e) {
                System.err.println("Failed to load file: " + e);
                System.exit(1);
            }
        }

        else
            System.out.println("No file provided in arguments, continuing with instantiated variables");

        interactorGui.loadDecoration();
        header.loadDecoration();
    }

    public static void load(String file) throws FileNotFoundException {
        //fileIO.setFile(file);
        //fileIO.input();

        Main.header.updateText();
    }
}
