package atc.stellar.model;

public class KeyData
{
    private char[] secretSeed;
    private String accountId;

    public char[] getSecretSeed ()
    {
        return secretSeed;
    }

    public void setSecretSeed ( final char[] pSecretSeed )
    {
        secretSeed = pSecretSeed;
    }

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId ( final String pAccountId )
    {
        accountId = pAccountId;
    }
}
