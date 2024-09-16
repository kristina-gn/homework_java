package org.example.student;

public class Student implements Printable{
    private String name;
    private int recordBook;
    double average;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return  name;
    }
    public void setRecordBook(int recordBook) {
        this.recordBook = recordBook;
    }
    public int getRecordBook() {
        return recordBook;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public double getAverage() {
        return average;
    }
    @Override
    public void print() {
        System.out.println(this.name + ", " + this.recordBook + ", " + this.average);
    }
}
