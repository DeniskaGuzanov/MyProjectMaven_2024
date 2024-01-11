package ru.maven;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Person implements Serializable {


    private final String firstName;
    private final String lastName;
    private final int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", this.firstName)
                .append("lastName", this.lastName)
                .append("age", this.age)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() !=obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (other.age != this.age) {
            return false;
        }

        return new EqualsBuilder().append(firstName, other.firstName).append(lastName, other.lastName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(15, 39)
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
