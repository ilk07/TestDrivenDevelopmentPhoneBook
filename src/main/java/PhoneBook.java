import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String, String> contacts = new HashMap<>();

    public int add(String name, String phone) {

        // Метод должен возвращать количество контактов после добавления,
        // при этом гарантируется, что не будут добавляться повторяющиеся имена;
        if (name != null) {
            if (!name.trim().equals("")) {
                if (!contacts.containsKey(name)) {
                    contacts.put(name, phone);
                }
            }
        }

        return contacts.size();
    }

    public String findByNumber(String phone){
        //найти имя по номеру без полного перебора

        if (phone == null){
            return "Номер не существует";
        }

        if(phone.trim().equals("")){
            return "Номер не указан";
        }

        if(contacts.isEmpty()){
            return "Список контактов пуст";
        } else {
            return contacts.entrySet().stream()
                    .filter(entry -> phone.equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse("Контакт не найден");
        }
    }
}
