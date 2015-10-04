package com.springapp.mvc.dao;

import com.springapp.mvc.Model.Vare;

import java.util.List;

/**
 * Created by benny on 29.09.15.
 */
public interface VareDAO {
    public void saveOrUpdate(Vare vare);

    public void delete(int vareId);

    public Vare get(int vareId);

    public List<Vare> list();
}
