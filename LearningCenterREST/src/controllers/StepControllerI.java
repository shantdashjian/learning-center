package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Step;

public interface StepControllerI {
//  GET /course/{cid}/step
    public Collection<Step> index(HttpServletRequest req, HttpServletResponse res, int cid);
    
//  GET /course/{cid}/step/sid
    public Step show(HttpServletRequest req, HttpServletResponse res, int cid, int sid);
}