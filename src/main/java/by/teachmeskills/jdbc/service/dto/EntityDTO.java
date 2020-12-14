package by.teachmeskills.jdbc.service.dto;

public abstract class EntityDTO {

    protected Long id;
    protected Long timestamp;

    public EntityDTO(Long id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
