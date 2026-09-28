package tdp.exercises;

public class PersonExercise {
    private String name;

    public PersonExercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Blank name");
        }
    }
}
