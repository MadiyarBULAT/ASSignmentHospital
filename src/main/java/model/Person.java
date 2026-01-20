package model; //abstract classes

public abstract class Person {

    protected int id;
    protected String name;
    protected int age;
    protected int experienceYears;

    public Person(int id, String name, int age, int experienceYears) {
        setId(id);
        setName(name);
        setAge(age);
        setExperienceYears(experienceYears);
    }

    // ABSTRACT METHODS (обязательно)
    public abstract void work();
    public abstract String getRole();

    // SETTERS WITH EXCEPTIONS
    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0)
            throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0)
            throw new IllegalArgumentException("Experience cannot be negative");
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + id +
                ", Age: " + age +
                ", Experience: " + experienceYears + " years)";
    }
}







