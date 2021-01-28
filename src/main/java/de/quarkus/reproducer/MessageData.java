package de.quarkus.reproducer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Schema
@RegisterForReflection
public class MessageData<T> extends MessageBase {

    @Valid
    @NotNull(message = "data must not be empty")
    @Schema(description = "The business data object")
    private T data;

    public MessageData() {
    }

    public MessageData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Schema(description = "The class-name of the business data object")
    public String getKind() {
        if (data == null) {
            return null;
        } else {
            return data.getClass()
                       .getSimpleName();
        }
    }

}
