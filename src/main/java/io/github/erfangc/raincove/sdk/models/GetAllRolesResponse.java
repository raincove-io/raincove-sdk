package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class GetAllRolesResponse {

    private List<Role> roles;

    public List<Role> getRoles() {
        return this.roles;
    }

    public GetAllRolesResponse setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

}