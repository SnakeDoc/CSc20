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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.*;

/**
 * @author Jason Sipula
 *
 */
public class MainWindow implements ActionListener {

	private JFrame frame;
	private JButton createButton;
    private JButton loadButton;
    private JButton addButton;
    private JButton labButton;
    private JButton sortButton;
    private JButton listButton;
    private JButton backupButton;
    private JButton exitButton;
    
    public void display() {
        frame = new JFrame("CSc 20 Gradebook");
        frame.setLayout(new BorderLayout());
        frame.setSize(650, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(getHeader(), BorderLayout.NORTH);
        frame.add(getFooter(), BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JPanel getHeader() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        
        JLabel headerLabel = new JLabel("    Use The Buttons Below To Manage Students");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JPanel subP = new JPanel();
        subP.setLayout(new FlowLayout());
        
        JLabel classLabel = new JLabel("Class Name:");
        JTextField classText = new JTextField("");
		classText.setText(Main.getClassName());
        classText.setPreferredSize(new Dimension(125, 20));
        classText.setEditable(false);
        
        JLabel numStudentsLabel = new JLabel("Number of Students:");
        JTextField numStudentsText = new JTextField("0");
		if (Main.getAllStudents().size() > 0) {
			numStudentsText.setText(new Integer(Main.getAllStudents().size()).toString());
		}
        numStudentsText.setPreferredSize(new Dimension(125, 20));
        numStudentsText.setEditable(false);
        
        subP.add(classLabel);
        subP.add(classText);
        subP.add(numStudentsLabel);
        subP.add(numStudentsText);
        
        p.add(headerLabel, BorderLayout.NORTH);
        p.add(subP, BorderLayout.SOUTH);
        
        return p;
    }
    
    private JPanel getFooter() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setPreferredSize(new Dimension(650, 65));
        
        JButton createButton = new JButton("0.Create a New Class");
        createButton.setPreferredSize(new Dimension(155, 25));
		createButton.addActionListener(this);
        JButton loadButton = new JButton("1.Load Students");
        loadButton.setPreferredSize(new Dimension(155, 25));
		loadButton.addActionListener(this);
        JButton addButton = new JButton("2.Add New Students");
        addButton.setPreferredSize(new Dimension(155, 25));
		addButton.addActionListener(this);
        JButton labButton = new JButton("3.Enter Lab Scores");
        labButton.setPreferredSize(new Dimension(155, 25));
		labButton.addActionListener(this);
        JButton sortButton = new JButton("4.Sort Students");
        sortButton.setPreferredSize(new Dimension(155, 25));
		sortButton.addActionListener(this);
        JButton listButton = new JButton("5.View/Delete Students");
        listButton.setPreferredSize(new Dimension(155, 25));
		listButton.addActionListener(this);
        JButton backupButton = new JButton("6.Backup Students");
        backupButton.setPreferredSize(new Dimension(155, 25));
		backupButton.addActionListener(this);
        JButton exitButton = new JButton("7.Exit");
        exitButton.setPreferredSize(new Dimension(155, 25));
		exitButton.addActionListener(this);
        
        p.add(createButton);
        p.add(loadButton);
        p.add(addButton);
        p.add(labButton);
        p.add(sortButton);
        p.add(listButton);
        p.add(backupButton);
        p.add(exitButton);
        
        return p;
    }
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("0.Create a New Class")) {
			frame.setVisible(false);
			CreateWindow w = new CreateWindow();
			w.display();
		} else if (e.getActionCommand().equals("1.Load Students")) {
			frame.setVisible(false);
			LoadWindow l = new LoadWindow();
			l.display();
		} else if (e.getActionCommand().equals("2.Add New Students")) {
			frame.setVisible(false);
			InfoWindow i = new InfoWindow();
			i.display();
		} else if (e.getActionCommand().equals("3.Enter Lab Scores")) {
			frame.setVisible(false);
			LabWindow lw = new LabWindow();
			lw.display();
		} else if (e.getActionCommand().equals("4.Sort Students")) {
			frame.setVisible(false);
			SortWindow s = new SortWindow();
			s.display();
		} else if (e.getActionCommand().equals("5.View/Delete Students")) {
			frame.setVisible(false);
			ListWindow li = new ListWindow();
			li.display();
		} else if (e.getActionCommand().equals("6.Backup Students")) {
			if (!"".equals(Main.getClassName()) || Main.getClassName() != null) {
				try {
					FileOutputStream fos = new FileOutputStream(Main.getClassName(), false);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(Main.getAllStudents());
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else if (e.getActionCommand().equals("7.Exit")) {
			frame.setVisible(false);
			System.exit(0);
		}
	}

}
