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

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * @author Jason Sipula
 *
 */
public class TableModel extends AbstractTableModel {

    final String[] columnNames = 
        {"ID", "Name", "Level", "Gender", "Age", "Lab 1", "Lab 2", 
            "Lab 3", "Lab 4", "Lab 5", "Lab 6", "Lab 7", "Lab 8", "Lab 9", "Lab 10"};
    
    Object[][] data;
    
    public TableModel(final List<Student> students) {
        data = new Object[students.size()][15];
        for (int i = 0; i < students.size(); i++) {
            data[i][0] = students.get(i).getId();
            data[i][1] = students.get(i).getName();
            data[i][2] = students.get(i).getClassLevel();
            data[i][3] = students.get(i).getGender();
            data[i][4] = students.get(i).getAge();
            data[i][5] = students.get(i).getLab1();
            data[i][6] = students.get(i).getLab2();
            data[i][7] = students.get(i).getLab3();
            data[i][8] = students.get(i).getLab4();
            data[i][9] = students.get(i).getLab5();
            data[i][10] = students.get(i).getLab6();
            data[i][11] = students.get(i).getLab7();
            data[i][12] = students.get(i).getLab8();
            data[i][13] = students.get(i).getLab9();
            data[i][14] = students.get(i).getLab10();
        }
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(final int row, final int col) {
        return data[row][col];
    }
    
    @Override
    public String getColumnName(final int col) {
        return columnNames[col];
    }
}
