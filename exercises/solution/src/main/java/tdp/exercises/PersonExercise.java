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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Blank name");
        }
        this.name = name;
    }
}
