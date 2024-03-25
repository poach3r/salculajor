package Main;

import Gui.Interactor;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static Backend.Interactor interactorLogic = new Backend.Interactor();
    public static Gui.Frame frame = new Gui.Frame();
    public static Interactor interactorGui = new Interactor();
    public static Gui.Header header = new Gui.Header();
    public static Backend.Config config = new Backend.Config();

    public static void main(String[] args) {
        frame.add(interactorGui, BorderLayout.CENTER);
        frame.add(header, BorderLayout.NORTH);
        frame.pack();
        interactorGui.loadDecoration();
        header.loadDecoration();
    }
}
