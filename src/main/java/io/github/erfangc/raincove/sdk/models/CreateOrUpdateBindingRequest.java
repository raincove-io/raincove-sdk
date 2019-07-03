package io.github.erfangc.raincove.sdk.models;


public class CreateOrUpdateBindingRequest {

    private Binding roleBinding;

    public Binding getRoleBinding() {
        return this.roleBinding;
    }

    public CreateOrUpdateBindingRequest setRoleBinding(Binding roleBinding) {
        this.roleBinding = roleBinding;
        return this;
    }

}