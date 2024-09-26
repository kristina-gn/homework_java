package org.example.api.models;

public class Unicorn {
    private String name;
    private String colorTail;

    public Unicorn (String name, String colorTail) {
        this.name = name;
        this.colorTail = colorTail;
    }

    public String getName() {
        return name;
    }

    public String getColorTail() {
        return colorTail;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", colorTail='" + colorTail + '\'' +
                '}';
    }
    public String toJson() {
        return "{\n" +
                " \"name\": \"Uni\", \n" +
                " \"tailColor\": \"Pink\", \n" +
                "}";
    }
}

