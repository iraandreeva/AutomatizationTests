
import com.fasterxml.jackson.databind.ObjectMapper;
import framework.Account;
import framework.LoginData;
import framework.PagePersonalInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataSet {

    Collection<Account> accounts;
    Collection<LoginData> logins;
    Collection<PagePersonalInfo> personals;

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

    public void processDataFileLogin( String filePath ){

        logins = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LoginData login = objectMapper.readValue( new File( filePath ), LoginData.class );
            logins.add( login );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getDataLogin() {

        Object[][] data = new Object[ logins.size() ][ 1 ];

        Iterator<LoginData> it = logins.iterator();

        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }

    public void processDataFilePersonal( String filePath ){

        personals = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PagePersonalInfo personal = objectMapper.readValue( new File( filePath ), PagePersonalInfo.class );
            personals.add( personal );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getDataPersonal() {

        Object[][] data = new Object[ personals.size() ][ 1 ];

        Iterator<PagePersonalInfo> it = personals.iterator();

        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }
}
