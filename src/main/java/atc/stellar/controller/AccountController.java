package atc.stellar.controller;

import atc.stellar.model.Account;
import atc.stellar.model.KeyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stellar.sdk.KeyPair;
import org.stellar.sdk.Server;
import org.stellar.sdk.responses.AccountResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping ( value = "/accounts" )
public class AccountController
{
    private static final Logger logger = LoggerFactory.getLogger( AccountController.class );

    @RequestMapping ( method = RequestMethod.POST )
    public String createAccount ( @RequestBody final KeyData keyData ) throws IOException
    {
        final KeyPair pair = KeyPair.fromAccountId( keyData.getAccountId() );

        final String friendbotUrl = String.format(
              "https://horizon-testnet.stellar.org/friendbot?addr=%s",
              pair.getAccountId() );

        String body = "";
        try ( InputStream response = new URL( friendbotUrl ).openStream();
              Scanner scanner = new Scanner( response, "UTF-8" ).useDelimiter( "\\A" ) )
        {
            while ( scanner.hasNext() )
            {
                body = scanner.next();
            }
        }

        logger.info( "SUCCESS! You have a new account : {}", body );

        return body;
    }


    @RequestMapping ( value = { "{accountId}" }, method = RequestMethod.GET )
    public Account getAccount ( @PathVariable final String accountId ) throws IOException
    {
        final KeyPair pair = KeyPair.fromAccountId( accountId );

        final Server server = new Server( "https://horizon-testnet.stellar.org" );
        final AccountResponse accountResponse = server.accounts().account( pair );

        final Account account = new Account();
        account.setAccountId( pair.getAccountId() );

        logger.info( "Balances for account {}", pair.getAccountId() );
        final List<Account.Balance> accountBalances = new ArrayList<>();
        for ( final AccountResponse.Balance balance : accountResponse.getBalances() )
        {
            logger.info( "Type: {}, Code: {}, Balance: {}",
                         balance.getAssetType(),
                         balance.getAssetCode(),
                         balance.getBalance() );

            final Account.Balance accountBalance = new Account.Balance( balance.getAssetType(),
                                                                        balance.getAssetCode(),
                                                                        null,
                                                                        balance.getLimit(),
                                                                        balance.getBalance() );
            accountBalances.add( accountBalance );
        }
        account.setBalances( accountBalances );

        return account;
    }
}
