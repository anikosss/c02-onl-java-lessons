package by.teachmeskills.jdbc.entity;

public abstract class Entity implements IEntity {

    protected Long id;
    private Long timestamp;

    public Entity(Long id) {
        this.id = id;
    }

    public Entity(Long id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Entity() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }
}
