package org.example;



public class Toys implements Comparable<Toys>{
    private static Integer count=1;
    protected int id;
    protected String name;
    private Integer percentageOfLoss;

    public Toys(String name, Integer percentageOfLoss) {
        this.id = count;
        this.name = name;
        this.percentageOfLoss = percentageOfLoss;
        count++;
    }


    @Override
    public int compareTo(Toys o) {
        return this.percentageOfLoss-o.percentageOfLoss;
    }

    @Override
    public String toString() {
        return STR."Toy {id = \{id}, Название: '\{name}\{'\''}, % выпадения = \{percentageOfLoss}\{'}'}";
    }

    public int getPercentageOfLoss() {
        return percentageOfLoss;
    }

    public void setPercentageOfLoss(int percentageOfLoss) {
        this.percentageOfLoss = percentageOfLoss;
    }
}
