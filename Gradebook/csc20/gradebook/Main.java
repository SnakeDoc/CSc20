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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Sipula
 *
 */
public class Main {
    
    private static volatile List<Student> STUDENTS = new ArrayList<Student>();
	private static volatile String className = "";

    public static void main(String[] args) {
        MainWindow m = new MainWindow();
        m.display();
    }
    
    public static synchronized void addStudent(final Student s) {
        STUDENTS.add(s);
    }
    
    public static synchronized void deleteStudent(final Integer studentId) {
        for (int i = 0; i < STUDENTS.size(); i++) {
            if (STUDENTS.get(i).getId() == studentId) {
                STUDENTS.remove(i);
            }
        }
    }
    
    public static synchronized List<Student> getAllStudents() {
        return STUDENTS;
    }
	
	public static synchronized void setAllStudents(final List<Student> l) {
		STUDENTS = l;
	}
	
	public static synchronized void setClassName(final String s) {
		className = s;
	}
	
	public static synchronized String getClassName() {
		return className;
	}
    
}
