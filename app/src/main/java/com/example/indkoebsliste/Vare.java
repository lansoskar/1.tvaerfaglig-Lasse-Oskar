package com.example.indkoebsliste;

public class Vare {
    private String name;
    private boolean isChecked;

    public Vare (String name, boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "Vare{" +
                "name='" + name + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
