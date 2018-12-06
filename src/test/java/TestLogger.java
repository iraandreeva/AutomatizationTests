import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLogger {

    private static final Logger LOGGER = LogManager.getLogger( TestLogger.class.getName() );

    @Test
    public void testLogger() {

        LOGGER.debug( "Debug Message Logged !!!" );
        LOGGER.info( "Info Message Logged !!!" );


        LOGGER.error( "Error Message Logged !!!", new NullPointerException( "NullError" ) );

    }
}
