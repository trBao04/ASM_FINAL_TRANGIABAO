package org.example;
class Student
{
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String getRanking() {
        if (score < 5.0) {
            return "Fail";
        } else if (score < 6.5) {
            return "P";
        } else if (score < 7.5) {
            return "M";
        } else if (score < 9.0) {
            return "D";
        } else {
            return "Excellent";
        }
    }
    public Student() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore () {
        return score;
    }
    @Override
    public String toString() {
        return "Student {" + "ID = " + id + ", Name = " + name + ", Score = " + score +
                ", Ranking = " + getRanking()+ '}';
    }
}
