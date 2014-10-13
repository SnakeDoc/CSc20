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

/**
 * @author Jason Sipula
 *
 */
public class Student {

    // student info
    private final Integer id;
    private final String name;
    private final Character gender;
    private final Integer classLevel;
    private final Integer age;
    
    // lab scores
    private Integer lab1;
    private Integer lab2;
    private Integer lab3;
    private Integer lab4;
    private Integer lab5;
    private Integer lab6;
    private Integer lab7;
    private Integer lab8;
    private Integer lab9;
    private Integer lab10;
    
    public Student(final Integer id, final String name, 
            final Character gender, final Integer classLevel, final Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classLevel = classLevel;
        this.age = age;
    }
    
    // immutable elements (getters only)
    public Integer getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Character getGender() {
        return this.gender;
    }
    
    public Integer getClassLevel() {
        return this.classLevel;
    }
    
    public Integer getAge() {
        return this.age;
    }
    
    // mutable elements (getters and setters)
    
    // lab1
    public void setLab1(final Integer lab1) {
        this.lab1 = lab1;
    }
    
    public Integer getLab1() {
        return this.lab1;
    }
    
    // lab2
    public void setLab2(final Integer lab2) {
        this.lab2 = lab2;
    }
    
    public Integer getLab2() {
        return this.lab2;
    }

    // lab3
    public void setLab3(final Integer lab3) {
        this.lab3 = lab3;
    }
    
    public Integer getLab3() {
        return this.lab3;
    }
    
    // lab4
    public void setLab4(final Integer lab4) {
        this.lab4 = lab4;
    }
    
    public Integer getLab4() {
        return this.lab4;
    }
    
    // lab5
    public void setLab5(final Integer lab5) {
        this.lab5 = lab5;
    }
    
    public Integer getLab5() {
        return this.lab5;
    }
    
    // lab6
    public void setLab6(final Integer lab6) {
        this.lab6 = lab6;
    }
    
    public Integer getLab6() {
        return this.lab6;
    }
    
    // lab7
    public void setLab7(final Integer lab7) {
        this.lab7 = lab7;
    }
    
    public Integer getLab7() {
        return this.lab7;
    }
    
    // lab8
    public void setLab8(final Integer lab8) {
        this.lab8 = lab8;
    }
    
    public Integer getLab8() {
        return this.lab8;
    }
    
    // lab9
    public void setLab9(final Integer lab9) {
        this.lab9 = lab9;
    }
    
    public Integer getLab9() {
        return this.lab9;
    }
    
    // lab10
    public void setLab10(final Integer lab10) {
        this.lab10 = lab10;
    }
    
    public Integer getLab10() {
        return this.lab10;
    }
    
}
