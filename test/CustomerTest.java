import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {

	private static final String GOLD_PATH = "test/data";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Regular("Monty Python and the Holy Grail");
	private Movie ran = new Regular("Ran");
	private Movie la = new NewRelease("LA Confidential" );
	private Movie trek = new NewRelease("Star Trek 13.2");
	private Movie wallace = new Childrens("Wallace and Gromit");

    @Before
    public void setUp (){
       dinsdale.addRental(new Rental(python, 3));
       dinsdale.addRental(new Rental(ran, 1));
       dinsdale.addRental(new Rental(la, 2));
       dinsdale.addRental(new Rental(trek, 1));
       dinsdale.addRental(new Rental(wallace, 6));
   }

    @Test
    public void testEmpty() throws Exception {
    	dinsdale = new Customer("Dinsdale Pirhana");
        equalsFile("1st Output", "outputEmpty", dinsdale.statement());
    }

    @Test
    public void testCustomer() throws Exception {
        equalsFile("1st Output", "output1", dinsdale.statement());
    }

    @Test
    public void testChange() throws Exception {
        dinsdale.setRental(2, new Regular("LA Confidential"), 2);
        equalsFile("1st Output", "outputChange", dinsdale.statement());
    }

    private void equalsFile(String message, String fileName, String actualValue) throws IOException{
        BufferedReader file = new BufferedReader (new FileReader (GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine = null;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }

}
