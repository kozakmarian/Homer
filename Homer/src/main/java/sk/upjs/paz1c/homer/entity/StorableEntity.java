package sk.upjs.paz1c.homer.entity;

import sk.upjs.paz1c.homer.Status;


public interface StorableEntity {

    public void setId(Long id);
    
    default Long getId() {
        return 0L;
    }

    public void setStatus(Status status);
    
    default Status getStatus() {
        return Status.INVALID;
    }
}
