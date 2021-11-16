package edu.citytech.abccounter.model;

public class Model {
    private String mode;
    private String description;

    public Model(String mode, String description) {
        this.mode = mode;
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
