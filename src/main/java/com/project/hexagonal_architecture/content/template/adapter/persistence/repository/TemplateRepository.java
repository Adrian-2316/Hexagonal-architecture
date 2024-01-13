package com.project.hexagonal_architecture.content.template.adapter.persistence.repository;

import com.project.hexagonal_architecture.content.template.adapter.persistence.entity.TemplateEntity;
import com.project.hexagonal_architecture.content.template.application.port.out.TemplateRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;


@ApplicationScoped
public class TemplateRepository implements TemplateRepositoryPort {

    @Inject
    EntityManager entityManager;

    @Override
    public TemplateEntity get(Long id) {
        return entityManager.getReference(TemplateEntity.class, id);
    }

    @Override
    public TemplateEntity create(TemplateEntity template) {
        entityManager.persist(template);
        return template;
    }

    @Override
    public TemplateEntity update(Long id, TemplateEntity template) {
        TemplateEntity savedEntity = get(id);
        // Update mappers here
        entityManager.merge(template);
        entityManager.flush();
        return savedEntity;
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(get(id));
    }
}
