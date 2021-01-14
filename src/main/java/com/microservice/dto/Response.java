package com.microservice.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammed Shoukath Ali
 */

@AllArgsConstructor
//@NoArgsConstructor
public class Response<D> implements Serializable {
    private String requestId = "None";
    private Date requestTime = new Date();
    private boolean errors = false;
    private List<Message> messages = new ArrayList<>();
    private D data;
    private Integer totalPages = 0;
    private Long totalElements = 0L;

    public Response() {
    }

    public Response(D data) {
        this.requestId = "None";
        this.data = data;
        requestTime = new Date();
    }

    public Response(D data, Long totalElements, Integer totalPages) {
        this.data = data;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public Response withErrors(boolean errors) {
        this.errors = errors;
        return this;
    }

    public Response withMessage(Message message) {
        this.messages.add(message);
        return this;
    }

    public Response withMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }


    public String getRequestId() {
        return this.requestId;
    }

    public Date getRequestTime() {
        return this.requestTime;
    }

    public boolean isErrors() {
        return this.errors;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public D getData() {
        return this.data;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public Long getTotalElements() {
        return this.totalElements;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setData(D data) {
        this.data = data;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public String toString() {
        return "Response(requestId=" + this.getRequestId() + ", requestTime=" + this.getRequestTime() + ", errors=" + this.isErrors() + ", messages=" + this.getMessages() + ", data=" + this.getData() + ", totalPages=" + this.getTotalPages() + ", totalElements=" + this.getTotalElements() + ")";
    }
}

