package model;

import java.io.Serializable;

/**
 * Created by igor on 20.11.16.
 */
public interface Persistable<ID extends Serializable> extends Serializable{
    ID getId();
}

