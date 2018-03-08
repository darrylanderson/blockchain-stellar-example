package atc.stellar.model;

import java.util.List;

public class Account
{
    private String accountId;

    private List<Balance> balances;

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId ( final String pAccountId )
    {
        accountId = pAccountId;
    }

    public List<Balance> getBalances ()
    {
        return balances;
    }

    public void setBalances ( final List<Balance> pBalances )
    {
        balances = pBalances;
    }


    public static final class Balance
    {
        private String assetType;
        private String assetCode;
        private String assetIssuer;
        private String limit;
        private String amount;

        public Balance ( final String pAssetType,
                         final String pAssetCode,
                         final String pAssetIssuer,
                         final String pLimit,
                         final String pAmount )
        {
            assetType = pAssetType;
            assetCode = pAssetCode;
            assetIssuer = pAssetIssuer;
            limit = pLimit;
            amount = pAmount;
        }

        public String getAssetType ()
        {
            return assetType;
        }

        public void setAssetType ( final String pAssetType )
        {
            assetType = pAssetType;
        }

        public String getAssetCode ()
        {
            return assetCode;
        }

        public void setAssetCode ( final String pAssetCode )
        {
            assetCode = pAssetCode;
        }

        public String getAssetIssuer ()
        {
            return assetIssuer;
        }

        public void setAssetIssuer ( final String pAssetIssuer )
        {
            assetIssuer = pAssetIssuer;
        }

        public String getLimit ()
        {
            return limit;
        }

        public void setLimit ( final String pLimit )
        {
            limit = pLimit;
        }

        public String getAmount ()
        {
            return amount;
        }

        public void setAmount ( final String pAmount )
        {
            amount = pAmount;
        }
    }
}
