@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicRepository repository;

    public TopicController(TopicRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TopicResponse> list() {
        return repository.findAll().stream()
            .map(t -> new TopicResponse(t.getId(), t.getTitle(), t.getMessage(), t.getCourse(), t.getAuthor()))
            .toList();
    }

    @PostMapping
    public ResponseEntity<TopicResponse> create(@RequestBody @Valid TopicRequest request) {
        Topic topic = new Topic(request.getTitle(), request.getMessage(), request.getCourse(), request.getAuthor());
        repository.save(topic);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new TopicResponse(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCourse(), topic.getAuthor()));
    }
}
