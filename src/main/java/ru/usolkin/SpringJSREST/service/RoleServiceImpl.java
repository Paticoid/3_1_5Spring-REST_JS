package ru.usolkin.SpringJSREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usolkin.SpringJSREST.dao.RoleDao;
import ru.usolkin.SpringJSREST.model.Role;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDao roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDAO.getRoleList();
    }

}
