package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class GetBindingsResponse {

    private List<Binding> roleBindings;

    public List<Binding> getRoleBindings() {
        return this.roleBindings;
    }

    public GetBindingsResponse setRoleBindings(List<Binding> roleBindings) {
        this.roleBindings = roleBindings;
        return this;
    }

}