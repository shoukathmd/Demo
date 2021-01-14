package com.microservice.controller;



import java.io.Serializable;

/**
 * @author Mohammed Shoukath Ali
 */
public abstract class BaseController<D, ID extends Serializable> {

    public static final String API_BASE = "/api/v1";
    public static final String TEAM_STANDING = API_BASE + "/team-standing";

}
