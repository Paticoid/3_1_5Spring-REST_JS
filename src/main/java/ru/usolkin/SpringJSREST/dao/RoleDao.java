package ru.usolkin.SpringJSREST.dao;




import ru.usolkin.SpringJSREST.model.Role;

import java.util.List;

public interface RoleDao {
    public Role showRole(String name);
    public List<Role> getRoleList();
    public void save(Role role);
    public Role getIdRole(long id);
}
