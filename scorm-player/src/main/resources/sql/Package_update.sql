UPDATE Package SET
    defaultOrganizationID = :e.defaultOrganizationIdentifier,
    title = :e.title,
    base = :e.base,
    resourcesBase = :e.resourcesBase,
    summary = :e.summary
WHERE id = :id