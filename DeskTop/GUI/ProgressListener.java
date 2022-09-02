package GUI;

import Function.Plan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProgressListener implements ActionListener {
	public ProgressCheckinFrame progressCheckinFrame;
	String[] userPlan = Plan.readPlan();

	public ProgressListener() throws IOException {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Change the Plan")){
			UserPlan userPlanPage = null;
			try {
				userPlanPage = new UserPlan();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			userPlanPage.initUI(userPlan[1], userPlan[6], userPlan[5]);
		}
	}
}

