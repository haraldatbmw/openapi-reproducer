package de.quarkus.reproducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema
public class MessageDataItems<T> {
    private List<T> items;

    public MessageDataItems() {
    }

    public MessageDataItems(List<T> items) {
        this.items = new ArrayList<T>(items);
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void setItems(List<T> items) {
        this.items = new ArrayList<T>(items);
    }

    @Schema(example = "1")
    public int getCurrentItemCount() {
        return (items == null) ? 0 : items.size();
    }
}
