package GUI;

import Function.Plan;
import Function.WordsLearned;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserPlanListener implements ActionListener {
    public UserPlan previewuserplanFrame;
    public JTextField word;

    public void actionPerformed(ActionEvent e) {
        String btnstr = e.getActionCommand();
        {
            if (btnstr.equals("Preserve")) {
                if (!word.getText().equals(previewuserplanFrame.target)) {
                    if (word.getText().equals("4")) {
                        try {
                            Plan.changeLevel("1");
                            Plan.changeIndex(-1);
                            Plan.changeMaxIndex(0);
                            Plan.changeStart(0);
                            try {
                                WordsLearned.clear();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else if (word.getText().equals("5")) {
                        try {
                            Plan.changeLevel("2");
                            Plan.changeIndex(-1);
                            Plan.changeMaxIndex(0);
                            Plan.changeStart(0);
                            try {
                                WordsLearned.clear();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else if (word.getText().equals("6")) {
                        try {
                            Plan.changeLevel("3");
                            Plan.changeIndex(-1);
                            Plan.changeMaxIndex(0);
                            Plan.changeStart(0);
                            try {
                                WordsLearned.clear();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else if (word.getText().equals("7")) {
                        try {
                            Plan.changeLevel("4");
                            Plan.changeIndex(-1);
                            Plan.changeMaxIndex(0);
                            Plan.changeStart(0);
                            try {
                                WordsLearned.clear();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else if (word.getText().equals("8")) {
                        try {
                            Plan.changeLevel("5");
                            Plan.changeIndex(-1);
                            Plan.changeMaxIndex(0);
                            Plan.changeStart(0);
                            try {
                                WordsLearned.clear();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect input form :-(");
                    }
                }
            }
            try {
                int plan = Integer.parseInt(previewuserplanFrame.panel0.textField1.getText());
                if (plan >= Integer.parseInt(Plan.readPlan()[4])){
                    Plan.changeDailyPlan(Integer.parseInt(previewuserplanFrame.panel0.textField1.getText()));
                    Plan.changeTest(Integer.parseInt(previewuserplanFrame.panel1.textField1.getText()));
                    Plan.changeSpeakTest(Integer.parseInt(previewuserplanFrame.panel2.textField1.getText()));
                    JOptionPane.showMessageDialog(null, "Preserve Successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Your new plan is less than the number of words you have learned today!");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
