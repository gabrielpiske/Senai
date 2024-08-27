package entities;

public class employee {
    public String name;
    public Double grossSalary;
    public Double tax;

    public double nextSalary(){
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage){
        
    }
}
