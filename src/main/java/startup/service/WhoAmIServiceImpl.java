package startup.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by poussma on 23/03/16.
 */
@Service
public class WhoAmIServiceImpl implements WhoAmIService {

    private String hostname;

    @PostConstruct
    public void init() {
        try {
            // does not work on windows...
            hostname = new String(Files.readAllBytes(Paths.get("/etc/hostname"))).trim();
        } catch (IOException e) {
            throw new IllegalArgumentException("schizophrenia on its way, or you are using windows", e);
        }
    }

    @Override
    public String tellMe() {
        return hostname;
    }
}
