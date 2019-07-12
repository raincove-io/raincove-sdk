package io.github.erfangc.raincove.sdk.models;


public class CreateOrUpdateRoleBindingRequest {

    private RoleBinding roleBinding;

    public RoleBinding getRoleBinding() {
        return this.roleBinding;
    }

    public CreateOrUpdateRoleBindingRequest setRoleBinding(RoleBinding roleBinding) {
        this.roleBinding = roleBinding;
        return this;
    }

}