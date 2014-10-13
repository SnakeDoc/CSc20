/*******************************************************************************
 *  Copyright 2013 Jason Sipula                                                *
 *                                                                             *
 *  Licensed under the Apache License, Version 2.0 (the "License");            *
 *  you may not use this file except in compliance with the License.           *
 *  You may obtain a copy of the License at                                    *
 *                                                                             *
 *      http://www.apache.org/licenses/LICENSE-2.0                             *
 *                                                                             *
 *  Unless required by applicable law or agreed to in writing, software        *
 *  distributed under the License is distributed on an "AS IS" BASIS,          *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 *  See the License for the specific language governing permissions and        *
 *  limitations under the License.                                             *
 *******************************************************************************/

package csc20.gradebook;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.List;

/**
 * @author Jason Sipula
 *
 */
public class LabWindow implements ActionListener {

	private JFrame frame;
	private JButton buttonBack;
	
	private JTextField labText;
	private JTextField scoreText;

    public void display() {
        frame = new JFrame("CSc 20 Gradebook");
        frame.setLayout(new BorderLayout());
        frame.setSize(650, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(getHeader(), BorderLayout.NORTH);
        frame.add(getCenter(), BorderLayout.CENTER);
        frame.add(getSouth(), BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JPanel getHeader() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        
        JLabel headerLabel = new JLabel("                                 Enter Lab Scores");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        p.add(headerLabel, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel getCenter() {
        JPanel p = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setVgap(50);
        p.setLayout(fl);        
        
        JPanel blP = new JPanel();
        blP.setLayout(new BoxLayout(blP, BoxLayout.Y_AXIS));
        
        JPanel labP = new JPanel();
        labP.setLayout(new FlowLayout());
        JLabel labLabel = new JLabel("Lab Number:");
        labText = new JTextField("");
        labText.setPreferredSize(new Dimension(110, 20));
        labP.add(labLabel);
        labP.add(labText);
        
        JPanel scoreP = new JPanel();
        scoreP.setLayout(new FlowLayout());
        JLabel scoreLabel = new JLabel("Score For:");
        scoreText = new JTextField("");
        scoreText.setPreferredSize(new Dimension(125, 20));
        scoreP.add(scoreLabel);
        scoreP.add(scoreText);
        
        blP.add(labP);
        blP.add(scoreP);
        
        p.add(blP);
        
        return p;
    }
    
    private JPanel getSouth() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setPreferredSize(new Dimension(650, 50));
        
        buttonBack = new JButton("Back To Top Menu");
		buttonBack.addActionListener(this);
        
        p.add(buttonBack);
        
        return p;
    }
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("Back To Top Menu")) {
		
			if (!"".equals(scoreText.getText()) || scoreText.getText() != null) {
				List<Student> l = Main.getAllStudents();
				System.out.println("OO!");
				for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getId());
				System.out.println(scoreText.getText());
					if (l.get(i).getId() == new Integer(scoreText.getText())) {
					System.out.println("OH!");
						if (l.get(i).getLab1() == null || l.get(i).getLab1() == 0) {
						System.out.println("YA!");
							l.get(i).setLab1(new Integer(labText.getText()));
						} else if (l.get(i).getLab2() == null || l.get(i).getLab2() == 0) {
							l.get(i).setLab2(new Integer(labText.getText()));
						} else if (l.get(i).getLab3() == null || l.get(i).getLab3() == 0) {
							l.get(i).setLab3(new Integer(labText.getText()));
						} else if (l.get(i).getLab4() == null || l.get(i).getLab4() == 0) {
							l.get(i).setLab4(new Integer(labText.getText()));
						} else if (l.get(i).getLab5() == null || l.get(i).getLab5() == 0) {
							l.get(i).setLab5(new Integer(labText.getText()));
						} else if (l.get(i).getLab6() == null || l.get(i).getLab6() == 0) {
							l.get(i).setLab6(new Integer(labText.getText()));
						} else if (l.get(i).getLab7() == null || l.get(i).getLab7() == 0) {
							l.get(i).setLab7(new Integer(labText.getText()));
						} else if (l.get(i).getLab8() == null || l.get(i).getLab8() == 0) {
							l.get(i).setLab8(new Integer(labText.getText()));
						} else if (l.get(i).getLab9() == null || l.get(i).getLab9() == 0) {
							l.get(i).setLab9(new Integer(labText.getText()));
						} else if (l.get(i).getLab10() == null || l.get(i).getLab10() == 0) {
							l.get(i).setLab10(new Integer(labText.getText()));
						}
					}
				}
				Main.setAllStudents(l);
			}
		
			frame.setVisible(false);
			MainWindow mw = new MainWindow();
			mw.display();
		}
	}
    
}
