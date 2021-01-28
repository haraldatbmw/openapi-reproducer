package de.quarkus.reproducer;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Path("/animals")
public class AnimalsResource {

    private static List<Animal> animals = List.of(new Animal("Leo", 42) ,new Animal("Pia", 23));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalListEnvelope getAnimals() {
        return new AnimalListEnvelope(animals);
    }

    @Schema
    @RegisterForReflection
    public static class AnimalListEnvelope extends MessageData<MessageDataItems<Animal>> {
        public AnimalListEnvelope() {} 
        public AnimalListEnvelope(List<Animal> animals) {
            super(new MessageDataItems<Animal>(animals));
        }
    }
}