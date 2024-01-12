package com.project.hexagonal_architecture.content.template.application.port.in;

import com.project.hexagonal_architecture.content.template.domain.Template;

public interface TemplatePort {

    Template get(Long id);

    Template create(Template template);

    Template update(Long id, Template template);

    void delete(Long id);

}
