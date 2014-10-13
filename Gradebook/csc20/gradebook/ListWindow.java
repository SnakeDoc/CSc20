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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 * @author Jason Sipula
 *
 */
public class ListWindow implements ActionListener {

	private JFrame frame;
	private JButton buttonDelete;
    private JButton buttonCancel;
	
	private JTable table;

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
        
        JLabel headerLabel = new JLabel("                                    Student List");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        p.add(headerLabel, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel getCenter() {
        JPanel p = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setVgap(0);
        p.setLayout(fl);
        
        table = new JTable(new TableModel(Main.getAllStudents()));
        
        TableColumn idCol = table.getColumnModel().getColumn(0);
        idCol.setMinWidth(70);
        
        TableColumn nameCol = table.getColumnModel().getColumn(1);
        nameCol.setMinWidth(85);
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(650, 175));
        p.add(jsp);
        
        return p;
    }
    
    private JPanel getSouth() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        
        buttonDelete = new JButton("Delete Selected");
		buttonDelete.addActionListener(this);
        buttonCancel = new JButton("Top Menu");
		buttonCancel.addActionListener(this);
        
        p.add(buttonDelete);
        p.add(buttonCancel);
        
        return p;
    }
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("Delete Selected")) {
			Main.deleteStudent((Integer)table.getValueAt(table.getSelectedRow(), 0));
			frame.setVisible(false);
			ListWindow lw = new ListWindow();
			lw.display();
		} else if (e.getActionCommand().equals("Top Menu")) {
			frame.setVisible(false);
			MainWindow mw = new MainWindow();
			mw.display();
		}
	}
    
}
