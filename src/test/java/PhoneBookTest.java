import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    PhoneBook sut = new PhoneBook();

    @Test
    @DisplayName("Add new Contact: name and phone")
    public void testAdd() {

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        int actual = sut.add(name, phone);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contacts with same names")
    public void testAddSameNameContacts() {

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";
        String phone2 = "+7 800 700 60 60";

        sut.add(name, phone);
        int actual = sut.add(name, phone2);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contact with empty name value")
    public void testAddEmptyNameValue() {

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        sut.add(name, phone);
        int actual = sut.add("", phone);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add Contact with null name value")
    public void testAddNullNameValue() {

        String name = "Contact Name";
        String phone = "+7 800 700 60 50";

        sut.add(name, phone);
        int actual = sut.add(null, phone);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find name by number")
    public void testFindByNumber() {

        String name = "Max";
        String phone = "+7 800 700 60 40";

        String name2 = "Gretta";
        String phone2 = "+7 800 700 60 50";

        String name3 = "Bill";
        String phone3 = "+7 800 700 60 60";

        sut.add(name, phone);
        sut.add(name2, phone2);
        sut.add(name3, phone3);

        String actual = sut.findByNumber(phone2);

        String expected = "Gretta";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find name by number which is empty")
    public void testFindByNumberWhichIsEmpty() {

        String actual = sut.findByNumber("");

        String expected = "Номер не указан";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find name by number which is null")
    public void testFindByNumberWhichIsNull() {

        String actual = sut.findByNumber(null);

        String expected = "Номер не существует";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find by number that is not in the list")
    public void testFindByNumberNonExistentNumber() {

        String name = "Max";
        String phone = "+7 800 700 60 40";


        sut.add(name, phone);

        String actual = sut.findByNumber("+7 700 700 70 70");

        String expected = "Контакт не найден";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find by number in an empty list")
    public void testFindByNumberEmptyContactList() {

        String actual = sut.findByNumber("+7 700 700 70 70");

        String expected = "Список контактов пуст";

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Find number by name")
    public void testFindByName() {

        String name = "Max";
        String phone = "+7 800 700 60 40";

        String name2 = "Gretta";
        String phone2 = "+7 800 700 60 50";

        String name3 = "Bill";
        String phone3 = "+7 800 700 60 60";

        sut.add(name, phone);
        sut.add(name2, phone2);
        sut.add(name3, phone3);

        String actual = sut.findByName(name);

        String expected = "+7 800 700 60 40";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find number by name which is empty")
    public void testFindByNameWhichIsEmpty() {

        String actual = sut.findByName("");

        String expected = "Имя не указано";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find number by name which is null")
    public void testFindByNameWhichIsNull() {

        String actual = sut.findByName(null);

        String expected = "Имя не существует";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find by name that is not in the list")
    public void testFindByNameNonExistentName() {

        String name = "Max";
        String phone = "+7 800 700 60 40";

        sut.add(name, phone);

        String actual = sut.findByName("Grace");

        String expected = "Контакт не найден";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find by name in an empty list")
    public void testFindByNameEmptyContactList() {

        String actual = sut.findByName("Gram");

        String expected = "Список контактов пуст";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print names in ASC order")
    void testPrintAllNames() throws Exception {

        sut.add("Johan", "+952 87 98 56");
        sut.add("Anna", "+902 27 38 50");
        sut.add("Christie", "+32 11 00 50");

        String expected = String.join("\r\n", "Anna", "Christie", "Johan");

        String actual = tapSystemOut(() -> {
            sut.printAllNames();
        }).trim();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print names from empty list")
    public void testPrintAllNamesFromEmptyContactList() throws Exception {

        String expected = "Список контактов пуст";

        String actual = tapSystemOut(() -> {
            sut.printAllNames();
        }).trim();

        assertEquals(expected, actual);
    }

}
