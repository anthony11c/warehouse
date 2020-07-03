package com.example.partsUnlimited.service;

import com.example.partsUnlimited.dao.ActionDao;
import com.example.partsUnlimited.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    private final ActionDao actionDao;

    @Autowired
    public ActionService(@Qualifier("action") ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    public int addAction(Action action){
        return actionDao.insertAction(action);
    }
}
