package de.quarkus.reproducer;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Schema
@RegisterForReflection
public class MessageBase {

    private static final ThreadLocal<String> contextThreadLocal = new ThreadLocal<String>();

    @Schema(description = "The API version", example = "v3")
    protected String apiVersion = "v3";

    @Schema(description = "Unique request-id (used for logging)", example = "F176f717c7a71")
    protected String requestId;

    @Schema(description = "Optional context-value for request/response correlation")
    protected String context;

    protected MessageBase() {
    }
    
    public static String getRequestContext() {
        return contextThreadLocal.get();
    }
    
    public static void setRequestContext(String ctx) {
        contextThreadLocal.set(ctx);
    }
    
    public static void removeRequestContext() {
        contextThreadLocal.remove();
    }
    
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String id) {
        this.requestId = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

}
