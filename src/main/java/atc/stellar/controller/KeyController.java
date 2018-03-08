package atc.stellar.controller;

import atc.stellar.model.KeyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stellar.sdk.KeyPair;

@RestController
@RequestMapping ( value = "/keys" )
public class KeyController
{
    private static final Logger logger = LoggerFactory.getLogger( KeyController.class );

    @RequestMapping ( value = "/", method = RequestMethod.POST )
    public KeyData createKey ()
    {
        final KeyPair pair = KeyPair.random();

        final KeyData keyData = new KeyData();

        keyData.setSecretSeed( pair.getSecretSeed() );
        logger.info( "Secret seed : {}", pair.getSecretSeed() );

        keyData.setAccountId( pair.getAccountId() );
        logger.info( "Account id : {}", pair.getAccountId() );

        return keyData;
    }
}
