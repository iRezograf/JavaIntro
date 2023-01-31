package rra.javaintro;

import java.util.Objects;

public class People {
    private String name = "";
    private String family = "";
    private String soname = "";
    private Integer age = 0;
    private String gender = "";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) && Objects.equals(family, people.family) && Objects.equals(soname, people.soname) && Objects.equals(age, people.age) && Objects.equals(gender, people.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family, soname, age, gender);
    }


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", soname='" + soname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String printInS5Format() {
        return family + ' ' +
                name.split("")[0] + ". " +
                soname.split("")[0] + ". " +
                age + " " +
                gender;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
