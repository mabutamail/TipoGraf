package dao;

import entity.Paper;

import java.util.List;

public interface PaperDAO {

    //create
    void add(Paper paper);

    //read
    List<Paper> getAll();
    Paper getById(Long id);

    //update
    void update(Paper paper);

    //delete
    void remove(Paper paper);

}
