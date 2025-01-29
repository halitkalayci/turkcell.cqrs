package com.turkcell.turkcellcqrs.core.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest {
    List<String> getRequiredRoles();
}
