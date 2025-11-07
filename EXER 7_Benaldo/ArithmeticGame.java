import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArithmeticGame extends JFrame {

    private JTextField answerField;
    private JPanel questionPanel; 
    private JLabel num1Label, operatorLabel, num2Label, countLabel, feedbackLabel;
    
    private int correctCount = 0;   
    private int wrongCount = 0; 
    private int correctResult;
    private String currentOperator = "+"; 
    private int maxNumber = 10; 
    
    private final String[] OPERATION_LABELS = {"Add (+)", "Subtract (-)", "Multiply (*)", "Divide (/)", "Modulo (%)"};
    private final String[] OPERATION_SIGNS = {"+", "-", "*", "/", "%"};
    private final String[] LEVEL_LABELS = {"Level 1 (0-10)", "Level 2 (0-100)", "Level 3 (0-999)"};
    private final int[] LEVEL_MAXES = {10, 100, 999}; 
    
    private Random random = new Random();
    private final Color defaultBackgroundColor = UIManager.getColor("Panel.background");

    private final Color PURPLE_DARK = new Color(75, 0, 130); 
    private final Color PURPLE_MEDIUM = new Color(138, 43, 226); 
    private final Color LAVENDER_LIGHT = new Color(230, 230, 250); 
    private final Color ERROR_RED = new Color(178, 34, 34); 
    private final Color ACTIVE_BUTTON_COLOR = new Color(0, 128, 0); 

    private JButton activeOperationButton;
    private JButton activeLevelButton;


    public ArithmeticGame() {
        super("Arithmetic Game"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); 
        
        JLabel headerLabel = new JLabel("Arithmetic Game", JLabel.CENTER); 
        headerLabel.setFont(new Font("Inter", Font.BOLD, 24));
        headerLabel.setForeground(PURPLE_DARK);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        JPanel gameAreaPanel = createGameAreaPanel();
        add(gameAreaPanel, BorderLayout.CENTER);
        
        SwingUtilities.invokeLater(() -> {
            if (activeOperationButton != null) activeOperationButton.doClick();
            if (activeLevelButton != null) activeLevelButton.doClick();
            updateCountsDisplay(); 
        });
        
        pack(); 
        setMinimumSize(new Dimension(850, 550));
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    private JLabel createMathLabel(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        label.setForeground(PURPLE_DARK); 
        label.setOpaque(true); 
        label.setBackground(Color.WHITE); 
        label.setBorder(new LineBorder(PURPLE_MEDIUM, 2, true)); 
        label.setPreferredSize(new Dimension(100, 70));
        return label;
    }

    private JButton createControlButton(String text, String actionCommand, ActionListener listener) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setFont(new Font("Inter", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(150, 35)); 
        button.setForeground(PURPLE_DARK);
        button.setBackground(LAVENDER_LIGHT);
        button.setBorder(BorderFactory.createLineBorder(PURPLE_MEDIUM, 1));
        button.addActionListener(listener);
        return button;
    }

    private JPanel createOperationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PURPLE_MEDIUM), 
            "Select Operation", 
            TitledBorder.LEFT, TitledBorder.TOP, 
            new Font("Inter", Font.BOLD, 14), PURPLE_DARK)); 

        ActionListener operationListener = e -> {
            JButton clickedButton = (JButton)e.getSource();
            
            if (activeOperationButton != null) {
                activeOperationButton.setBackground(LAVENDER_LIGHT);
                activeOperationButton.setForeground(PURPLE_DARK);
            }
            
            activeOperationButton = clickedButton;
            activeOperationButton.setBackground(ACTIVE_BUTTON_COLOR);
            activeOperationButton.setForeground(Color.WHITE);
            
            int opIndex = Integer.parseInt(e.getActionCommand());
            currentOperator = OPERATION_SIGNS[opIndex];
            generateNewProblem(); 
        };

        for (int i = 0; i < OPERATION_LABELS.length; i++) {
            JButton opButton = createControlButton(OPERATION_LABELS[i], String.valueOf(i), operationListener);
            opButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
            panel.add(opButton);
            panel.add(Box.createRigidArea(new Dimension(0, 5))); 
            if (OPERATION_SIGNS[i].equals("+")) {
                activeOperationButton = opButton; 
            }
        }
        return panel;
    }

    private JPanel createLevelPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PURPLE_MEDIUM), 
            "Select Level", 
            TitledBorder.LEFT, TitledBorder.TOP, 
            new Font("Inter", Font.BOLD, 14), PURPLE_DARK)); 

        ActionListener levelListener = e -> {
            JButton clickedButton = (JButton)e.getSource();
            
            if (activeLevelButton != null) {
                activeLevelButton.setBackground(LAVENDER_LIGHT);
                activeLevelButton.setForeground(PURPLE_DARK);
            }
            
            activeLevelButton = clickedButton;
            activeLevelButton.setBackground(ACTIVE_BUTTON_COLOR);
            activeLevelButton.setForeground(Color.WHITE);
            
            int levelIndex = Integer.parseInt(e.getActionCommand());
            maxNumber = LEVEL_MAXES[levelIndex];
            
            generateNewProblem(); 
        };

        for (int i = 0; i < LEVEL_LABELS.length; i++) {
            JButton levelButton = createControlButton(LEVEL_LABELS[i], String.valueOf(i), levelListener);
            levelButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
            panel.add(levelButton);
            panel.add(Box.createRigidArea(new Dimension(0, 5))); 
            if (i == 0) {
                activeLevelButton = levelButton; 
            }
        }
        return panel;
    }


    private JPanel createGameAreaPanel() {
        JPanel equationAndActionsWrapper = new JPanel(new BorderLayout(20, 0));
        
        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)); 
        
        Font mathFont = new Font("Monospaced", Font.BOLD, 48);

        num1Label = createMathLabel("0", mathFont);
        operatorLabel = createMathLabel("+", mathFont);
        num2Label = createMathLabel("0", mathFont);
        
        JLabel equalsLabel = createMathLabel("=", mathFont);
        equalsLabel.setForeground(PURPLE_MEDIUM); 
        equalsLabel.setPreferredSize(new Dimension(50, 70)); 
        equalsLabel.setBorder(null); 

        answerField = new JTextField(4); 
        answerField.setFont(mathFont);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setMaximumSize(new Dimension(150, 70));
        answerField.setBorder(new LineBorder(PURPLE_DARK, 3, true)); 
        answerField.setBackground(LAVENDER_LIGHT); 
        answerField.addActionListener(this::checkAnswer); 
        
        questionPanel.add(num1Label);
        questionPanel.add(operatorLabel);
        questionPanel.add(num2Label);
        questionPanel.add(equalsLabel);
        questionPanel.add(answerField);
        
        equationAndActionsWrapper.add(questionPanel, BorderLayout.CENTER); 

        equationAndActionsWrapper.add(createActionPanel(), BorderLayout.EAST);
        
        
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BoxLayout(mainContentPanel, BoxLayout.Y_AXIS));
        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        mainContentPanel.add(equationAndActionsWrapper);
        mainContentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JPanel controlGroupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        controlGroupPanel.add(createOperationPanel());
        controlGroupPanel.add(createLevelPanel());
        mainContentPanel.add(controlGroupPanel);
        mainContentPanel.add(Box.createRigidArea(new Dimension(0, 20)));


        feedbackLabel = new JLabel("Ready to play!", JLabel.CENTER);
        feedbackLabel.setFont(new Font("Inter", Font.ITALIC, 16));
        feedbackLabel.setForeground(PURPLE_DARK);
        feedbackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContentPanel.add(feedbackLabel);

        return mainContentPanel;
    }

    private JPanel createActionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0)); 
        
        Dimension generalButtonDim = new Dimension(100, 30); 
        
        JButton submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Inter", Font.BOLD, 20)); 
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        submitButton.setMaximumSize(new Dimension(120, 45)); 
        submitButton.setPreferredSize(new Dimension(120, 45)); 
        submitButton.setBackground(PURPLE_MEDIUM); 
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this::checkAnswer); 
        
        countLabel = new JLabel("Score:", JLabel.CENTER); 
        countLabel.setFont(new Font("Inter", Font.BOLD, 14));
        countLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton continueButton = new JButton("NEXT");
        continueButton.setFont(new Font("Inter", Font.BOLD, 14));
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueButton.setMaximumSize(generalButtonDim);
        continueButton.setPreferredSize(generalButtonDim);
        continueButton.setBackground(PURPLE_MEDIUM); 
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> generateNewProblem());
        
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Inter", Font.BOLD, 14));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setMaximumSize(generalButtonDim);
        exitButton.setPreferredSize(generalButtonDim);
        exitButton.setBackground(ERROR_RED); 
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0)); 

        panel.add(submitButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(countLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(continueButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(exitButton);
        panel.add(Box.createVerticalGlue()); 

        return panel;
    }
    
    private void generateNewProblem() {
        int num1, num2;
        
        String currentOp = currentOperator;
        int max = maxNumber;

        if (currentOp.equals("/") || currentOp.equals("%")) {
            
            int divisorLimit = (max > 2) ? (max / 2) : 1;
            num2 = random.nextInt(divisorLimit) + 1; 
            
            int maxQuotient = (max / num2) > 0 ? (max / num2) : 1;
            int quotient = random.nextInt(maxQuotient) + 1;
            
            num1 = num2 * quotient; 
            
        } else {
            num1 = random.nextInt(max) + 1; 
            num2 = random.nextInt(max) + 1;
        }

        if (currentOp.equals("-") && num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        num1Label.setText(String.valueOf(num1));
        operatorLabel.setText(currentOp);
        num2Label.setText(String.valueOf(num2));

        switch (currentOp) {
            case "+": correctResult = num1 + num2; break;
            case "-": correctResult = num1 - num2; break;
            case "*": correctResult = num1 * num2; break;
            case "/": correctResult = num1 / num2; break;
            case "%": correctResult = num1 % num2; break;
            default: correctResult = 0; break;
        }

        answerField.setText(""); 
        feedbackLabel.setForeground(PURPLE_DARK);
        feedbackLabel.setText("Solve the problem!");
        questionPanel.setBackground(defaultBackgroundColor); 
        answerField.requestFocusInWindow(); 
    }
    
    private void updateCountsDisplay() {
        countLabel.setText(String.format(
            "<html><div style='text-align: center;'>SCORE:<br><b>Correct:</b> <font color='#2E8B57'>%d</font><br><b>Wrong:</b> <font color='#B22222'>%d</font></div></html>", 
            correctCount, wrongCount));
    }

    private void checkAnswer(ActionEvent e) {
        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            
            if (userAnswer == correctResult) {
                correctCount++;
                
                feedbackLabel.setForeground(PURPLE_DARK); 
                feedbackLabel.setText(" CORRECT! You got it! "); 
                questionPanel.setBackground(new Color(152, 251, 152)); 
                
            } else {
                wrongCount++;
                
                feedbackLabel.setForeground(ERROR_RED); 
                feedbackLabel.setText(" Incorrect. The correct answer was " + correctResult);
                questionPanel.setBackground(new Color(255, 160, 122)); 
            }
            
            updateCountsDisplay(); 

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    questionPanel.setBackground(defaultBackgroundColor); 
                    generateNewProblem();
                    ((Timer)evt.getSource()).stop(); 
                }
            });
            timer.setRepeats(false);
            timer.start();
            
        } catch (NumberFormatException ex) {
            feedbackLabel.setForeground(Color.ORANGE);
            feedbackLabel.setText("Please enter a valid number.");
            answerField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArithmeticGame();
        });
    }
}