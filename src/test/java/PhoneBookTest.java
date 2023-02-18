import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    PhoneBook sut = new PhoneBook();
    @Test
    @DisplayName("Add new Contact: name and phone")
    public void testAdd(){

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        int actual = sut.add(name,phone);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contacts with same names")
    public void testAddSameNameContacts(){

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";
        String phone2 = "+7 800 700 60 60";

        sut.add(name,phone);
        int actual = sut.add(name,phone2);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contact with empty name value")
    public void testAddEmptyNameValue(){

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        sut.add(name,phone);
        int actual = sut.add("",phone);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contact with null name value")
    public void testAddNullNameValue(){

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        sut.add(name,phone);
        int actual = sut.add(null,phone);

        int expected = 1;

        assertEquals(expected, actual);
    }
}
