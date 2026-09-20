public class AccountListTest {
    public static void main(String[] args) {
        AccountList al = new AccountList(3);

        
        boolean success = al.appendAccount(new Account("Oak", 1.0));
        success = al.appendAccount(new Account("Two", 0.1));

        
        Account account = al.getAccount(2);
        System.out.println(account); // should print null

        account = al.getAccount(1);
        
        System.out.println(account.getBalance());

        success = al.appendAccount(new Account("tmp", 0));
        success = al.appendAccount(new Account("tmp2", 0));
        System.out.println(success); 
    }
}