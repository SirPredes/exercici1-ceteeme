package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("helloPFBean")
@RequestScoped
public class HelloPFBean {
    private String firstName = "Juan";
    private String lastName = "Pérez";

    private String componentSuite;
    private String inputText;
    private String outputText;

    private List<Technology> technologies;

    public HelloPFBean(){
        technologies = new ArrayList<>();
        technologies.add(new Technology("primeFaces", "12.0"));
        technologies.add(new Technology("JSF", "4.0"));
    }

    public void onBlurEvent(){
        outputText = inputText != null ? inputText.toUpperCase() : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getComponentSuite() {
        return componentSuite;
    }

    public String getInputText() {
        return inputText;
    }

    public String getOutputText() {
        return outputText;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
