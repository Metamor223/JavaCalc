package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.repository.Constructor;
import ru.neoflex.practice.repository.RepositoryCalc;
@RestController
@RequestMapping(value = "", produces = "application/json")
public class CalcController
{
    @Autowired
    private RepositoryCalc repository;

    @GetMapping("/plus/{a}/{b}")
    public double plus(@PathVariable double a, @PathVariable double b)
    {
        repository.save(new Constructor(a, b,"+",a+b));
        return a+b;
    }

    @GetMapping("/minus/{a}/{b}")
    public double minus(@PathVariable double a,@PathVariable double b)
    {
        repository.save(new Constructor(a, b,"-",a-b));
        return a-b;
    }
    @GetMapping("/division/{a}/{b}")
    public double division(@PathVariable double a,@PathVariable double b)
    {
        if(b==0) {
            repository.save(new Constructor(a, b, "/", 0));
            return 0;
        }
        repository.save(new Constructor(a, b,"/",a/b));
        return a/b;
    }
    @GetMapping("/multiplication/{a}/{b}")
    public double multiplication(@PathVariable double a,@PathVariable double b)
    {
        repository.save(new Constructor(a, b,"*",a*b));
        return a*b;
    }
    @GetMapping("/get-all-calculations")
    public String getAllCalculations(){
        Iterable<Constructor> all = repository.findAll();
        StringBuilder sb = new StringBuilder();
        all.forEach(p -> sb.append(p.getA() + p.getAction() + p.getB() + " = " + p.getResult() + "\n"));
        return sb.toString();
    }
}