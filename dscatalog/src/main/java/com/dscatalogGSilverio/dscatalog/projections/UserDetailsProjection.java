package com.dscatalogGSilverio.dscatalog.projections;

public interface UserDetailsProjection {
    String getUsername();
    String getPassword();
    Long getRoleId();
    String getAuthority();

}
