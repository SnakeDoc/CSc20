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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jason Sipula
 *
 */
public class InfoWindow implements ActionListener {

	private JFrame frame;
	private JButton buttonSave;
    private JButton buttonCancel;
	
	private JTextField ssnText;
	private JTextField nameText;
	private JComboBox genderCombo;
	private JTextField ageText;
	private JComboBox levelCombo;

    public void display() {
        frame = new JFrame("CSc 20 Gradebook");
        frame.setLayout(new BorderLayout());
        frame.setSize(650, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(getHeader(), BorderLayout.NORTH);
        frame.add(getEast(), BorderLayout.EAST);
        frame.add(getSouth(), BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JPanel getHeader() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        
        JLabel headerLabel = new JLabel("                              Enter Student Information");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        p.add(headerLabel, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel getEast() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        
        JPanel ssnP = new JPanel();
        ssnP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel ssnLabel = new JLabel("SSN:");
        ssnText = new JTextField("");
        ssnText.setPreferredSize(new Dimension(325, 25));
        ssnP.add(ssnLabel);
        ssnP.add(ssnText);
        
        JPanel nameP = new JPanel();
        nameP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel nameLabel = new JLabel("Name:");
        nameText = new JTextField("");
        nameText.setPreferredSize(new Dimension(325, 25));
        nameP.add(nameLabel);
        nameP.add(nameText);
        
        JPanel genderP = new JPanel();
        genderP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel genderLabel = new JLabel("Gender:");
        final Character[] genders = {'M', 'F'};
        genderCombo = new JComboBox(genders);
        genderCombo.setPreferredSize(new Dimension(325, 25));
        genderCombo.setSelectedIndex(0);
        genderP.add(genderLabel);
        genderP.add(genderCombo);
        
        JPanel ageP = new JPanel();
        ageP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel ageLabel = new JLabel("Age:");
        ageText = new JTextField("");
        ageText.setPreferredSize(new Dimension(325, 25));
        ageP.add(ageLabel);
        ageP.add(ageText);
        
        JPanel levelP = new JPanel();
        levelP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel levelLabel = new JLabel("Academic Level:");
        final String[] levels = {"Freshman", "Sophmore", "Junior", "Senior", "Graduate"};
        levelCombo = new JComboBox(levels);
        levelCombo.setPreferredSize(new Dimension(325, 25));
        levelCombo.setSelectedIndex(0);
        levelP.add(levelLabel);
        levelP.add(levelCombo);
        
        p.add(ssnP);
        p.add(nameP);
        p.add(genderP);
        p.add(ageP);
        p.add(levelP);
        
        return p;
    }
    
    private JPanel getSouth() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        
        buttonSave = new JButton("Save & Add Student");
		buttonSave.addActionListener(this);
        buttonCancel = new JButton("Back To Top Menu");
		buttonCancel.addActionListener(this);
        
        p.add(buttonSave);
        p.add(buttonCancel);
        
        return p;
    }
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("Save & Add Student")) {
			Student s = new Student(
				new Integer(ssnText.getText()),
				nameText.getText(), 
				(Character)genderCombo.getSelectedItem(),
				(levelCombo.getSelectedItem().equals("Freshman") ? 1 : levelCombo.getSelectedItem().equals("Sophmore") 
						? 2 : levelCombo.getSelectedItem().equals("Junior") ? 3 : levelCombo.getSelectedItem().equals("Senior") ? 4 : 5),
				new Integer(ageText.getText())
				);
			Main.addStudent(s);
			frame.setVisible(false);
			InfoWindow i = new InfoWindow();
			i.display();

		} else if (e.getActionCommand().equals("Back To Top Menu")) {
			frame.setVisible(false);
			MainWindow mw = new MainWindow();
			mw.display();
		}
	}
    
}
