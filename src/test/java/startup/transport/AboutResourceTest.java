package startup.transport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import startup.Application;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by poussma on 03/03/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@PropertySource("application.properties")
public class AboutResourceTest {

    @Autowired
    private AboutResource resource;

    //@Test
    public void testFunkyName() {
        Map<String, Object> about = resource.about();

        assertThat("Information about me can't be null", about, notNullValue());

        String company = (String) about.get("app.company");
        assertThat("Name of the company can't be null", company, notNullValue());
        assertThat("Local name is required to rocks the world !", company, containsString("bzh"));
        assertThat("Funky name is required to rocks the world !", company, containsString("funk"));
    }

}