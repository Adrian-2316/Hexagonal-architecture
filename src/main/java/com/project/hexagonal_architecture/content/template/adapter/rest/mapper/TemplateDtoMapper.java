package com.project.hexagonal_architecture.content.template.adapter.rest.mapper;

import com.project.hexagonal_architecture.content.template.adapter.rest.dto.in.TemplateInDto;
import com.project.hexagonal_architecture.content.template.adapter.rest.dto.out.TemplateOutDto;
import com.project.hexagonal_architecture.content.template.domain.Template;
import com.project.hexagonal_architecture.shared.mapping.CentralizedMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(config = CentralizedMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface TemplateDtoMapper {

    Template toDomainModel(TemplateInDto template);

    TemplateOutDto toDto(Template template);
}
