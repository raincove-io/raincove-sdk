package io.github.erfangc.raincove.sdk.models;


public class CreateOrUpdateBindingRequest {

    private Binding binding;

    public Binding getBinding() {
        return this.binding;
    }

    public CreateOrUpdateBindingRequest setBinding(Binding binding) {
        this.binding = binding;
        return this;
    }

}