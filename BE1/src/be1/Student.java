/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be1;

/**
 *
 * @author mac
 */
public class Student {
    private String studentId;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tuitionFee;

    public Student(String studentId, String name, String phone, String email, String mountainCode, double tuitionFee) {
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s | %-5s | %.0f", studentId, name, phone, mountainCode, tuitionFee);
    }
    
    
}
