package by.teachmeskills.jdbc.entity;

public abstract class Entity implements IEntity {

    protected Long id;

    public Entity(Long id) {
        this.id = id;
    }

    public Entity() {
    }

    @Override
    public Long getId() {
        return id;
    }
}
