package service;

import bl.Util;
import dao.PaperDAO;
import entity.Paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaperService extends Util implements PaperDAO {

    Connection connection = getConnection();

    @Override
    public void add(Paper paper) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PAPER (ID, NAME, WEIGHT) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong   (1, paper.getId());
            preparedStatement.setString (2, paper.getName());
            preparedStatement.setLong   (3, paper.getWeight());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Paper> getAll() {
        return null;
    }

    @Override
    public Paper getById(Long id) {
        return null;
    }

    @Override
    public void update(Paper paper) {

    }

    @Override
    public void remove(Paper paper) {

    }
}