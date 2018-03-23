package com.peony.peonydata.key.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.key.dao.IdMapper;
import com.peony.peonydata.key.model.KeyGen;

@Service
public class IdServiceImpl implements IdService {
    @Resource
    private IdMapper idMapper; // id mapper

    @Override
    public int NextKey(String keyname) {
        int key = KeyGen.getInstance().getNextKey(keyname, this.idMapper);
        return key;
    }

}
