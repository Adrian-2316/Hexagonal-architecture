package com.project.hexagonal_architecture.content.template.adapter.rest.controller;

import com.project.hexagonal_architecture.content.template.adapter.rest.dto.in.TemplateInDto;
import com.project.hexagonal_architecture.content.template.adapter.rest.dto.out.TemplateOutDto;
import com.project.hexagonal_architecture.content.template.adapter.rest.mapper.TemplateDtoMapper;
import com.project.hexagonal_architecture.content.template.application.port.in.TemplatePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Template")
@Path("api/template")
@ApplicationScoped
public class TemplateController {
    @Inject
    TemplatePort templatePort;

    @Inject
    TemplateDtoMapper mapper;

    @GET
    @Path("{id}")
    @Operation(summary = "Get a Template entity.")
    public TemplateOutDto get(@PathParam("id") Long id) {
        return mapper.toDto(templatePort.get(id));
    }

    @POST
    @Operation(summary = "Create a Template entity.")
    public TemplateOutDto create(
            @RequestBody(description = "Template data object", required = true)
            TemplateInDto template) {
        return mapper.toDto(templatePort.create(mapper.toDomainModel(template)));
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update a Template entity.")
    public TemplateOutDto put(
            @PathParam("id") Long id,
            @RequestBody(description = "Template data object", required = true)
            TemplateInDto template) {
        return mapper.toDto(templatePort.update(id, mapper.toDomainModel(template)));
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a Template entity.")
    public void delete(@PathParam("id") Long id) {
        templatePort.delete(id);
    }
}
