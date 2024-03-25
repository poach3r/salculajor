package Gui;

import Backend.Modes;
import Main.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interactor extends JPanel {
    private Font font;
    private Border margin;
    private JButton[] numButtons;
    private JButton[] operatorButtons;
    private Backend.KeyBindings keyBindings;
    private int marginInt;

    public Interactor() {
        marginInt = 0;
        keyBindings = new Backend.KeyBindings();
        font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        margin = BorderFactory.createEmptyBorder();

        setLayout(new GridLayout(5, 3));

        numButtons = new JButton[10];

        operatorButtons = new JButton[5];
        operatorButtons[0] = new JButton("+");
        operatorButtons[0].addActionListener(e -> {
            Main.interactorLogic.setMode(Modes.ADDING);
        });

        operatorButtons[1] = new JButton("-");
        operatorButtons[1].addActionListener(e -> {
            Main.interactorLogic.setMode(Modes.SUBTRACTING);
        });

        operatorButtons[2] = new JButton("x");
        operatorButtons[2].addActionListener(e -> {
            Main.interactorLogic.setMode(Modes.MULTIPLYING);
        });

        operatorButtons[3] = new JButton("/");
        operatorButtons[3].addActionListener(e -> {
            Main.interactorLogic.setMode(Modes.DIVIDING);
        });

        operatorButtons[4] = new JButton("=");
        operatorButtons[4].addActionListener(e -> {
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
        });

        setVisible(true);

        keybindingsInit();
    }

    public void loadDecoration() {
        setLayout(new GridLayout(5, 3, marginInt / 2, marginInt / 2));
        setBackground(Main.config.colors[0]);
        setBorder(margin);

        for(int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(font);
            numButtons[i].setBackground(Main.config.colors[2]);
            numButtons[i].setForeground(Main.config.colors[0]);
            int finalI = i;
            numButtons[i].addActionListener(e -> {
                Main.interactorLogic.digitUpdate(finalI);
            });

            add(numButtons[i]);
        }

        for(int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i].setBackground(Main.config.colors[2]);
            operatorButtons[i].setForeground(Main.config.colors[0]);
            operatorButtons[i].setFont(font);
            add(operatorButtons[i]);
        }
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Border getMargin() {
        return margin;
    }

    public void setMargin(Border margin) {
        this.margin = margin;
    }

    // THIS SUCKS
    public void keybindingsInit() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), "reload");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), "add");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "subtract");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.SHIFT_DOWN_MASK), "multiply");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "divide");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.SHIFT_DOWN_MASK), "modulo");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equal");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equal");
        getActionMap().put("reload", keyBindings.reload);
        getActionMap().put("add", keyBindings.add);
        getActionMap().put("subtract", keyBindings.subtract);
        getActionMap().put("multiply", keyBindings.multiply);
        getActionMap().put("divide", keyBindings.divide);
        getActionMap().put("modulo", keyBindings.modulo);
        getActionMap().put("equal", keyBindings.equal);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public int getMarginInt() {
        return marginInt;
    }

    public void setMarginInt(int marginInt) {
        this.marginInt = marginInt;
    }
}
