package io.github.erfangc.raincove.sdk.models;


public class GetRoleBindingResponse {

    private RoleBinding roleBinding;

    public RoleBinding getRoleBinding() {
        return this.roleBinding;
    }

    public GetRoleBindingResponse setRoleBinding(RoleBinding roleBinding) {
        this.roleBinding = roleBinding;
        return this;
    }

}