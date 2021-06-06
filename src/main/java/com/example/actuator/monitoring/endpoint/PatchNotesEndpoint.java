package com.example.actuator.monitoring.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "patch-notes")
public class PatchNotesEndpoint {

    Map<String, List<String>> patchNotes = new HashMap<>();

    @PostConstruct
    public void initNotes() {
        List<String> notes = new ArrayList<>(Arrays.asList(
                "Added healthcheck for internet connection.",
                "Added custom info about user detail.",
                "HttpTrace endpoint released.",
                "Users has status attribute."));
        this.patchNotes.put("v1", notes);
    }

    @ReadOperation
    public Map<String, List<String>> getPatchNotes() {
        return this.patchNotes;
    }

    @ReadOperation
    public List<String> getNotesByVersion(@Selector String version) {
        return this.patchNotes.get(version);
    }

    @WriteOperation
    public void addPatchNotes(@Selector String version, @Selector String notes) {
        if (ObjectUtils.isEmpty(this.patchNotes.get(version))) {
            this.patchNotes.put(version, Arrays.stream(notes.split(",")).collect(Collectors.toList()));
        } else {
            this.patchNotes.get(version).addAll(Arrays.stream(notes.split(",")).collect(Collectors.toList()));
        }
    }

    @DeleteOperation
    public void deleteNotes(@Selector String version) {
        this.patchNotes.remove(version);
    }

}
