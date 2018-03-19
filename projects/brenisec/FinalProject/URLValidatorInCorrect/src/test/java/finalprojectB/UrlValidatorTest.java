
package finalprojectB;

//import com.sun.xml.internal.bind.v2.util.StackRecorder;

import junit.framework.TestCase;
import java.util.Random;

import java.net.URI;
import java.util.ArrayList;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {


    public UrlValidatorTest(String testName) {
        super(testName);
    }

    public void testManualTest() {
        System.out.print("Test output for testMaunualTest:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(urlVal.isValid("htps://www.google.com"));
        assertTrue(urlVal.isValid("http://www.github.com"));
        assertTrue(urlVal.isValid("http://github.com/Brenisec/CS362-001-W2018"));
        assertTrue(urlVal.isValid("https://www.youtube.com/watch?v=IjWfwkLSKtA"));
        assertTrue(urlVal.isValid("http://www.google.com/search?name=Dude+whares+my+car#where'sYou'reCarDude"));
        assertFalse(urlVal.isValid("http:/google.com"));
        assertTrue(urlVal.isValid("http://facebook.com/"));
        assertFalse(urlVal.isValid("http://google.com/search Stuff?name=stuff"));

    }

    public void testPartitionSchemes() {
        //tests: ftp, gopher, http, mailto, news, https, file, telnet,
        System.out.print("Test output for testPartitionSchemes:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("ftp://example.org/resource.txt"));
        assertTrue(urlVal.isValid("gopher://gopher.cc.lehigh.edu/"));
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("mailto:gilesni@oregonstate.edu"));
        assertTrue(urlVal.isValid("news:comp.infosystem.www.server.unix"));
        assertTrue(urlVal.isValid("file://usr/share/doc"));
        assertTrue(urlVal.isValid("https://github.com"));
        assertTrue(urlVal.isValid("telnet://ns.cc.lehigh.edu/"));
    }

    public void testPartitionAuthority() {
        System.out.print("Test output for testPartitionAuthority:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("http://google.com"));

        assertFalse(urlVal.isValid("http://bad.authority/"));
        assertFalse(urlVal.isValid("http:///"));

        assertTrue(urlVal.isValid("https://www.google.com"));
        assertTrue(urlVal.isValid("https://www.github.com/brenisec/testRepo"));

        assertFalse(urlVal.isValid("https://bad.authority/"));
        assertFalse(urlVal.isValid("https:///"));

        assertTrue(urlVal.isValid("file:///c:/Programs/Java/Test"));
        assertTrue(urlVal.isValid("file:///Z:/cs362/CS362-001-W2018/projects/brenisec/FinalProject/URLValidatorInCorrect/target/site/cobertura/index.html"));
    }

    public void testPartitionPath() {
        System.out.print("Test output for testPartitionPath:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("http://github.com/ThatThing?name=ferret#nose"));
        assertTrue(urlVal.isValid("http://github.com/That/Thing?name=ferret#nose"));
        assertTrue(urlVal.isValid("http://github.com/That~Thing?name=ferret#nose"));
        assertTrue(urlVal.isValid("http://github.com/That@Thing?name=ferret#nose"));
        assertTrue(urlVal.isValid("http://github.com/That#Thing?name=ferret#nose"));
        assertTrue(urlVal.isValid("http://github.com/That&Thing?name=ferret#nose"));
    }

    public void testPartitionFragment() {
        System.out.print("Test output for testPartitionFragment:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("http://github.com/search?utf8=%E2%9C%93&q=gilesni&type="));
        assertTrue(urlVal.isValid("http://github.com/search?utf8=%E2%9C%93&q=gilesni&type=###################"));
        assertTrue(urlVal.isValid("http://github.com/search?utf8=%E2%9C%93&q=gilesni&type=#refinedSearch"));
        assertTrue(urlVal.isValid("http://github.com/search?utf8=%E2%9C%93&q=gilesni&type=#"));
    }

    public void testPartitionSpacing() {
        System.out.print("Test output for testPartitionSpacing:\n");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("http://github.com/?#"));
        assertFalse(urlVal.isValid("http://github.com/ ?#"));
        assertFalse(urlVal.isValid("http://github.com/? #"));
        assertTrue(urlVal.isValid("http://github.com /?#"));

    }

    //You need to create more test cases for your Partitions if you need to

    public void testIsValid() {
        //You can use this function for programming based testing
        boolean valid ;
        int chooser;
        long seed = System.currentTimeMillis();
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        Random random = new Random(seed);
        StringBuilder buffer;
        String test;
        for(int i = 0; i < 20; i++) {
            buffer = new StringBuilder();
            test = null;
            buffer.append("http://");
            chooser = random.nextInt(3);
            buffer.append((testUrlAuthority[chooser]).item);
            chooser = random.nextInt(4);
            buffer.append((testUrlPath[chooser]).item);
            chooser = random.nextInt(3);
            buffer.append((testUrlQuery[chooser]).item);
            chooser = random.nextInt(3);
            buffer.append((testUrlFragment[chooser]).item);
            test = buffer.toString();

            valid = urlVal.isValid(test);
            if(!valid){
                System.out.print("This URL: " + test + " was false\n");
            }
        }

    }

    ResultPair[] testUrlAuthority = {
            new ResultPair( "www.google.com/", true),
            new ResultPair( "www.oregonstate.edu/", true),
            new ResultPair( "www.oregon.gov/", true),
    };

    ResultPair[] testUrlPath = {
            new ResultPair("folder/subfolder", true),
            new ResultPair( "stuff", true),
            new ResultPair( "this-or-that", true),
            new ResultPair( "", true),
    };

    ResultPair[] testUrlQuery = {
            new ResultPair( "?sort=none", true),
            new ResultPair( "?q=android&sort=none", true),
            new ResultPair( "", true),
    };

    ResultPair[] testUrlFragment = {
            new ResultPair( "#nose", true),
            new ResultPair( "# ", true),
            new ResultPair( "", true),
    };
}
