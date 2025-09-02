public class Lion
{
    private String  name;
    private double weight;
    private int age; //months
    private Boolean dangerous;
    public Lion(String name, double weight, int age){
        setName(name);
        setAge(age);
        setWeight(weight);
        dangerous = isDangerous();
    }
    public static double averageWeight(Lion[] lions){
        double ave = 0;
        for (Lion lion: lions){
            ave += lion.weight;
        }
        return ave / lions.length;
    }
    public static int numberOfDangerousLions(Lion[] lions){
        int i = 0;
        for (Lion lion: lions){
            if (lion.isDangerous()){
                i++;
            }
        }
        return (i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDangerous(){
        return 6 < age && age < (17 * 12 );
    }
}
