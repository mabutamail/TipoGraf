package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.models.Client;

import java.util.List;

public interface Dao {

    public void create(Client client);
    public Client read(Client client);
    public void update(Client client);
    public void delete(Client client);
    public List<Client> getAll();

//public interface Dao <T, PK extends Serializable> {
//    /** Сохранить объект newInstance в базе данных */
//    PK create(T newInstance);
//
//    /** Извлечь объект, предварительно сохраненный в базе данных, используя
//     *   указанный id в качестве первичного ключа
//     */
//    T read(PK id);
//
//    /** Сохранить изменения, сделанные в объекте.  */
//    void update(T transientObject);
//
//    /** Удалить объект из базы данных */
//    void delete(T persistentObject);

}
