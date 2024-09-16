package org.example.point;

public class Point implements Movable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public void moveUp() {
        y++;
    }
    @Override
    public void moveDown() {
        y--;
    }
    @Override
    public void moveRight() {
        x++;
    }
    @Override
    public void moveLeft() {
        x--;
    }

    public void result () {
        System.out.println("Point x = " +  x + ", point y = " + y);
    }
}
