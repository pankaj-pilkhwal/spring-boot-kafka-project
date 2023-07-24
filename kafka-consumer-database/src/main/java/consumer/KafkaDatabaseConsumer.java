package consumer;


import consumer.enities.WikimediaEntity;
import consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaDatabaseConsumer {
    private static final Logger  LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }


    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s",eventMessage));

        WikimediaEntity  wikimediaEntity = new WikimediaEntity();
        wikimediaEntity.setWikiEventData(eventMessage.substring(0,255));

        wikimediaRepository.save(wikimediaEntity);
    }
}
