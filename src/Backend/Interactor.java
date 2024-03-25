package Backend;

import Main.Main;

public class Interactor {
    private char mode;
    private double value;
    private int lastDigit[];

    public Interactor() {
        mode = Modes.RESULT;
        value = 0.0;
        lastDigit = new int[2];
        lastDigit[0] = 0;
        lastDigit[1] = 0;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
        Main.header.updateText();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int[] getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(int index, int lastDigit) {
        this.lastDigit[index] = lastDigit;
    }

    public void digitUpdate(int i) {
        System.out.println(String.valueOf(i));
        if(Main.interactorLogic.getMode() == Modes.RESULT)
            lastDigit[0] = Main.interactorLogic.getLastDigit()[0] * 10 + i;

        else
            lastDigit[1] = Main.interactorLogic.getLastDigit()[1] * 10 + i;
    }
}

