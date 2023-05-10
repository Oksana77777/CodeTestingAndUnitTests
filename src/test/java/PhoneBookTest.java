import org.example.Contact;
import org.example.PhoneContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {

    private final Calculator calc = Calculator.instance.get();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testParam(int argument) {
        Assertions.assertNotNull(calc.pow.apply(argument));
    }

    @Test
    public void testString() {
        String original = "Original", argument = " argument";
        String expected = "Original argument";
        String result = original.concat(argument);
        assertThat(expected, equalToIgnoringCase(result));
    }

    @Test
    public void testConstructorEquals_PhoneContact() {
        String name = "Family";
        PhoneContact phoneContact = new PhoneContact(name);
        PhoneContact phoneContact1 = new PhoneContact(name);
        assertThat(phoneContact, equalTo(phoneContact1));
    }

    @Test
    public void testEqualsObj_Contact () {
        Contact contact = new Contact("Oksana", "007");
        Contact contact1 = new Contact("Oksana", "111");
        assertThat(contact, equalTo(contact1));
    }

    @Test
    public void testPrintContact_PhoneContact() {
        PhoneContact phoneContact = new PhoneContact("Family");
        phoneContact.addContact("Oksana", "007");
        phoneContact.addContact("Oksana", "007");
        Assertions.assertEquals("- Family" +
                "\n          - Oksana 007", phoneContact.printPhoneContact());
    }

    @Test
    public void testSum_Calculator() {
        //arrange
        Integer given = 3;
        Integer when = 2;
        Integer expected = 5;
        Integer result = calc.plus.apply(given, when);
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void testExeptionDivide_Calculator() {
        Integer a = 5, b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;
        Assertions.assertThrows(expected,
                () -> calc.divide.apply(a, b));
    }
}
