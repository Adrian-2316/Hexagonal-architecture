package com.project.hexagonal_architecture.content.template.application.mapper;

import com.project.hexagonal_architecture.content.template.adapter.persistence.entity.TemplateEntity;
import com.project.hexagonal_architecture.content.template.domain.Template;
import com.project.hexagonal_architecture.shared.mapping.CentralizedMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(config = CentralizedMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface TemplateDomainMapper {

    TemplateEntity toEntity(Template template);

    Template toDomainModel(TemplateEntity template);
}
