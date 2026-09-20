public class AccountList {
    private Account[] accounts;
    private int count; 
    
    public AccountList(int maxSize) {
        this.accounts = new Account[maxSize];
        this.count = 0;
    }

    
    public boolean appendAccount(Account account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
            return true;
        }
        return false;
    }

    
    public Account getAccount(int idx) {
        if (idx >= 0 && idx < count) {
            return accounts[idx];
        } else {
            System.out.println("Input index exceeds the number of appended elements");
            return null;
        }
    }

    
    public Account[] getAccounts() {
        return accounts;
    }

    public int getCount() {
        return count;
    }
}