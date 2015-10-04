package com.springapp.mvc.dao;

import com.springapp.mvc.Model.Vare;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by benny on 29.09.15.
 */
public class VareDAOImpl implements VareDAO {

    private JdbcTemplate jdbcTemplate;

    public VareDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }




    @Override
    public void saveOrUpdate(Vare vare){
        if(vare.getId() > 0){
            //Oppdatere hvis id er høgere enn 0
            String sql = "UPDATE vare SET navn=?, pris=? WHERE vare_id=?";
            jdbcTemplate.update(sql, vare.getNavn(), vare.getPris(), vare.getId());
        } else {
           //Legge til om id er 0
            String sql = "INSERT INTO vare (navn, pris)" + " VALUES (?,?)";
            jdbcTemplate.update(sql, vare.getNavn(), vare.getPris());
        }

    }

    //impl for å slette varer
    @Override
    public void delete(int vareId){
        String sql = "DELETE FROM vare WHERE vare_id=?";
        jdbcTemplate.update(sql, vareId);
    }



    //impl for å liste alle varene
    @Override
    public List<Vare> list(){
        String sql = "SELECT * FROM vare";
        List<Vare> listVare = jdbcTemplate.query(sql, new RowMapper<Vare>() {

            @Override
            public Vare mapRow(ResultSet rs, int rowNum) throws SQLException {
                Vare aVare = new Vare();

                aVare.setId(rs.getInt("vare_id"));
                aVare.setNavn(rs.getString("navn"));
                aVare.setPris(rs.getInt("pris"));
                return aVare;
            }

        });

        return listVare;
    }

    //Hente varen med gitt id
    @Override
    public Vare get(int vareId){

        String sql = "SELECT * FROM vare WHERE vare_id=" + vareId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Vare>() {

            @Override
            public Vare extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Vare vare = new Vare();
                    vare.setId(rs.getInt("vare_id"));
                    vare.setNavn(rs.getString("navn"));
                    vare.setPris(rs.getInt("pris"));

                    return vare;
                }

                return null;
            }

        });
    }


}
