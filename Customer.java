import java.io.Serializable;

public class Customer implements Serializable {
    private String customerId;
    private String name;
    private String address;
    private String phone;
    private String email;

    public Customer(String customerId, String name, String address, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toFileString() {
        return customerId + "|" + clean(name) + "|" + clean(address) + "|" +
               clean(phone) + "|" + clean(email);
    }

    public static Customer fromFileString(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 5) {
            return null;
        }
        return new Customer(p[0], p[1], p[2], p[3], p[4]);
    }

    private String clean(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("|", "/").replace("\n", " ").replace("\r", " ");
    }

    public void display() {
        System.out.println("---------------------------------------------");
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Address     : " + address);
        System.out.println("Phone       : " + phone);
        System.out.println("Email       : " + email);
        System.out.println("---------------------------------------------");
    }
}
