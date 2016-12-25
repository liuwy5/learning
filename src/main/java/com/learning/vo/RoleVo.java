package com.learning.vo;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
public class RoleVo {
    private Integer id;

    private String uuid;

    private String roleName;

    private List<String> privilegeUuidList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getPrivilegeUuidList() {
        return privilegeUuidList;
    }

    public void setPrivilegeUuidList(List<String> privilegeUuidList) {
        this.privilegeUuidList = privilegeUuidList;
    }
}
