package sk.upjs.paz1c.homer.entity;


public interface StorableEntity {

    public void setId(Long id);
    
    default Long getId() {
        return 0L;
    }

    public void setStatus(Integer status);
    
    default Integer getStatus() {
        return -1;
    }
}
