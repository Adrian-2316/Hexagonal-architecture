package com.project.hexagonal_architecture.shared.mapping;

import com.project.hexagonal_architecture.content.template.adapter.rest.mapper.TemplateDtoMapper;
import com.project.hexagonal_architecture.content.template.application.mapper.TemplateDomainMapper;
import org.mapstruct.MapperConfig;

import static org.mapstruct.MappingConstants.ComponentModel.CDI;
import static org.mapstruct.ReportingPolicy.IGNORE;

@MapperConfig(
        uses = {
                TemplateDtoMapper.class,
                TemplateDomainMapper.class
        },
        unmappedTargetPolicy = IGNORE,
        componentModel = CDI,
        disableSubMappingMethodsGeneration = true)
public interface CentralizedMappingStrategy {
}
