/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

    private @Id
    @GeneratedValue
    Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private String jobTitle;
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String description, String jobTitle, String email) {
        checkFirstName(firstName);
        checkLastName(lastName);
        checkDescription(description);
        checkJobTitle(jobTitle);
        checkEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.jobTitle = jobTitle;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(description, employee.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, description);
    }

    private void checkFirstName(String firstName) {
        if (!isFirstNameValid(firstName))
            throw new IllegalArgumentException("Invalid First Name");
    }

    private boolean isFirstNameValid(String firstName) {
        if (firstName == null || firstName.isBlank() || firstName.isBlank())
            return false;

        return true;
    }

    private void checkLastName(String lastName) {
        if (!isLastNameValid(lastName))
            throw new IllegalArgumentException("Invalid Last Name");
    }

    private boolean isLastNameValid(String lastName) {
        if (lastName == null || lastName.isBlank() || lastName.isBlank())
            return false;

        return true;
    }

    private void checkDescription(String description) {
        if (!isDescriptionValid(description))
            throw new IllegalArgumentException("Invalid Description");
    }

    private boolean isDescriptionValid(String description) {
        if (description == null || description.isBlank() || description.isBlank())
            return false;

        return true;
    }

    private void checkJobTitle(String jobTitle) {
        if (!isJobTitleValid(jobTitle))
            throw new IllegalArgumentException("Invalid Job Title");
    }

    private boolean isJobTitleValid(String jobTitle) {
        if (jobTitle == null || jobTitle.isBlank() || jobTitle.isBlank())
            return false;

        return true;
    }

    private void checkEmail(String email) {
        if (!isEmailValid(email))
            throw new IllegalArgumentException("Invalid Email");
    }

    // adapted from: https://mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
    private boolean isEmailValid(String email) {
        if (email == null || email.isBlank() || email.isBlank())
            return false;

        String emailRegex = "[A-Z0-9a-z._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";

        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkLastName(lastName);
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        checkDescription(description);
        this.description = description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
// end::code[]
