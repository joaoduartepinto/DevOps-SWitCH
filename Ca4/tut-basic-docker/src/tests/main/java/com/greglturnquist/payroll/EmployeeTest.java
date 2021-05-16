package main.java.com.greglturnquist.payroll;

import com.greglturnquist.payroll.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    String VALID_FIRST_NAME = "John";
    String VALID_LAST_NAME = "Parker";
    String VALID_DESCRIPTION = "Nice guy";
    String VALID_JOBTITLE = "Archer";
    String VALID_EMAIL = "email@email.com";

    @DisplayName("Valid Employee object")
    @Test
    void shouldCreateAValidInstaceOfEmployee() {
        assertDoesNotThrow(() -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }


    @DisplayName("Null First Name")
    @Test
    void shouldThrowNullFirstName() {
        String nullFirstName = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(nullFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty First Name")
    @Test
    void shouldThrowEmptyFirstName() {
        String emptyFirstName = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(emptyFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank First Name")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankFirstName(String blankFirstName) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(blankFirstName, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Last Name")
    @Test
    void shouldThrowNullLastName() {
        String nullLastName = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, nullLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty Last Name")
    @Test
    void shouldThrowEmptyLastName() {
        String emptyLastName = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, emptyLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank Last Name")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankLastName(String blankLastName) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, blankLastName, VALID_DESCRIPTION, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Description")
    @Test
    void shouldThrowNullDescription() {
        String nullDescription = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, nullDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Empty Description")
    @Test
    void shouldThrowEmptyDescription() {
        String emptyDescription = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, emptyDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Blank Description")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankDescription(String blankDescription) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, blankDescription, VALID_JOBTITLE, VALID_EMAIL));
    }

    @DisplayName("Null Job Title")
    @Test
    void shouldThrowNullJobTitle() {
        String nullJobTitle = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, nullJobTitle, VALID_EMAIL));
    }

    @DisplayName("Empty Job Title")
    @Test
    void shouldThrowEmptyJobTitle() {
        String emptyJobTitle = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, emptyJobTitle, VALID_EMAIL));
    }

    @DisplayName("Blank Job Title")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankJobTitle(String blankJobTitle) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, blankJobTitle, VALID_EMAIL));
    }

    @DisplayName("Null Email")
    @Test
    void shouldThrowNullEmail() {
        String nullEmail = null;

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, nullEmail));
    }

    @DisplayName("Empty Email")
    @Test
    void shouldThrowEmptyEmail() {
        String emptyEmail = "";

        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, emptyEmail));
    }

    @DisplayName("Blank Email")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void shouldThrowBlankEmail(String blankEmail) {
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, blankEmail));
    }

    @DisplayName("Valid Emails")
    @ParameterizedTest
    @ValueSource(strings = {"homer@gmail.com", "lisa.simpson@outlook.pt", "sanders87@yahoo.com"})
    void validEmails(String validEmail) {
        assertDoesNotThrow(() -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, validEmail));
    }

    @DisplayName("Invaild Email, two '@'")
    @Test
    void shouldThrowInvalidEmailTwoAT() {
        String invalidEmail = "homer@@gmail.com";
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, invalidEmail));
    }

    @DisplayName("Invaild Email, no '@'")
    @Test
    void shouldThrowInvalidEmailNoAT() {
        String invalidEmail = "homergmail.com";
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, invalidEmail));
    }

    @DisplayName("Invaild Email, invalid Domain")
    @Test
    void shouldThrowInvalidEmailInvalidDomain() {
        String invalidEmail = "homer@gmail.c";
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, invalidEmail));
    }

    @DisplayName("Invaild Email, string with space")
    @Test
    void shouldThrowInvalidEmailStringWithSpace() {
        String invalidEmail = "ho mer@gmail.com";
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, invalidEmail));
    }

    @DisplayName("Invaild Email, illegal character")
    @Test
    void shouldThrowInvalidEmailIllegalCharacter() {
        String invalidEmail = "h!omer@gmail.com";
        assertThrows(IllegalArgumentException.class, () -> new Employee(VALID_FIRST_NAME, VALID_LAST_NAME, VALID_DESCRIPTION, VALID_JOBTITLE, invalidEmail));
    }
}