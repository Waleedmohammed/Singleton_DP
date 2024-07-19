package org.POJO;

import org.apache.juneau.annotation.Beanc;

public class POJO {

    private String Name;
    private int age;
    private String Job;
    private String[] cities;

    @Beanc(properties = "name, age, job, cities")
    public POJO(String name, int age, String job, String[] cities) {
        Name = name;
        this.age = age;
        Job = job;
        this.cities = cities;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }
}
