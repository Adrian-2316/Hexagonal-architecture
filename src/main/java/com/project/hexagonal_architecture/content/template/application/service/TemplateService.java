package com.project.hexagonal_architecture.content.template.application.service;

import com.project.hexagonal_architecture.content.template.application.mapper.TemplateDomainMapper;
import com.project.hexagonal_architecture.content.template.application.port.in.TemplatePort;
import com.project.hexagonal_architecture.content.template.application.port.out.TemplateRepositoryPort;
import com.project.hexagonal_architecture.content.template.domain.Template;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TemplateService implements TemplatePort {
    @Inject
    TemplateRepositoryPort templateRepositoryPort;
    @Inject
    TemplateDomainMapper mapper;

    @Override
    @Transactional
    public Template get(Long id) {
        return mapper.toDomainModel(templateRepositoryPort.get(id));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Template create(Template template) {
        return mapper.toDomainModel(templateRepositoryPort.create(mapper.toEntity(template)));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Template update(
            Long id, Template template) {
        return mapper.toDomainModel(templateRepositoryPort.update(id, mapper.toEntity(template)));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void delete(Long id) {
        templateRepositoryPort.delete(id);
    }
}
