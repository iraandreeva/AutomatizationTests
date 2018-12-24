package framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.model.Account;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataSet {

    Collection<Account> accounts;

    public void processDataFileAccount( String filePath ){

        accounts = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Account account = objectMapper.readValue( new File( filePath ), Account.class );
            accounts.add( account );
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getDataAccount() {

        Object[][] data = new Object[ accounts.size() ][ 1 ];

        Iterator<Account> it = accounts.iterator();

        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }
}
