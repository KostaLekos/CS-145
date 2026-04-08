public class Account {
    private String name;
    private String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void login(String name, String password) {
        if (name != this.name) {
            System.out.println("Incorrent username. Please try again.");
        } else if (password != this.password) {
            System.out.println("Incorrect password. Please try again.");
        } else {
            System.out.println("Successfully logged in. Welcome " + this.name + "!");
        }
    }

    public void setName(String name, String password) {
        if (password == this.password) {
            this.name = name;
            System.out.println("Username changed successfully!");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
        
    }

    public void setPassword(String password, String new_password) {
        if (password == this.password) {
            this.password = new_password;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
        
    }

    public String getName() {
        return name;
    }
}