package consumer.enities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.DocFlavor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wikimedia_recent_change")
public class WikimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Lob  // to store large objects we use @Lob
    private String wikiEventData;
}


