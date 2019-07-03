package io.github.erfangc.raincove.sdk.operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateBindingResponse;
import io.github.erfangc.raincove.sdk.models.AuthorizeResponse;
import io.github.erfangc.raincove.sdk.models.DeleteRoleResponse;
import io.github.erfangc.raincove.sdk.models.GetBindingsResponse;
import io.github.erfangc.raincove.sdk.models.GetBindingResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateBindingRequest;
import io.github.erfangc.raincove.sdk.models.GetRoleResponse;
import io.github.erfangc.raincove.sdk.models.DeleteBindingResponse;
import io.github.erfangc.raincove.sdk.models.GetAllRolesResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleRequest;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleResponse;

public interface IAM {

    @RequestLine("GET /roles")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetAllRolesResponse getRoles();

    @RequestLine("POST /roles")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    CreateOrUpdateRoleResponse createOrUpdateRole(CreateOrUpdateRoleRequest body);

    @RequestLine("GET /roles/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetRoleResponse getRole(@Param("id") String id);

    @RequestLine("DELETE /roles/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteRoleResponse deleteRole(@Param("id") String id);

    @RequestLine("GET /roles/{roleId}/bindings")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetBindingsResponse getBindings(@Param("roleId") String roleId);

    @RequestLine("POST /roles/{roleId}/bindings")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    CreateOrUpdateBindingResponse createOrUpdateBinding(CreateOrUpdateBindingRequest body, @Param("roleId") String roleId);

    @RequestLine("GET /roles/{roleId}/rolebindings/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetBindingResponse getBinding(@Param("roleId") String roleId, @Param("id") String id);

    @RequestLine("DELETE /roles/{roleId}/rolebindings/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteBindingResponse deleteBinding(@Param("roleId") String roleId, @Param("id") String id);

    @RequestLine("GET /_authorize")
    @Headers({"Content-Type: application/json", "Accept: application/json", "Authorization: {authorization}", "X-Original-URL: {xOriginalUrl}", "X-Original-Method: {xOriginalMethod}"})
    AuthorizeResponse authorizeRequest(@Param("authorization") String authorization, @Param("xOriginalUrl") String xOriginalUrl, @Param("xOriginalMethod") String xOriginalMethod);

}