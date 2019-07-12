package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class GetRoleBindingsResponse {

    private List<RoleBinding> roleBindings;

    public List<RoleBinding> getRoleBindings() {
        return this.roleBindings;
    }

    public GetRoleBindingsResponse setRoleBindings(List<RoleBinding> roleBindings) {
        this.roleBindings = roleBindings;
        return this;
    }

}