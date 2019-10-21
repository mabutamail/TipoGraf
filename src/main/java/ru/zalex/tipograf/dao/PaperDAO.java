package ru.zalex.tipograf.dao;

import ru.zalex.tipograf.model.Paper;

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
