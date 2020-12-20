package by.teachmeskills.jdbc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Long id;
    protected Long timestamp;

    public AbstractEntity(Long id) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }

    public AbstractEntity(Long id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public AbstractEntity() {
        this.timestamp = System.currentTimeMillis();
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
