package Backend;

import Main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class KeyBindings {
    public Action reload;
    public Action add;
    public Action subtract;
    public Action multiply;
    public Action divide;
    public Action modulo;
    public Action equal;

    public KeyBindings() {
        reload = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");
            }
        };

        add = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("adding");
                Main.interactorLogic.setMode(Modes.ADDING);
            }
        };

        subtract = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("subtracting");
                Main.interactorLogic.setMode(Modes.SUBTRACTING);
            }
        };

        multiply = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("multiplying");
                Main.interactorLogic.setMode(Modes.MULTIPLYING);
            }
        };

        divide = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dividing");
                Main.interactorLogic.setMode(Modes.DIVIDING);
            }
        };

        modulo = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("modulusing?");
                Main.interactorLogic.setMode(Modes.MODULO);
            }
        };

        equal = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Main.interactorLogic.getMode()) {
                    case Modes.ADDING  -> { Main.interactorLogic.setValue(Main.interactorLogic.getLastDigit()[0] + Main.interactorLogic.getLastDigit()[1]); }
                    case Modes.SUBTRACTING -> { Main.interactorLogic.setValue(Main.interactorLogic.getLastDigit()[0] - Main.interactorLogic.getLastDigit()[1]); }
                    case Modes.MULTIPLYING -> { Main.interactorLogic.setValue(Main.interactorLogic.getLastDigit()[0] * Main.interactorLogic.getLastDigit()[1]); }
                    case Modes.DIVIDING -> { Main.interactorLogic.setValue((float) Main.interactorLogic.getLastDigit()[0] / (float) Main.interactorLogic.getLastDigit()[1]); }
                    case Modes.MODULO -> { Main.interactorLogic.setValue(Main.interactorLogic.getLastDigit()[0] % Main.interactorLogic.getLastDigit()[1]); }
                    default -> {
                        System.err.println("you fucked it up!");
                    }
                }

                Main.interactorLogic.setMode(Modes.RESULT);
                Main.interactorLogic.setLastDigit(0, 0);
                Main.interactorLogic.setLastDigit(1, 0);
                System.out.println(String.valueOf(Main.interactorLogic.getValue()));
            }
        };
    }
}
