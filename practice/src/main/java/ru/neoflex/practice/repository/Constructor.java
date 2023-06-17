package ru.neoflex.practice.repository;

import javax.persistence.*;

@Entity
@Table(name = "Numbers")
public class Constructor {
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private Long id;
    @Column(name = "a")
    private double a;
    @Column(name = "b")
    private double b;
    @Column(name = "act")
    private String action;
    @Column(name = "result")
    private double result;

    public Constructor (double a, double b, String action,double result)
    {
        this.a = a;
        this.b = b;
        this.action = action;
        this.result = result;
    }

    public void setId(Long id){this.id = id;}
    public double getA(){return a;}
    public double getB(){return b;}
    public String getAction(){return action;}
    public double getResult(){return result;}

}
