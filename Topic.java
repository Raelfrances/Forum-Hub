@Entity
public class Topic {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String course;
    private String author;
}
