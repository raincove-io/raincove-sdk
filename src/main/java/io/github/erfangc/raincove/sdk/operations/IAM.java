package io.github.erfangc.raincove.sdk.operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.erfangc.raincove.sdk.models.GetRoleBindingsResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleBindingRequest;
import io.github.erfangc.raincove.sdk.models.AuthorizeResponse;
import io.github.erfangc.raincove.sdk.models.DeleteRoleResponse;
import io.github.erfangc.raincove.sdk.models.GetRoleResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleBindingResponse;
import io.github.erfangc.raincove.sdk.models.GetAllRolesResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleRequest;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateRoleResponse;
import io.github.erfangc.raincove.sdk.models.GetRoleBindingResponse;
import io.github.erfangc.raincove.sdk.models.DeleteRoleBindingResponse;

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
    GetRoleBindingsResponse getRoleBindings(@Param("roleId") String roleId);

    @RequestLine("POST /role-bindings")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    CreateOrUpdateRoleBindingResponse createOrUpdateRoleBinding(CreateOrUpdateRoleBindingRequest body);

    @RequestLine("GET /role-bindings/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetRoleBindingResponse getRoleBinding(@Param("id") String id);

    @RequestLine("DELETE /role-bindings/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteRoleBindingResponse deleteRoleBinding(@Param("id") String id);

    @RequestLine("GET /_authorize")
    @Headers({"Content-Type: application/json", "Accept: application/json", "X-Auth-Request-Redirect: {xAuthRequestRedirect}", "X-Original-Method: {xOriginalMethod}"})
    AuthorizeResponse authorizeRequest(@Param("xAuthRequestRedirect") String xAuthRequestRedirect, @Param("xOriginalMethod") String xOriginalMethod);

}