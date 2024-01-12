package com.project.hexagonal_architecture.content.template.application.port.out;


import com.project.hexagonal_architecture.content.template.adapter.persistence.entity.TemplateEntity;

public interface TemplateRepositoryPort {
    TemplateEntity get(Long id);

    TemplateEntity create(TemplateEntity template);

    TemplateEntity update(Long id, TemplateEntity template);

    void delete(Long id);
}
