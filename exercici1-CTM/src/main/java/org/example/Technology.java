package org.example;

public class Technology {
    private String name;
    private String currentVersion;

    public Technology(String name, String currentVersion){
        this.name = name;
        this.currentVersion = currentVersion;
    }

    public String getName() {
        return name;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }
}
