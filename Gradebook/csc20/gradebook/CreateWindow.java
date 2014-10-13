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

/**
 * @author Jason Sipula
 *
 */
public class CreateWindow implements ActionListener {

	private JFrame frame;
	private JButton buttonCreate;
    private JButton buttonCancel;
	private JTextField classText;

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
        
        JLabel headerLabel = new JLabel("                              Create A New Class");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        p.add(headerLabel, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel getCenter() {
        JPanel p = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setVgap(50);
        p.setLayout(fl);
        
        
        JLabel classLabel = new JLabel("Class Name:");
        classText = new JTextField("");
        classText.setPreferredSize(new Dimension(125, 20));
        
        p.add(classLabel);
        p.add(classText);
        
        return p;
    }
    
    private JPanel getSouth() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setPreferredSize(new Dimension(650, 50));
        
        buttonCreate = new JButton("Create");
		buttonCreate.addActionListener(this);
        buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(this);
        
        p.add(buttonCreate);
        p.add(buttonCancel);
        
        return p;
    }
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("Create")) {
			if (!"".equals(classText.getText()) && classText.getText() != null) {
				Main.setClassName(classText.getText());
			}
			frame.setVisible(false);
			MainWindow mw = new MainWindow();
			mw.display();
		} else if (e.getActionCommand().equals("Cancel")) {
			frame.setVisible(false);
			MainWindow mw = new MainWindow();
			mw.display();
		}
	}
    
}
