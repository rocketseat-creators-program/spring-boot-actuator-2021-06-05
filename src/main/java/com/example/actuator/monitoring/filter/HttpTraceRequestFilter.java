package com.example.actuator.monitoring.filter;

import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Component
public class HttpTraceRequestFilter extends HttpTraceFilter {

    public HttpTraceRequestFilter(HttpTraceRepository repository, HttpExchangeTracer tracer) {
        super(repository, tracer);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("actuator");
    }

}
