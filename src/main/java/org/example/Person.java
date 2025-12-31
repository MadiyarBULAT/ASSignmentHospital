public class Person {

    protected int id;
    protected String name;
    protected int age;
    protected int experienceYears;

    public Person(int id, String name, int age, int experienceYears) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.experienceYears = experienceYears;
    }

    public void work() {
        System.out.println(name + " is working at the hospital.");
    }

    public String getRole() {
        return "Hospital Staff";
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + id +
                ", Age: " + age +
                ", Experience: " + experienceYears + " years)";
    }
}