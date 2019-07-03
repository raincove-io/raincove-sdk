package io.github.erfangc.raincove.sdk.models;


public class GetBindingResponse {

    private Binding roleBinding;

    public Binding getRoleBinding() {
        return this.roleBinding;
    }

    public GetBindingResponse setRoleBinding(Binding roleBinding) {
        this.roleBinding = roleBinding;
        return this;
    }

}