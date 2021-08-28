package ru.training.at.hw7jdi.entities;


import com.epam.jdi.tools.DataClass;
import java.util.Arrays;

public class MetalsColorsData extends DataClass<MetalsColorsData> {

    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public Integer[] getSummary() {
        return summary;
    }

    public void setSummary(Integer[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "MetalsColorsData{"
            +
            "summary=" + Arrays.toString(summary)
            +
            ", elements=" + Arrays.toString(elements)
            +
            ", color='" + color + '\''
            +
            ", metals='" + metals + '\''
            +
            ", vegetables=" + Arrays.toString(vegetables)
            +
            '}';
    }
}


