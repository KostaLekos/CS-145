public class AccountTester {
    public AccountTester() {}

    public static void main(String[] args) {
        Account account1 = new Account("Jane Green", "1234");
        Account account2 = new Account("John Blue", "password");

        System.out.printf("account1 name is: %s\n", account1.getName());
        System.out.printf("account2 name is: %s\n", account2.getName());

        account1.setName("Jane Orange", "1234");
        account1.setPassword("IncorrectPassword", "2777");

        account2.setName("John Yellow", "chair261");
        account2.setPassword("password", "2555");
    }
}