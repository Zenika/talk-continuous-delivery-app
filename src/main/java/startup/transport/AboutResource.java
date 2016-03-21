package startup.transport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by poussma on 03/03/16.
 */
@RestController
public class AboutResource {

    @Value("${git.commit.id}")
    private String commitId;

    @Value("${git.commit.time}")
    private String commitTime;

    @Value("${application.company}")
    private String company;

    @Value("${application.banner.color:#FF3399}")
    private String color;

    @RequestMapping(value = "/api/about", method = RequestMethod.GET)
    public Map<String, Object> about() {
        Map<String, Object> data = new HashMap<>();
        data.put("app.name", "The chat");
        data.put("app.build.sha1", commitId);
        data.put("app.build.date", commitTime);
        data.put("app.company", company);
        data.put("app.banner.color", color);
        return data;
    }
}
