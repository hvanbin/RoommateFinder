import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ray on 5/6/2016.
 */
public class ClassPathGUI {
    private JTextArea scheduleField;
    private JPanel classPanel;
    private JButton confirmButton;
    private JButton previousButton;
    private JLabel entryLabel;
    private JLabel displayDistancePath;
    private JLabel displayPath;
    private JButton clearButton;
    public ArrayList<Integer> inputSet;

    public static void main(String... args) {
        ClassPathGUI.createFrame();
    }

    /**
     * Creates the frame containing the log in window.
     */
    public static void createFrame() {
        JFrame frame = new JFrame("Class Path");
        frame.setContentPane(new ClassPathGUI().classPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack(); //condensing contents of window to be as packed as possible.
        frame.setLocationRelativeTo(null); //setting location to middle of user's screen.
        frame.setVisible(true);
    }

    public ClassPathGUI() {
        inputSet = new ArrayList<>();
        $$$setupUI$$$();
        confirmButton.addActionListener(e -> {
            displayDistancePath.setText("Here is the shortest distance to your class: " + displayDistance());
            displayPath.setText("Here is the shortest path to each class: " + displayPath());
        });
        previousButton.addActionListener(e -> {
            MainMenuGUI.createFrame(); //calling for the creation of the sign up frame.
            ((JFrame) classPanel.getTopLevelAncestor()).dispose(); //closing the current screen.
        });
        /**
         * Will clear input, but will error on the next input ( does not reset initial value, just adds to it ).
         */
        clearButton.addActionListener(e -> {
            displayDistancePath.setText("");
            displayPath.setText("");
        });
    }

    public ArrayList<Integer> getInput() {
        String input = scheduleField.getText();
        String[] classes = input.split(" ");
        for (int i = 0; i < classes.length; i++) {
            inputSet.add(Integer.parseInt(classes[i]));
        }
        //System.out.println(inputSet);
        return inputSet;

    }

    public String displayDistance() {
        ClassPath classPath = new ClassPath(getInput());

        for (int i = 0; i < classPath.classes.size(); i++) {
            ClassPath.dijkstra(ClassPath.graph, classPath.classes.get(i), classPath.classes);
        }
        String distance = ClassPath.getTotal();
        return distance;
    }

    public String displayPath() {
        ClassPath classPath = new ClassPath(getInput());
        String path = "";
        for (int i = 0; i < classPath.classes.size(); i++) {
            path += ClassPath.dijkstra(ClassPath.graph, classPath.classes.get(i), classPath.classes) + "\n";
        }
        return path;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        classPanel = new JPanel();
        classPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 36));
        label1.setText("ClassPath");
        classPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(getClass().getResource("/classpather.jpg")));
        label2.setText("");
        classPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        entryLabel = new JLabel();
        entryLabel.setEnabled(true);
        entryLabel.setFont(new Font(entryLabel.getFont().getName(), entryLabel.getFont().getStyle(), 24));
        entryLabel.setText("Enter your schedule via number");
        classPanel.add(entryLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scheduleField = new JTextArea();
        scheduleField.setFont(new Font(scheduleField.getFont().getName(), scheduleField.getFont().getStyle(), 12));
        classPanel.add(scheduleField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, 25), null, 0, false));
        confirmButton = new JButton();
        confirmButton.setText("Go");
        classPanel.add(confirmButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previousButton = new JButton();
        previousButton.setText("Previous");
        classPanel.add(previousButton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        displayDistancePath = new JLabel();
        displayDistancePath.setText("");
        classPanel.add(displayDistancePath, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        displayPath = new JLabel();
        displayPath.setText("");
        classPanel.add(displayPath, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        classPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 75), null, 0, false));
        clearButton = new JButton();
        clearButton.setText("Clear");
        classPanel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        classPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(50, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        classPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(50, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return classPanel;
    }
}
