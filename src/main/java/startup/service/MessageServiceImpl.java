package startup.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import startup.business.Message;
import startup.dao.MessageDao;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by poussma on 03/03/16.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao dao;

    @Value("${git.closest.tag.name}")
    private String gitTagName;

    @Value("${git.commit.id}")
    private String gitCommit;

    @PostConstruct
    public void ready() {
        String hostname = "N/A";
        try {
            Process p = Runtime.getRuntime().exec("hostname");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            hostname = "";
            while ((line = input.readLine()) != null) {
                hostname += line;
            }
        } catch (IOException e) {
            // swallowed, don't tell anyone !
        }

        Message message = new Message();
        message.setOwner("system (" + hostname + ")");
        message.setMessage("Now running " + gitTagName + " #" + gitCommit);
        send(message);
    }

    @Override
    public long getLatestMessageId() {
        return dao.getLatestMessageId();
    }

    @Override
    public List<Message> getMessagesFromId(long id) {
        return dao.findByIdGreaterThan(id);
    }

    @Override
    public void send(Message message) {
        // sanity check
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        LocalDateTime now = LocalDateTime.now();
        message.setDate(now.format(DateTimeFormatter.ISO_DATE_TIME));

        // add-column: uncomment following lines
        //message.setDateAsDate(new Date(now.toEpochMilli()));
        dao.save(message);
    }
}
